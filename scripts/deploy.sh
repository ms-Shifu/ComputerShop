#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/computershop-paris.pem \
    target/computershop-1.0-SNAPSHOT.jar \
    ec2-user@ec2-35-181-59-187.eu-west-3.compute.amazonaws.com:/home/ec2-user/

echo 'Restart server...'

ssh -i ~/.ssh/computershop-paris.pem ec2-user@ec2-35-181-59-187.eu-west-3.compute.amazonaws.com << EOF
pgrep java | xargs kill -9
nohup java -jar computershop-1.0-SNAPSHOT.jar > log.txt &
EOF

echo 'Bye'