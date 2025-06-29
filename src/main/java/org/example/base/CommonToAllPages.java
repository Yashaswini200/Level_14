package org.example.base;

import org.example.utlis.PropertiesReader;
import org.openqa.selenium.By;

import static org.example.driver.DriverManager.getDriver;

public class CommonToAllPages {
public  void openurl(){
    getDriver().get(PropertiesReader.readKey("url"));
    }
    public  void inputElement(By by,String input){
    getDriver().findElement(by).sendKeys(input);
    }
    public void on_click(By by){
    getDriver().findElement(by).click();
    }
    public   String gettext(By by){
  return   getDriver().findElement(by).getText();
    }
}
