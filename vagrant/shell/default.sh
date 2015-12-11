#!/bin/bash

echo "### START default.sh ###"

# installing apache, php and sqlite
apt-key adv --keyserver keyserver.ubuntu.com --recv 7F0CEB10
echo "deb http://repo.mongodb.org/apt/debian wheezy/mongodb-org/3.0 main" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.0.list
apt-get update
apt-get dist-upgrade -y

apt-get install -y mongodb-org p7zip p7zip-full

sed "s/127.0.0.1/0.0.0.0/" -i /etc/mongod.conf
service mongod restart

7z e /home/vagrant/mongo-dump/data.7z

# import test data records (10)
mongoimport --db testdb --collection dataRecord --type json --file /home/vagrant/mongo-dump/testdata.json --jsonArray
# TODO import 1.000.000 data records into different db

echo "### END default.sh ###"
