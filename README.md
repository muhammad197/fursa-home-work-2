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

## jenkins pipeline script :
```sh 
pipeline {
    agent {label 'node-02'}

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('clone'){
            steps{
                // Get some code from a GitHub repository
                git 'https://github.com/muhammad197/fursa-home-work-2.git'
            }
        }
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage('Artifact'){
            steps{
                archiveArtifacts artifacts: 'target/*.jar'
            }
        }
            
        }
    }

```

## Notes:
> the tool named M3 at jenkins tool is the latest maven release  



## Some screen shots from Jenkins and java app:
### jenkins pass:
![alt text](https://github.com/muhammad197/fursa-home-work-2/blob/46e1ae66fec0a509d89f6c25d71ef0db911c6dd1/jenscript.png)
### jinkins pipeline script:
![alt text](https://github.com/muhammad197/fursa-home-work-2/blob/46e1ae66fec0a509d89f6c25d71ef0db911c6dd1/jenscreen.png)
### output html file:
![alt text](https://github.com/muhammad197/fursa-home-work-2/blob/46e1ae66fec0a509d89f6c25d71ef0db911c6dd1/finaloutput.png)
