Test suite for sports direct shop web page.

How to run tests:


mvn clean -U test -DisRemote=false <- run tests locally (already setup to run in parallel per classes).

mvn clean -U test -DisRemote=true <- run tests on selenium hub after adding arguments with server and port.


//TODO

1. popup handling - mechanism for element wrapping must be implemented. Due to popups displayed randomly tests are unstable.

Implement something in shape of:

https://www.vinsguru.com/selenium-webdriver-how-to-handle-annoying-random-popup-alerts/

2. add logging

//TODO

