package org.testinium.base;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;


public class BaseTest {
    static WebDriver webDriver;

    public static Logger logger;

    public static Logger getInstance() {
        if (logger == null) {
            logger = Logger.getLogger(TestLog.class.getName());
        }

        return logger;
    }

    @Before
    public void setUp() {
        PropertyConfigurator.configure("C:\\Users\\OnurcanIrmak\\IdeaProjects\\TestiniumProject-Onurcan\\src\\main\\resources\\log4j.properties");
        getInstance().info("Log Başlatıldı");
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OnurcanIrmak\\IdeaProjects\\TestiniumProject-Onurcan\\ChromeWebDriver\\chromedriver.exe");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        getWebDriver().navigate().to("https://www.gittigidiyor.com/");
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    @AfterAll
    public void tearDown() {
        getWebDriver().close();
    }
}
