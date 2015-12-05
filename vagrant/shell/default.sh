#!/bin/bash

echo "### START default.sh ###"

# installing apache, php and sqlite
apt-key adv --keyserver keyserver.ubuntu.com --recv 7F0CEB10
echo "deb http://repo.mongodb.org/apt/debian wheezy/mongodb-org/3.0 main" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.0.list
apt-get update
apt-get dist-upgrade -y

apt-get install -y mongodb-org
apt-get install p7zip p7zip-full

7z e /home/vagrant/mongo-/dumps/data.7z

echo "### END default.sh ###"
