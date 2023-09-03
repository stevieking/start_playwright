# start_playwright
## Simple start up Playwright project

See installation notes https://playwright.dev/java/docs/intro

To download the Playwright package and install browser binaries for Chromium, Firefox and WebKit, run...

`mvn compile exec:java -D exec.mainClass="org.example.App"`

By default, Playwright runs the browsers in headless mode. 

To see the browser UI, pass the headless=false flag while launching the browser.

You can also use slowMo to slow down execution.

`Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));`




- Assertions : Playwright provides assertThat overloads which will wait until the expected condition is met.
- Locators : Locators are the central piece of Playwright's auto-waiting and retry-ability
- Test Isolation : Playwright has the concept of a BrowserContext which is an in-memory isolated browser profile

## Running tests
By default tests are run in a headless manner meaning no browser window will be opened while running the tests and results will be seen in the terminal.