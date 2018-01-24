job "{{ package.bug }}_{{ package.mode }}_{{epoch}}" {

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
        memory = 4096
      }
      config {
        image = "chrisparnin/astor-d4j"
        volumes = ["{{ scripts_dir }}:/scripts", "{{ job_data_dir }}:/data"]
        command = "bash"
        args = [
          "-c",
          "/scripts/repair_user_test.sh '{{ package.bug }}' '{{package.PID}}' '{{package.BID}}' '--{{ package.mode }}' '{{package.namespace}}' '{{ consul_client_address }}:8500'"
        ]
      }
    }

  }

}
