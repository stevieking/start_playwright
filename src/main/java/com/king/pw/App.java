package com.king.pw;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.regex.Pattern;

public class App {
	public static void main(String[] args) {
		
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch();
			Page page = browser.newPage();
			page.navigate("http://playwright.dev");
			System.out.println(page.title());
		}

		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.webkit().launch();
			Page page = browser.newPage();
			page.navigate("https://playwright.dev/");
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
		}

		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			Page page = browser.newPage();
			page.navigate("https://playwright.dev/");
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
		}

		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch();
			Page page = browser.newPage();
			page.navigate("http://playwright.dev");

			// Expect a title "to contain" a substring.
			assertThat(page).hasTitle(Pattern.compile("Playwright"));

			// create a locator
			Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));

			// Expect an attribute "to be strictly equal" to the value.
			assertThat(getStarted).hasAttribute("href", "/docs/intro");

			// Click the get started link.
			getStarted.click();

			// Expects page to have a heading with the name of Installation.
			assertThat(page.getByRole(AriaRole.HEADING,
					new Page.GetByRoleOptions().setName("Installation"))).isVisible();
		}
	}	
}