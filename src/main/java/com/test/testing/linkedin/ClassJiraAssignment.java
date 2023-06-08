package com.test.testing.linkedin;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassJiraAssignment {
	@Test
	public void test() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions chrOpt = new ChromeOptions();
		chrOpt.addArguments("--remote-allow-origins=*");
		chrOpt.addArguments("--start-maximized");
		chrOpt.addArguments("--incognito");
		ChromeDriver driver = new ChromeDriver(chrOpt);
		driver.get("https://www.linkedin.com/uas/login");
		driver.findElement(By.id("username")).sendKeys("jotheeshkumar.m@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Jona73@love");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		// driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys();
		Actions builder = new Actions(driver);
		builder.sendKeys(search, "It recruiter").sendKeys(Keys.ENTER).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[text()[normalize-space()='People']]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[text()[normalize-space()='Locations']]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()[normalize-space()='Canada']]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		builder.sendKeys(Keys.ESCAPE).build().perform();
		// driver.findElement(By.xpath("//span[text()='Show results']")).click();
		// driver.findElement(By.xpath("//span[text()[normalize-space()='Show
		// results']]")).click();
		List<WebElement> result = driver.findElements(By.xpath("//span[text()='Connect']"));
																										//div[@class='entity-result__item']/div[2]//a//span[1]
		//WebElement name = driver.findElement(By.xpath("/div[2]//a//span[1]"));
		System.out.println("toatl size: "+ result.size());
		Thread.sleep(1000);
		for (int i = 0; i < result.size(); i++) {
			WebElement webElement = result.get(i);
			
			if (webElement.getText().contains("Connect")) {
				
				System.out.println(webElement.getText());
				webElement.click();
				
				 WebElement addNote = driver.findElement(By.xpath("//span[text()='Add a note']"));
				addNote.click();
				WebElement invite = driver.findElement(By.xpath("//h2[@id='send-invite-modal']"));
				String text = invite.getText();
				
				String[] indexOfFirstSpace = text.split(" ");
				System.out.println(indexOfFirstSpace[2]);
				Thread.sleep(1000);
				System.out.println("current size: --------------------"+ i);
			}else {
				System.out.println("-----------------");
				
			}

		}

		

	}
}