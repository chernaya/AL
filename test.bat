@echo off
echo ***
java -classpath "out/production/AL/" Hello uu
echo %errorlevel%
echo ***
java -classpath "C:/Users/user/tmp/out/production/AL/" Hello urur 123
echo %errorlevel%
echo ***
java -classpath "out/production/Al/" Hello urur q
echo %errorlevel%
echo ***
java -classpath "out/production/AL/" Hello
echo %errorlevel%
echo ***
java -classpath "out/production/AL/" Hello uu
echo %errorlevel%
echo ***
java -classpath "out/production/AL/" Hello - login urur 123 READ a
echo %errorlevel%
echo ***
java -classpath "out/production/AL/" Hello urur 123 3 a
echo %errorlevel%
echo ***
java -classpath "out/production/AL/" Hello urur 123 1 t
echo %errorlevel%
echo ***
java -classpath "out/production/AL/" Hello urur 123 1
echo %errorlevel%
echo ***
java -classpath "out/production/AL/" Hello urur 123 3
echo %errorlevel%
echo ***