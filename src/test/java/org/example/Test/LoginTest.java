package org.example.Test;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.example.VWO.Dashboard;
import org.example.VWO.LoginPage;
import org.example.VWO.Logout;
import org.example.base.CommonToAllTest;
import org.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.example.driver.DriverManager.getDriver;
import static org.example.utlis.WaitHelper.checkvisiblity;
@Listeners({AllureTestNg.class})

public class LoginTest extends CommonToAllTest {

    @DataProvider(name = "browsers", parallel = true)
    public Object[][] getBrowsers() {
        return new Object[][] {
                {"chrome"},
                {"edge"}
        };
    }

    @Test(dataProvider = "browsers")
    public void testlogin(String browser) throws Exception{
        DriverManager.init(browser);
        LoginPage login_=new LoginPage();
        login_.login();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/dashboard"));
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://app.vwo.com/#/dashboard?accountId=1111229");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-sub-title")));

        Dashboard dashboard=new Dashboard();
       dashboard.dash();
        Logout logout=new Logout();
        logout.log();
        wait.until(ExpectedConditions.urlContains("login"));
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://app.vwo.com/#/login");

    }
}
