#!/usr/bin/env python


# Imports
from __future__ import with_statement
import httplib
import pkg_resources
import subprocess
import sys


def attempt_import(package):
    """Attempt to import a package.

    Parameters
    ----------
    package : string
        Name of the package to install

    Returns
    -------
    status : int
        0 if successful, 1 if any import fails
    errors : tuple
        Tuple of any error from attempted imports
    resources : list
        Names of top-level resources
    """

    # Get top level resources
    resources = list(pkg_resources.get_distribution(package)._get_metadata('top_level.txt'))
    status = 0
    errors = []

    # Import all resources
    for resource in resources:
        try:
            __import__(resource)
        except Exception as e:
            status = 1
            errors.append(str(e))

    # Return status
    return status, errors, resources


def attempt_install(package, version):
    """Attempt to install a package using pip.

    Parameters
    ----------
    package : string
        Name of the package to install
    version : string
        Version of the package to install

    Returns
    -------
    status : int
        pip exit status
    stdout : string
        pip standard output
    stderr : string
        pip standard error
    """

    # Install
    install = subprocess.Popen(
        ['pip2', 'install', '{}=={}'.format(package, version)],
        stderr=subprocess.PIPE,
        stdout=subprocess.PIPE
    )

    # Wait for process to finish and get output
    stdout, stderr = install.communicate()
    status = install.returncode

    return status, stdout, stderr


def _log(package, version, key, value, client_addr):
    """Log data to a Consul key/value store.

    Parameters
    ----------
    package : string
        Name of the package for which to log the value
    version : string
        Version of the package for which to log the value
    key : string
        Key for which to log the value
    value : string
        Value being logged
    client_addr : string
        Consul client address
    """
    conn = httplib.HTTPConnection(client_addr)
    conn.request('PUT', '/v1/kv/{}/{}/{}'.format(package, version, key), body=str(value))
    conn.getresponse()
    conn.close()


def test_package_version(package, version, client_addr='127.0.0.1:8500'):
    """Test the installation of a Pypi package version.

    1. Attempt to install the package
    2. Scrape install stdout/stderr and log output with exit status
    3. Attempt to import the package
    4. Scrape import stdout/stderr and log output with exit status

    Parameters
    ----------
    package : string
        Name of the package to install
    version : string
        Version of the package to install
    client_addr : string
        Consul client address
    """

    # Install
    install_status, install_stdout, install_stderr = attempt_install(package, version)
    _log(package, version, 'install/status', install_status, client_addr)
    _log(package, version, 'install/stdout', install_stdout, client_addr)
    _log(package, version, 'install/stderr', install_stderr, client_addr)

    # Attempt to import if install succeeded
    if not install_status:
        import_status, import_errors, resources = attempt_import(package)
        _log(package, version, 'import/resources', resources, client_addr)
        _log(package, version, 'import/status', import_status, client_addr)
        _log(
            package,
            version,
            'import/errors',
            tuple(['{}=={}'.format(package, version)] + import_errors),
            client_addr
        )


def main():
    """Scrape arguments and run tests."""

    # Validate arguments
    args = sys.argv[1:]
    if len(args) != 2 and len(args) != 3:
        raise Exception('Usage: python package_test.py <package> <version> [consul addr]')

    # Parse package and version
    package, version = args[0], args[1]

    # Test package
    if len(args) == 3:
        client_addr = args[2]
        test_package_version(package, version, client_addr)
    else:
        test_package_version(package, version)


# If running as main module
if __name__ == '__main__':
    main()
