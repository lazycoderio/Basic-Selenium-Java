@echo off
title Setting up your machine for Selenium Testing!

@powershell -NoProfile -ExecutionPolicy Bypass -Command "iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))" && SET "PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin"

choco install firefox
choco install googlechrome
choco install phantomjs
choco install selenium-all-drivers
