Description.
For this application I decided to use Spring Boot technology: you can quickly to test application, you do not need any application server.
I used websocketc, because this appliction just only monitoring a log file and we can have many clients without overloading and GET requests to server.
For processing log file I decided to use SKIP methiod of Java 8 and save position last of process.

Files:
application.properties - consits all application configuration data
client.html - simple client for testing
log.txt - log file fro application
monitor.jar - core of applicaton
startup.bat - bat file for run application
stomp.min.js - core of STOMP messages

Install
1. Download ZIP archive.
2. unzip archive in any folder.

Run
1. Go to folder with unzipped application
2. run startup.bat

Client
1. Go to folder with unzipped application
2. Open client.html in any browser

Note: You can open many clients. Was implemented 2 views: required and my view. For testing you can add some line in log.txt without restarting application