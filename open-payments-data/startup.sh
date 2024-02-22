#!/bin/bash
docker run --name open-payments -v $HOME/tmp/data/open-payments:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_DATABASE=open-payments-db  -d mysql:8.3.0

