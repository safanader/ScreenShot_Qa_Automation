import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Test_Logic {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.edge.driver", "F:\\edgedriver\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("http://127.0.0.1:5500/index3.html");
		List<WebElement> list=driver.findElements(By.tagName("option"));
		int listItem = list.size();
		System.out.println(listItem + "  this is the orginal number");
		for(int i=0 ; i<listItem;i++) {
			if(i%2==0) {
				list.get(i).click();
				System.err.println("sorry i will remove"+ list.get(i).getText());
				driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();	 
			}	else
			{
				System.out.println("i will keep  "+ list.get(i).getText());
			}
		}
		Date currentDate = new Date();
		String TheAcutalDate = currentDate.toString().replace(":", "-");
		TakesScreenshot src = ((TakesScreenshot) driver) ; 
		File SrcFile = src.getScreenshotAs((OutputType.FILE));
		File Dest = new File("F://mypictures/"+TheAcutalDate+".png");
		FileUtils.copyFile (SrcFile,Dest);

	}

}
