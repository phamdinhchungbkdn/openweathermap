# OpenWeatherMap Test Automation Framework using Java and Selenium WebDriver

**This project delivers to you a complete lean test architecture for your web and api tests.**

## Languages and Frameworks

This project using the following languages and frameworks:

* [Java 8](https://openjdk.java.net/projects/jdk8/) as the programming language
* [TestNG](https://testng.org/doc/) as the test framework to support the test creation
* [Selenium WebDriver](https://www.selenium.dev/) as the web browser automation framework using the Java binding
* [TestNG Assert](https://www.javadoc.io/doc/org.testng/testng/6.8.17/org/testng/Assert.html) as the assertion library
* [Extent Report for Cucumber](https://grasshopper.tech/2098/) as the testing report strategy
* [Log4J2](https://logging.apache.org/log4j/2.x/) as the logging management strategy
* [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) as the Selenium binaries management
* [Owner](http://owner.aeonbits.org/) to minimize the code to handle the properties file


## Test architecture

We know that any automation project starting with a good test architecture.
This project can be your initial test architecture for a faster start.
You will see the following items in this architecture:

* [Page Objects pattern](#page-objects-pattern)
* [Hooks](#hooks)
* [TestListener](#testlistener)
* [Logging](#logging)
* [Configuration files](#configuration-files)
* [Parallel execution](#parallel-execution)
* [Test Data Driven](#test-data-driven)
* [Profiles executors on pom.xml](#profiles-executors-on-pomxml)

Do you have any other items to add to this test architecture? Please do a pull request or open an issue to discuss.

### Page Objects pattern

#### WebInteraction
This class has methods to interact with Web elements. It allows us to use with different type of locator.

This strategy to avoid to not get an `ElementNotFoundException` or `StaleElementReferenceException` as much as possible.

Also, it sets the timeout from the `longTimeout` and `shortTimeout` property value located on `general.properties` file.

All the Page Object classes should extend the `CommonPage`.
It also helps to remove the `driver` object from the Page Object class as much as possible.

#### Local execution
This execution type uses [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) class to instantiate the web browsers.
When the `target` is `local` the `createDriver()` method is used from the `BrowserFactory` class to return the browser instance.

The browser used in the test is placed on the `browser` property in the `local.properties` file.

#### Remote execution
TBD

#### BrowserFactory class
This Factory class is a Java enum that has all implemented browsers to use during the test execution.
Each browser is an enum, and each enum implements two methods:
* `createDriver()`: creates the browser instance for the local execution. The browser driver is automatically managed by the WebDriverManager library

#### DriverManager class
The class [DriverManager](https://github.com/eliasnogueira/selenium-java-lean-test-achitecture/blob/master/src/main/java/com/eliasnogueira/driver/DriverManager.java) 
create a `ThreadLocal` for the WebDriver instance, to make sure there's no conflict when we run it in parallel.

### Hooks
This testing pattern was implemented on the [Hooks](https://github.com/phamdinhchungbkdn/openweathermap/blob/main/src/test/java/stepdefinition/Hooks.java) 
class to automatically run the pre (setup) and post (teardown) conditions.

The pre-condition uses `@BeforeMethod` from TestNG creates the browser instance based on the values passed either local or remote execution.
The post-condition uses `@AfterMethod` to close the browser instance.

It was designed to open a browser instance to each `@Test` located on the test class.

This class also the `TestListener` that is a custom TestNG listener, and will be described in the next section.

### TestListener

The `TestListener` is a class that implements [ITestListener](https://testng.org/doc/documentation-main.html#logging-listeners).
The following method is used to help logging errors and attach additional information to the test report:
* `onTestStart`: add the browser information into the test report
* `onTestFailure`: log the exceptions and add a screenshot as `base64-image` to the test report
* `onTestSkipped`: add the skipped test on the log

### Logging
All the log is done by the Log4J using the `@Log4j2` annotation.

The `log4j2.properties` has two strategies: console and file.
A file with all the log information will be automatically created on the folder `log4j2` with `log4j2-test-automation.log` filename. 
If you want to change it, update the `appender.a_rolling.fileName` property value.

The `log.error` is used to log all the exceptions this architecture might throw. Use `log.info` or `log.debug` to log 
important information.

### Parallel execution
The parallel test execution is based on the [parallel tests](https://testng.org/doc/documentation-main.html#parallel-tests) 
feature on TestNG. This is used by `parallel.xml` test suite file which has the `parallel="tests"` attribute and value, 
whereas `test` item inside the test suite will execute in parallel.
The browser in use for each `test` should be defined by a parameter, like:
```xml
<parameter name="browser" value="chrome"/>
```

You can define any parallel strategy.

It can be an excellent combination together with the grid strategy.

### Configuration files
This project uses a library called [Owner](http://owner.aeonbits.org/). You can find the class related to the property 
file reader in the following classes:
* [Configuration](https://github.com/phamdinhchungbkdn/openweathermap/blob/main/src/main/java/config/Configuration.java)
* [ConfigurationManager](https://github.com/phamdinhchungbkdn/openweathermap/blob/main/src/main/java/config/ConfigurationManager.java)

There are 6 properties (configuration) files located on `src/main/resources/`:
* `general.properties`: general configuration as the target execution, base url, timeout and test data path
* `local.properties`: browser to use in the local execution
* `endpoint.properties`: base URI, api key and endpoint
* `entent.properties`: configuration for Extent Report
* `log4j2.properties`: configuration for Log
* `grid.properties`: url and port for the Selenium grid usage (Zalenium - TBD, implement later)

The properties were divided into three different ones to better separate the responsibilities and enable the changes easy 
without have a lot of properties inside a single file.

### Test Data Driven
Is the utilization of using Serialization and Deserialization process with POJO classes for test data as well as response body.

### Profiles executors on pom.xml

There is a profile called `web-execution` or `api-execution` created to execute the test suite `web-tests.xml` or `api-tests.xml` inside `src/test/resources/suites` folder.
To execute this suite, via the command line you can call the parameter `-P` and the profile id.

Eg: executing the multi_browser suite
``` bash
mvn test -Pweb-execution -Dtestng.dtd.http=true 
```

If you have more than one suite on _src/test/resources/suites_ folder you can parameterize the xml file name.
To do this you need:

* Create a property on `pom.xml` called _xxx.suite_

```xml
    <properties>
        <web.suite>web-tests.xml</web.suite>
        <api.suite>api-test.xml</api.suite>
    </properties>
```

* Add a profile id

```xml
<profile>
   <id>api-execution</id>
</profile>   
```

* Replace the `${web.suite}` to `${api.suite}` on the profile

```xml
<configuration>
   <suiteXmlFiles>
      <suiteXmlFile>src/test/resources/suites/${api.suite}</suiteXmlFile>
   </suiteXmlFiles>
</configuration>
```

* Use `-Dsuite=suite_name` to call the suite

````bash
mvn test -Papi-execution -Dsuite=parallel -Dtestng.dtd.http=true 
````

### Pipeline as a code

* Jenkins: `JenkinsFile` to be used on a Jenkins pipeline