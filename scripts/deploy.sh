#!/usr/bin/env bash

#mvn clean package
mvn clean package -Dmaven.test.skip

echo 'Copy files...'

scp -i ~/.ssh/computershop2-paris.pem \
    target/computershop-1.0-SNAPSHOT.jar \
    ec2-user@ec2-35-180-228-65.eu-west-3.compute.amazonaws.com:/home/ec2-user/

echo 'Restart server...'

ssh -i ~/.ssh/computershop2-paris.pem ec2-user@ec2-35-180-228-65.eu-west-3.compute.amazonaws.com << EOF
pgrep java | xargs kill -9
nohup java -jar computershop-1.0-SNAPSHOT.jar > log.txt &
EOF

echo 'Bye'

#chmod +x scripts/deploy.sh
#./scripts/deploy.sh