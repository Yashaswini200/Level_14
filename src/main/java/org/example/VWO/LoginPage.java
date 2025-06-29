package org.example.VWO;

import org.example.base.CommonToAllPages;
import org.example.utlis.PropertiesReader;
import org.openqa.selenium.By;

import static org.example.driver.DriverManager.getDriver;
import static org.example.utlis.WaitHelper.checkvisiblity;

public class LoginPage extends CommonToAllPages {
    private By username=By.xpath("//input[@id=\"login-username\"]");
    private By password=By.xpath("//input[@id=\"login-password\"]");
    private By btn=By.xpath("//button[@id=\"js-login-btn\"]");

public void login(){
    openurl();
    checkvisiblity(getDriver(), username, 25);

    inputElement(username, PropertiesReader.readKey("username"));
    inputElement(password,PropertiesReader.readKey("password"));

    on_click(btn);


}
}
