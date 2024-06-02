@echo off

rem Java settings
rem JDK 21.x or Java SE 21.x

rem CHANGE THIS TO YOUR JAVA PATH
set JAVA_HOME=/path/to/java/bin
rem CHANGE THIS TO YOUR JAVA PATH

rem Executable settings
set MIN_MEMORY=1024M
set MAX_MEMORY=1024M
set JAR_FILE=BingoGame.jar

rem Run the program
"%JAVA_HOME%/java" -Xms%MIN_MEMORY% -Xmx%MAX_MEMORY% -jar %JAR_FILE%

pause
