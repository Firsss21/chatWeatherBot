#!/usr/bin/env bash
build:
	sudo mvn clean --quiet package --quiet spring-boot:repackage --quiet -Dmaven.test.skip=true
	sudo cp "target/weather.jar" "/var/www/weather/images/java/weather.jar"; \
	sudo rm -rf target
	cd /var/www/weather/ && sudo docker-compose build && sudo docker-compose up -d
