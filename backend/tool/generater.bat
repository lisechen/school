@echo on
cd %~dp0
java -jar mybatis-generator-core-1.4.0.jar -configfile mybatisConfig.xml -overwrite
pause
