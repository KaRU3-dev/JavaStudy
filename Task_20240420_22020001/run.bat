@echo off

rem JDK 21.0.2
set JAVA_HOME="C:\Users\himar\Desktop\InDesktop\jdks\jdk-21.0.2\bin"
set JAR="Task_20240420_22020001.jar"

%JAVA_HOME%\java -jar -Xms1024m -Xms1024m %JAR%

pause
