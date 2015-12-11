#!/bin/bash

echo "### START default.sh ###"

# installing mongodb
apt-key adv --keyserver keyserver.ubuntu.com --recv 7F0CEB10
echo "deb http://repo.mongodb.org/apt/debian wheezy/mongodb-org/3.0 main" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.0.list
apt-get update
apt-get dist-upgrade -y
apt-get install -y mongodb-org

# Setting the bind ip of mongodb to 0.0.0.0 (accessible via all interfaces)
sed -i "s/\b\([0-9]\{1,3\}\.\)\{1,3\}[0-9]\{1,3\}\b/0.0.0.0/g" /etc/mongod.conf
service mongod stop
service mongod start

# Installing 7zip
apt-get install -y p7zip p7zip-full

# Unpacking data with 1 million records
7z e /home/vagrant/mongo-dump/data.7z -aoa

# import test data records (10)
mongo --eval "db.dataRecord.drop()"
mongoimport --db testdb --collection dataRecord --type json --file /home/vagrant/mongo-dump/testdata.json --jsonArray
# TODO import 1.000.000 data records into different db

echo "### END default.sh ###"
