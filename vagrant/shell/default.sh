#!/bin/bash

echo "### START default.sh ###"

# installing apache, php and sqlite
apt-key adv --keyserver keyserver.ubuntu.com --recv 7F0CEB10
echo "deb http://repo.mongodb.org/apt/debian wheezy/mongodb-org/3.0 main" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.0.list
apt-get update
apt-get dist-upgrade -y

apt-get install -y mongodb-org
apt-get install p7zip p7zip-full

7z e /home/vagrant/mongo-dumps/data.7z

cd /home/vagrant/mongo-dumps
# import test data records (10)
mongoimport --db testdb --collection datarecords --type json --file testdata.json --jsonArray
# TODO import 1.000.000 data records into different db

sed "s/127.0.0.1/192.168.10.200/" -i /etc/mongod.conf
service mongod restart

echo "### END default.sh ###"
