#!/bin/bash

version="$1"

if [ -z "$version" ]
then
    echo "Usage: build.sh image-version"
    exit 1;
else
    echo "Start building with image-version: $version"
fi

mvn clean package -pl dubbo-samples-echo-client,dubbo-samples-echo-server -am

cd dubbo-samples-echo-client

docker build -t dubbomeshtestclient:${version} .

docker tag dubbomeshtestclient:${version} reg-cnsh.cloud.alipay.com/pbyyzncn/dubbomeshtestclient:${version}

cd ../dubbo-samples-echo-server/

docker build -t dubbomeshtestserver:${version} .

docker tag dubbomeshtestserver:${version} reg-cnsh.cloud.alipay.com/pbyyzncn/dubbomeshtestserver:${version}