# Java XML to HTML convertor, working with Jenkins pipeline
## Requrmints:
- Java 19 openjdk 
- maven 

#### install java 19:
```sh
wget https://download.oracle.com/java/19/latest/jdk-19_linux-x64_bin.deb
sudo apt-get -qqy install ./jdk-19_linux-x64_bin.deb
sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-19/bin/java 1919
```

## what is the app for?

- converts "http://www.ynet.co.il/Integration/StoryRss2.xml" to Html table view

## how does it works?
- reading the content of the URL above
- saving what buffer reads inside a file 
- converting from XML format to Html format 
- saving output file that have a HTML format 

## how to build the app?
```sh
mvn clean package
```

## Some screen shots from Jenkins and java app:
