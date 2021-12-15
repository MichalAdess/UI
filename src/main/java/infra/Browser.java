package infra;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;

public class Browser {

    private static WebDriver _driver;

    private static void initDriver() {

        System.out.println(" #GOTO -> #https://ft.govforms.gov.il/mw/forms/ApplicationToEnterIsrael@piba.gov.il");
        MutableCapabilities capabilities;

        capabilities = new ChromeOptions();
        ((ChromeOptions) capabilities).setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ((ChromeOptions) capabilities).addArguments("--disable-popup-blocking", "-disable-popup-blocking", "--disable-popup-blocking=true", "--block-new-web-contents=false"
                , "--error-console", "--disable-infobars", "--enable-logging", "--log-level=1", "--disable-gpu", "--no-sandbox"
                , "--webview-disable-safebrowsing-support", "--disable-web-security", "--allow-running-insecure-content"
//
        );
        capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
        capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        System.setProperty("webdriver.chrome.driver", new File("src\\main\\resources\\chromedriver.exe").getPath());
        _driver = new ChromeDriver((ChromeOptions) capabilities);
        _driver.manage().window().maximize();

    }

    public static WebDriver driver() {
        if (_driver == null) {
            initDriver();
        }
        return _driver;
    }


}
