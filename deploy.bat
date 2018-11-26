call IDEenv
call mvn clean install
call xcopy /y target\sonar-devon-plugin-*.jar %SOFTWARE_PATH%\sonarqube\extensions\plugins\
pause