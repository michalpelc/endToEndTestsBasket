How to run tests:

mvn clean -U test -DisRemote=false <- run tests locally
mvn clean -U test -DisRemote=true <- run tests on selenium hub after adding arguments with server and port (local ore remote setup required)