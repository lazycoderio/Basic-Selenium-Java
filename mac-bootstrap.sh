#!/bin/sh

# mac-bootstrap.sh
# by wilsonmar at gmail.com
# This bash script bootstraps a MacOS laptop (like at https://github.com/fs/osx-bootstrap)
# to run Selenium against a Java source file that
# simply opens a web page in several browsers.
#
# This script installs:
#    - xcode
#    - homebrew
#
# It will ask you for your sudo password.

fancy_echo() { # to add blank line between echo statements:
  local fmt="$1"; shift
  # shellcheck disable=SC2059
  printf "\n$fmt\n" "$@"
}

fancy_echo "Boostrapping ..."

trap 'ret=$?; test $ret -ne 0 && printf "failed\n\n" >&2; exit $ret' EXIT

set -e  # to stop on error.

# Ask for the administrator password upfront and run a
# keep-alive to update existing `sudo` time stamp until script has finished
# sudo -v
# while true; do sudo -n true; sleep 60; kill -0 "$$" || exit; done 2>/dev/null &

# Ensure Apple's command line tools are installed
if ! command -v cc >/dev/null; then
  fancy_echo "Installing xcode (Agreeing to the Xcode/iOS license requires sudo admin privileges) ..."
  sudo xcodebuild -license accept
  # xcode-select --install
else
  fancy_echo "Xcode already installed. Skipping."
fi


if ! command -v brew >/dev/null; then
  fancy_echo "Installing Homebrew..."
  ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)" </dev/null
else
  fancy_echo "Homebrew already installed. Skipping."
fi


fancy_echo "Install Caskroom ..."
brew tap caskroom/cask


if ! command -v java >/dev/null; then
  fancy_echo "Installing Java..."
  brew cask install java
else
  fancy_echo "Java already installed. Skipping."
fi


if ! command -v mvn >/dev/null; then
  fancy_echo "Installing Maven..."
  brew install maven
else
  fancy_echo "Maven already installed. Skipping."
fi


fancy_echo "Run mac_install_browsers.sh ..."
chmod +x mac_install_browsers.sh
./mac_install_browsers.sh


fancy_echo "Run test ..."
mvn test -Dsurefire.suiteXmlFiles=mac-only.xml
# Browser windows should open and close on their own.

fancy_echo "Done with status $? (0=OK)."
