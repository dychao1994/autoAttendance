package com.dychao.demo;


import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("autoDemo") 
public class AutoDemo {
	
	public void auto(String name,String password){
		// TODO Auto-generated method stub  
	    //设置浏览器driver 
		org.openqa.selenium.WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	    //System.setProperty("webdriver.firefox.bin", "D:/firefox/firefox.exe");
	    driver=new ChromeDriver();    
	    //打开百度的首页  
	    driver.get("http://kq.neusoft.com/");
	    List<WebElement> inputs = driver.findElements(By.className("eleWrapper"));
	    List<WebElement> names = (inputs.get(1)).findElements(By.tagName("input"));
	    names.get(0).sendKeys(name);
	    List<WebElement> passwords = (inputs.get(2)).findElements(By.tagName("input"));
	    passwords.get(0).sendKeys(password);
	    driver.findElement(By.id("loginButton")).click();
	    
	    List<WebElement> btns = driver.findElements(By.className("mr36"));
	    btns.get(0).click();
	    //关闭浏览器  
	    driver.close();
	}
	@Scheduled(cron = "0 * * * * ?")
	public void run() {
	    System.out.println("-------伦博考勤--------："+new Date());
	    auto("lunbo","Singapore,2018");
	    System.out.println("-------考勤结束--------");
	    System.out.println("-------樊佳伟考勤--------："+new Date());
	    auto("fanjw","FAN-12345678");
	    System.out.println("-------考勤结束--------");
    } 
	
}
