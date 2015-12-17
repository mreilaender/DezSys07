#!/bin/bash

echo "### START default.sh ###"

# installing mongodb
apt-key adv --keyserver keyserver.ubuntu.com --recv 7F0CEB10
echo "deb http://repo.mongodb.org/apt/debian wheezy/mongodb-org/3.0 main" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.0.list
apt-get update
apt-get install -y mongodb-org

# Setting the bind ip of mongodb to 0.0.0.0 (accessible via all interfaces)
sed -i "s/\b\([0-9]\{1,3\}\.\)\{1,3\}[0-9]\{1,3\}\b/0.0.0.0/g" /etc/mongod.conf
service mongod stop
service mongod start

# Installing 7zip
apt-get install -y p7zip p7zip-full

# Unpacking data with 1 million records
7z e /home/vagrant/mongo-dump/data.7z -o/home/vagrant/mongo-dump/ -aoa

# install java 8 jdk
echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" | tee /etc/apt/sources.list.d/webupd8team-java.list
echo "deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" | tee -a /etc/apt/sources.list.d/webupd8team-java.list
apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys EEA14886
apt-get update

echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
apt-get install -y oracle-java8-installer

# install tomcat

# download and extract
mkdir -p ~/tmp
cd ~/tmp
wget http://www.us.apache.org/dist/tomcat/tomcat-8/v8.0.30/bin/apache-tomcat-8.0.30.tar.gz
tar xvzf ./apache-tomcat-8.0.30.tar.gz
rm ./apache-tomcat-8.0.30.tar.gz
mkdir -p /usr/share/tomcat8
mv ~/tmp/apache-tomcat-8.0.30 /usr/share/tomcat8

# create symbolic link
rm -f /usr/share/tomcat
ln -s /usr/share/tomcat8/apache-tomcat-8.0.30 /usr/share/tomcat

# add user to tomcat users file
sed -i "s/version=\"1.0\">/version=\"1.0\">\n<user username=\"tomcat\" password=\"tomcatuser\" roles=\"tomcat,manager-gui,admin-gui,manager-script\" \/>/" /usr/share/tomcat/conf/tomcat-users.xml

# start tomcat
/usr/share/tomcat/bin/startup.sh

# import 1 million data records
mongo webappdb --eval "db.dataRecord.drop()"
mongoimport --db webappdb --collection dataRecord --type json --file /home/vagrant/mongo-dump/data.json --jsonArray

echo "### END default.sh ###"
