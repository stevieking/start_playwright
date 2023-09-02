# start_playwright
## Simple start up Playwright project

See installation notes https://playwright.dev/java/docs/intro

To download the Playwright package and install browser binaries for Chromium, Firefox and WebKit, run...

`mvn compile exec:java -D exec.mainClass="org.example.App"`

By default, Playwright runs the browsers in headless mode. 

To see the browser UI, pass the headless=false flag while launching the browser.

You can also use slowMo to slow down execution.

`Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));`


