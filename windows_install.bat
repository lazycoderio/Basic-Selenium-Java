     @echo off
     title Setting up your machine for Selenium Testing!
     call :isAdmin

     if %errorlevel% == 0 (
        goto :run
     ) else (
        echo Requesting administrative privileges...
        goto :UACPrompt
     )

     exit /b

     :isAdmin
        fsutil dirty query %systemdrive% >nul
     exit /b

     :run
      @powershell -NoProfile -ExecutionPolicy Bypass -Command "iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))" && SET "PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin"

choco install firefox -y
choco install googlechrome -y
choco install phantomjs -y
choco install selenium-all-drivers -y
choco install jdk8 -y
choco install maven -y
SETX PATH "%PATH%;%ChocolateyToolsLocation%"

     exit /b

     :UACPrompt
       echo Set UAC = CreateObject^("Shell.Application"^) > "%temp%\getadmin.vbs"
       echo UAC.ShellExecute "cmd.exe", "/c %~s0 %~1", "", "runas", 1 >> "%temp%\getadmin.vbs"

       "%temp%\getadmin.vbs"
       del "%temp%\getadmin.vbs"
      exit /B`
     
