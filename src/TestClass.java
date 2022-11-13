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
import org.testng.Assert;

public class TestClass {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.edge.driver", "F:\\edgedriver\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();

		driver.get("http://127.0.0.1:5500/index3.html");
		
		Date currentDate = new Date();
		
		String TheAcutalDate = currentDate.toString().replace(":", "-");

		TakesScreenshot src = ((TakesScreenshot) driver) ; 
		
		File SrcFile = src.getScreenshotAs((OutputType.FILE));
		
		File Dest = new File("F://mypictures/"+TheAcutalDate+".png");
		
		FileUtils.copyFile (SrcFile,Dest); 
		
		List<WebElement> thestudents = driver.findElements(By.tagName("option"));

		int theTotalNumberOfStudents = thestudents.size();

		System.out.println(theTotalNumberOfStudents + "this is the orginal number");

		int HowManyItems = 10;

		System.out.println(HowManyItems + "this is the number of items i want remove");

		for (int i = 0; i < HowManyItems; i++) {
			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();

		}

		List <WebElement> thestudentsAfterRemove = driver.findElements(By.tagName("option"));
		int ActualNumber = thestudentsAfterRemove.size();

		System.out.println("this is the new actaual number"+ActualNumber);

		int expectedITems = theTotalNumberOfStudents - HowManyItems;

		System.out.println(expectedITems + "this is the number i have expected");
		Assert.assertEquals(ActualNumber, expectedITems);


		
		Date currentDate1 = new Date();
		
		String TheAcutalDate1 = currentDate1.toString().replace(":", "-");

		TakesScreenshot src1 = ((TakesScreenshot) driver) ; 
		
		File SrcFile1 = src1.getScreenshotAs((OutputType.FILE));
		
		File Dest1 = new File("F://mypictures/"+TheAcutalDate1+".png");
		
		FileUtils.copyFile (SrcFile1,Dest1); 

	}

}
