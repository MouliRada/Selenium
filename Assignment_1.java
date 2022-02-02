package testproject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment_1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
				String Url = null;
				HttpURLConnection huc = null;
				int URLcount =1;
				int BrokenUrlCount =0;
	
		
			System.setProperty("webdriver.chrome.driver","C:\\Users\\PC\\Downloads\\Downloads\\Drivers\\chromedriver.exe");
				ChromeOptions co = new ChromeOptions();
				co.addArguments("user-data-dir= C:\\Users\\PC\\Downloads\\Downloads\\Drivers\\");
		
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
		
				driver.get("http://uitestingplayground.com/home");
		
				List<WebElement	> Links = driver.findElements(By.tagName("a"));
		
				Iterator<WebElement> It = Links.iterator();
					//Count for total no of URLs.
				System.out.println(driver.findElement(By.xpath("//meta[@name!='']")).getAttribute("name"));
				List<WebElement> lst=driver.findElements(By.xpath("//meta[@name!='']"));
				System.out.println(lst.size());
				for(int i=0;i<lst.size();i++)
				{
					System.out.println(lst.get(i).getAttribute("name"));
				}
				
				//String s = driver.getPageSource();
				//String pattern = "meta";
				//Pattern r = Pattern.compile(pattern);
				
				/*
				 * if (s.contains("meta")) {
				 * 
				 * System.out.println("-----containing meta----"); }
				 */
				
					while(It.hasNext())
								{
									Url = It.next().getAttribute("href");
									System.out.println(Url);
			
										URLcount++;
			
										if(Url == null || Url.isEmpty())
				
										{
											System.out.println("URL is either not configured for anchor tag or it is empty");
											continue;
			}
			
										huc = (HttpURLConnection)(new URL(Url).openConnection());
										huc.setRequestMethod("HEAD");
										huc.connect();
										int responsecode = huc.getResponseCode();
										Thread.sleep(1000);
			 			if(responsecode >= 400){
			 		System.out.println(Url+" is a broken link");
			 		BrokenUrlCount++;
			 		
				 }
				 	else{
				 		System.out.println(Url+" is a valid link");
				 }
			 
		}
		System.out.println("Total no of URLS are ----" + URLcount);
		System.out.println("Total no of BrokenURLS are ----" + BrokenUrlCount);
	}

}
