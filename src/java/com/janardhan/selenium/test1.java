/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.janardhan.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author janardhan
 */
public class test1 {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println("*******************");
        System.out.println("launching firefox browser");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testPageTitleSampleB() {
        driver.navigate().to("http://www.google.com");
        String strPageTitle = driver.getTitle();
        System.out.println("Page title: - " + strPageTitle);
        Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
    }

    @Test
    public void testSampleOne() {
        System.out.println("Im in test sample one");
    }

    @Test
    public void testSampleTwo() {
        System.out.println("Im in test sample two");
    }

    @Test
    public void testSampleThree() {
        System.out.println("Im in test sample three");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            System.out.println("Closing IE browser");
            driver.quit();
        }
    }

}
