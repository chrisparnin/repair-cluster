job "{{ package.name }}_{{ package.version }}" {

  type = "batch"
  datacenters = [ "dc1" ]

  group "default" {

    count = 1
    restart {
      attempts = 0
      mode = "fail"
    }
    task "install-and-import" {
      driver = "docker"
      resources {
        memory = 512
      }
      config {
        image = "python:2.7.13-onbuild"
        volumes = ["{{ scripts_dir }}:/scripts"]
        command = "bash"
        args = [
          "-c",
          "/scripts/package_test.py '{{ package.name }}' '{{ package.version }}' '{{ consul_client_address }}:8500'"
        ]
      }
    }

  }

}
