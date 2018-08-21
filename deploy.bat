set MAVEN_HOME=C:\Devon-dist_2.3.0\Devon-dist_2.3.0\software\maven
set PATH=%PATH%;%MAVEN_HOME%\bin
call mvn clean install
call xcopy /y target\sonarqube-devon-plugin-*.jar C:\Devon-dist_2.3.0\Devon-dist_2.3.0\software\sonarqube\extensions\plugins\
pause