@echo off
echo 1.0
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello
echo !!! 0 %errorlevel%
java -cp  "lib/*;out/artifacts/AL_jar/AL.jar" Hello -h
echo !!! 0 %errorlevel%

echo 2.0
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello -login "QQQQ" -pass "QQQQ" > NUL
echo !!! 1 %errorlevel%
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello -login jdoe -pass QQQQ > NUL
echo !!! 2 %errorlevel%
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello -login jdoe -pass sup3rpaZZ > NUL
echo !!! 0 %errorlevel%

echo 3.0
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello -login jdoe -pass sup3rpaZZ -role READ -res a > NUL
echo !!! 0 %errorlevel%
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello -login jdoe -pass sup3rpaZZ -role READ -res a.b > NUL
echo !!! 0 %errorlevel%
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello -login jdoe -pass sup3rpaZZ -role QQQQ -res a.b > NUL
echo !!! 3 %errorlevel%
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello -login jdoe -pass sup3rpaZZ -role READ -res QQQQ > NUL
echo !!! 4 %errorlevel%
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello -login jdoe -pass sup3rpaZZ -role WRITE -res а > NUL
echo !!! 4 %errorlevel%
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello -login jdoe -pass sup3rpaZZ -role WRITE -res а.bс > NUL
echo !!! 4 %errorlevel%

echo 4.0
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -a 100 > NUL
echo !!! 0 %errorlevel%
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 01-01-2015 -de 2015-12-31 -a 100 > NUL
echo !!! 5 %errorlevel%
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -a QQQQ > NUL
echo !!! 5 %errorlevel%

echo 5.0
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello -login QQQQ -pass QQQQ -role READ -res QQQQ -ds 2015-01-01 -de 2015-12-31 -a QQQQ > NUL
echo !!! 1 %errorlevel%
java -cp "lib/*;out/artifacts/AL_jar/AL.jar" Hello -login QQQQ -pass QQQQ -role READ -res QQQQ > NUL
echo !!! 1 %errorlevel%