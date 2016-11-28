# Using this Project

[![Join the chat at https://gitter.im/lazycoderio/sample-java-jenkins](https://badges.gitter.im/lazycoderio/sample-java-jenkins.svg)](https://gitter.im/lazycoderio/sample-java-jenkins?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

[![Coverage Status](https://coveralls.io/repos/github/lazycoderio/sample-java-jenkins/badge.svg?branch=master)](https://coveralls.io/github/lazycoderio/sample-java-jenkins?branch=master)

[![codecov](https://codecov.io/gh/lazycoderio/sample-java-jenkins/branch/master/graph/badge.svg)](https://codecov.io/gh/lazycoderio/sample-java-jenkins)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2da21d82c84640028d90abf2de796022)](https://www.codacy.com/app/andrew-m-krug/sample-java-jenkins?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=lazycoderio/sample-java-jenkins&amp;utm_campaign=Badge_Grade)

[![Code Climate](https://codeclimate.com/github/lazycoderio/sample-java-jenkins/badges/gpa.svg)](https://codeclimate.com/github/lazycoderio/sample-java-jenkins)

[![Dependency Status](https://www.versioneye.com/user/projects/583b58fd4ef164003ff45522/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/583b58fd4ef164003ff45522)

[![Build Status](https://travis-ci.org/lazycoderio/sample-java-jenkins.svg?branch=master)](https://travis-ci.org/lazycoderio/sample-java-jenkins)

This project is using the latest Selenium Bindings.

## Setup
Run these commands depending on your base OS.

### On Mac OS

Install Java JDK

Install Homebrew `/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`

Install Maven `brew install maven`

Run `brew install geckodriver`

## Running Tests

The following commands are instructions on how to run the tests

### From CLI

`mvn test`

### Intellij Idea

There is a shared run configuration that has the maven target setup and another with a sample built in NUnit test runner option.
