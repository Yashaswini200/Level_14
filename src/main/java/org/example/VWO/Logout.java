package org.example.VWO;

import org.example.base.CommonToAllPages;
import org.openqa.selenium.By;

public class Logout extends CommonToAllPages {
    private By btn_act=By.xpath("//img[@data-qa=\"user-image\"]");
    private By btn_log=By.xpath("//li[@no-async-loader=\"true\"]");
    public void log(){
        on_click(btn_act);
        on_click(btn_log);
    }
}
