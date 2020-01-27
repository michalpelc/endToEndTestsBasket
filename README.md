Test suite for sports direct shop web page.

How to run tests:


mvn clean -U test -DisRemote=false <- run tests locally (already setup to run in parallel per classes).

mvn clean -U test -DisRemote=true <- run tests on selenium hub after adding arguments with server and port.
