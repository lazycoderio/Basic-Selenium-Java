[![Join the chat at https://gitter.im/lazycoderio/sample-java-jenkins](https://badges.gitter.im/lazycoderio/sample-java-jenkins.svg)](https://gitter.im/lazycoderio/sample-java-jenkins?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge) [![codecov](https://codecov.io/gh/lazycoderio/Basic-Selenium-Java/branch/master/graph/badge.svg)](https://codecov.io/gh/lazycoderio/Basic-Selenium-Java) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/afdb9236cb2442faaa513c2db4114396)](https://www.codacy.com/app/andrew-m-krug/Basic-Selenium-Java?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=lazycoderio/Basic-Selenium-Java&amp;utm_campaign=Badge_Grade) [![Dependency Status](https://www.versioneye.com/user/projects/583b58fd4ef164003ff45522/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/583b58fd4ef164003ff45522) [![Build Status](https://travis-ci.org/lazycoderio/Basic-Selenium-Java.svg?branch=master)](https://travis-ci.org/lazycoderio/Basic-Selenium-Java) [![Stories in Ready](https://badge.waffle.io/lazycoderio/Basic-Selenium-Java.png?label=ready&title=Ready)](https://waffle.io/lazycoderio/Basic-Selenium-Java)
# Using this Project

This project is using the latest Selenium Bindings.

## Setup

Run these commands depending on your base OS.

### On Mac OS

Copy this bootstrap script and run it in a Terminal shell window:

   ```
   sh -c "$(curl -fsSL https://raw.githubusercontent.com/lazycoderio/Basic-Selenium-Java/master/mac-bootstrap.sh)"
   ```

It installs the following if it is not already installed:

1. Install Homebrew `/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`
2. Install Caskroom `brew tap caskroom/cask`
3. If you dont have the Java Development Kit (JDK) run this command `brew cask install java`
4. Install Maven `brew install maven`
5. Run `./mac_install_browsers.sh`

The script also runs the test.

### On Windows

> This is currently having a few issue

1. Download the zip file or clone this repository.
2. Navigate to the unzipped folder within the file browser.
3. Right-Click on `windows_install.bat` and select `Run as Administrator`
4. Test the installation by running the following from a command window in the directory of this project

   `mvn test  -Dsurefire.suiteXmlFiles=windows-only.xml`

#### Longer Instructions

1. The script should install Chocolatey the Windows package manager.
2. Install latest versions of 
    a. Firefox
    b. Chrome
    c. PhantomJS
3. Selenium drivers for the above and the Edgedriver

## Running Tests

The following commands are instructions on how to run the tests

### From CLI

On a Mac:

   `mvn test  -Dsurefire.suiteXmlFiles=mac-only.xml`

### Intellij IDEA

There is a shared run configuration that has the maven target setup and another with a sample built in NUnit test runner option.

#### Safari Test

Safari requires the following steps to enable Selenium Webdriver tests to run:

1. Open Safari Preferences
2. Go to the Advanced Tab
3. Check the box at the bottom "Show Develop menu in menu bar"
4. Click on the Develop menu 
5. Click on "Allow Remote Execution"

Now Safari tests will work. 

If running tests only locally you can remove delete `//` from the  `@Test` line of the Safari class.
