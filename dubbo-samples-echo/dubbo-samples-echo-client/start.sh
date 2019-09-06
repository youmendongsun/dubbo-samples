#!/bin/sh

export SOFA_ANTVIP_ENDPOINT=100.100.0.140
export SOFA_INSTANCE_ID=NY24NMCS0M9J
#export SOFA_ANTVIP_ENDPOINT=11.239.139.142
#export SOFA_INSTANCE_ID=000001
export SOFA_ACCESS_KEY=cPYkbIXrZHjVAxjxhm
export SOFA_SECRET_KEY=7F5k7YvUokWDAf94OhBz6Pes6W3UAGBO

java -Dcom.alipay.env=shared -Dcom.antcloud.antvip.endpoint=${SOFA_ANTVIP_ENDPOINT} -Dcom.alipay.instanceid=${SOFA_INSTANCE_ID} -Dcom.antcloud.mw.access=$SOFA_ACCESS_KEY -Dcom.antcloud.mw.secret=$SOFA_SECRET_KEY -Dmesh_http_read_timeout=600000 -Duser.timezone=Asia/Shanghai -jar /home/admin/release/dubbo-samples-echo-client-1.0-SNAPSHOT.jar
