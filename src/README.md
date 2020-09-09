1. mvn versions:display-dependency-updates

    [INFO] The following dependencies in Dependencies have newer versions:
    [INFO]   org.seleniumhq.selenium:selenium-java ...... 3.141.59 -> 4.0.0-alpha-6
    [INFO]   org.testng:testng ..................................... 7.1.0 -> 7.3.0
    
   mvn versions:use-latest-versions
        
    [INFO] Major version changes allowed
    
2. mvn clean test

    [INFO] Tests run: 18, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 191.545 s - in TestSuite

3. mvn clean test -Dtest=LoginTest, MenuTest
    
    [INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 100.28 s - in TestSuite

   mvn clean test -Dtest=LoginTest#IncorrectCreds+EmptyPassword
    
    [INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 15.909 s - in tests.LoginTest

4. mvn -f pom_2.xml clean test -DsuiteXmlFile=src/test/resources/Saucedemo.xml

    [INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 38.815 s - in TestSuite

5. mvn clean test -Dtest=CartTest#productShouldBeAddedIntoCart -Dproduct="Sauce Labs Bike Light" 

    [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 14.544 s - in tests.CartTest


