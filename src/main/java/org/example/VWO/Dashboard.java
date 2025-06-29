package org.example.VWO;

import org.example.base.CommonToAllPages;
import org.openqa.selenium.By;

public class Dashboard  extends CommonToAllPages {
    private By data=By.xpath("//p[@class=\"page-sub-title\"]");
    public void dash(){
String one=gettext(data);
        if(one.contains("ramesh suresh")){
            System.out.println("verfied");

        }

    }
}
