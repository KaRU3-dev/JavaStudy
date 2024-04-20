@echo off

rem JDK 21.0.2
set JAVA_HOME="/path/to/jdk-{version}/bin"
set JAR="Task_20240420_22020001.jar"

%JAVA_HOME%\java -jar -Xms1024m -Xms1024m %JAR%

pause
