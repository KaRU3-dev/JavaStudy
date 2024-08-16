@echo off

rem Execute config
set MIN_MEMORY=512m
set MAX_MEMORY=1024m
echo MIN_MEMORY: %MIN_MEMORY%
echo MAX_MEMORY: %MAX_MEMORY%

rem JDK Path
set JAVA_HOME=/path/to/jdks/jdk-21.0.2/bin
echo JAVA_HOME: %JAVA_HOME%

rem Jar file path
set JAR_FILE_PATH=Task_20240831_22020001_RPG_2.jar
echo JAR_FILE_PATH: %JAR_FILE_PATH%

rem Run the jar file
%JAVA_HOME%/java -Xms%MIN_MEMORY% -Xmx%MAX_MEMORY% -jar %JAR_FILE_PATH%
echo End

pause
