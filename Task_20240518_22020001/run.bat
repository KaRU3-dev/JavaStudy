@echo off

rem JDK 21.0.2
set JAVA_HOME="/Path/To/Your/JDK/21.0.2"
set JAR="MazeGame.jar"

%JAVA_HOME%\java -jar -Xms1024m -Xms1024m %JAR%

pause
