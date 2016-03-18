# Selenium Cucumber Framework

### Prepare your machine:
JDK Install (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
and let it install to the default directory

IDE Install of your choice (IntelliJ Idea/Eclipse)

## OSX:

In Mac OSX 10.5 or later, Apple recommends to set the $JAVA_HOME variable to 
/usr/libexec/java_home in file ~/. bash_profile or ~/.profile.

##### Set JAVA_HOME

Open a new Terminal: 
**cd ~** 
**vim .bash_profile** 
(This creates a new .bash_profile file using text editor VIM in your root directory)

Press I to Insert a new line and add:
**export JAVA_HOME=$(/usr/libexec/java_home)**
To exit and Save VIM press ESC, then : and wq to save your changes

In Terminal use
**source .bash_profile**
so your machine recognises the changes

Now enter
**echo $JAVA_HOME**
and a path to your Java installation should be shown correctly eg: 
/Library/Java/JavaVirtualMachines/1.7.0.jdk/Contents/Home

#### MAVEN installation 

The easiest way to install Maven correctly is to use Homebrew.
Open a Terminal and paste this command to install Homebrew:
**/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"**

Install Maven with these two commands in Terminal:
**brew doctor**
**brew install maven**

To ensure Maven has been installed correctly 
**mvn -v** 
and you should see something similar to this output:

Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T16:41:47+00:00)
Maven home: /usr/local/Cellar/maven/3.3.9/libexec
Java version: 1.8.0_73, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.11.3", arch: "x86_64", family: "mac"

#### Set-up the Framework

In Stash navigate to the Selenium_Cucumber_Framework repo and Clone
https://stash.macmillan.education/projects/QTT/repos/selenium_cucumber_framework/browse

Example:
Open a Terminal: 
git clone https://User.Name@stash.macmillan.education/scm/qtt/selenium_cucumber_framework.git 

Next Clone this Repo which contains all of the required Selenium Servers and Drivers
https://stash.macmillan.education/projects/QTT/repos/selenium-server-and-drivers/browse


#### Start the Selenium Hub and Node
In Terminal navigate to the project folder i.e:
/Users/username/Documents/Repos/MacMillan/selenium_cucumber_framework

**Start the node with:
java -jar selenium-server-standalone-2.53.0.jar -role hub

**Start the hub in a new Terminal with:
java -jar selenium-server-standalone-2.53.0.jar -role node -nodeConfig macNodeConfig.json

The output should inform you that the node is registered and ready to use
INFO - Registering the node to the hub: http://localhost:4444/grid/register
INFO - The node is registered to the hub and ready to use

See the hub in the browser here:
http://localhost:4444/grid/console?config=true&configDebug=true#

#### Run the Tests locally

Open the Selenium_Cucumber_Framework project in the IDE of your choice and open the folder testRunner and the file TestRunner

Right click on the file and choose Run TestRunner and a Chrome browser should open and run through the SampleGoogleSearch.feature file tests
 
Open config.properties to make changes to the local browser


## PC:

#### Set JAVA_HOME

Locate where the JDK software is installed on your PC and copy the path i.e.
C:\Program Files\Java\jdk1.6.0_02

To set JAVA_HOME right click on My Computer, Properties, Advanced Tab and select Enviornment Variables
now edit or Add JAVA_HOME and past the path copied from the step above

#### MAVEN installation 
Visit Maven official website, download the Maven zip file, for example:
apache-maven-3.2.2-bin.zip. Unzip it to the folder you want to install Maven.

Assume you unzip to this folder
C:\Program Files\Apache\maven

Add the above paths to both M2_HOME and MAVEN_HOME variables in the Windows Environment Variables

To ensure Maven has been installed correctly 
mvn -v 
and you should see something similar to this output:

C:\Users\mkyong>mvn -version
Apache Maven 3.2.2 (45f7c06d68e745d05611f7fd14efb6594181933e; 2014-06-17T21:51:42+08:00)
Maven home: C:\Program Files\Apache\maven
Java version: 1.7.0_65, vendor: Oracle Corporation
Java home: C:\Program Files\Java\jdk1.7.0_65\jre
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 8.1", version: "6.3", arch: "amd64", family: "windows"

There is a step by step guide with screenshots here:
http://www.mkyong.com/maven/how-to-install-maven-in-windows/













