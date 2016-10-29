@echo off
echo ***
java -classpath "out/production/anyalena/" Hello yyy ee
echo %errorlevel%
echo ***
java -classpath "out/production/anyalena/" Hello urur 123
echo %errorlevel%
echo ***
java -classpath "out/production/anyalena/" Hello urur q
echo %errorlevel%
echo ***
java -classpath "out/production/anyalena/" Hello
echo %errorlevel%
echo ***
java -classpath "out/production/anyalena/" Hello uu
echo %errorlevel%

