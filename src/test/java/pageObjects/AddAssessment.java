package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.BaseClass;


public class AddAssessment extends BaseClass{
	public WebDriver ldriver;
	public WebDriverWait wait;
	
	//Assessment Details
		By assIcon = By.xpath("//*[@id='datatable']/tbody/tr[1]/td[6]/a[3]");
		By assButton = By.xpath("//*[contains(text(), 'Add New')]");
		By qName = By.xpath("//input[@name='question_name']");
		By qImage = By.xpath("//input[@id='image_file']");
		By qO1 = By.xpath("//input[@name='question_option1']");
		By qO2 = By.xpath("//input[@name='question_option2']");
		By qO3 = By.xpath("//input[@name='question_option3']");
		By qO4 = By.xpath("//input[@name='question_option4']");
		By crtAns = By.xpath("//select[@name='correctanswer']");
		By subAss = By.id("submitbtn");
		By logOut = By.xpath("//span[contains(text(), 'Log out')]");
	
	String sheetname = "PCB Design";
		
	public AddAssessment(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void clickAddAss() {
		wait = new WebDriverWait(ldriver, 10);
		wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//*[@id='datatable']/tbody/tr[1]/td[6]/a[3]")))).click();
	}
	
	public void addAssessment() throws IOException {
		
		File files = new File("C:\\Users\\rajag\\OneDrive\\Desktop\\MapLogik\\JJ College of Engineering\\B.E_EEE\\Add Questions.xlsx");
		FileInputStream excelfile = new FileInputStream(files);
		XSSFWorkbook workBook = new XSSFWorkbook(excelfile);
		XSSFSheet sheeT = workBook.getSheet(sheetname);
						
		//for(int i=1; i<=1; i++)
		//{
			//wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(By.xpath("//*[@id='datatable']/tbody/tr["+i+"]/td[6]/a[3]")))).click();
			for (int k = 1; k <=30; k++) {
				XSSFRow row1 = sheeT.getRow(k);

				ldriver.findElement(assButton).click();

				String question = getData(sheetname, row1, 0);
				wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(qName))).sendKeys(question) ;

				String imageQuestion = getData(sheetname, row1, 1);
				wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(qImage))).sendKeys(imageQuestion);

				String optionA = getData(sheetname, row1, 2);
				wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(qO1))).sendKeys(optionA);

				String optionB = getData(sheetname, row1, 3);
				wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(qO2))).sendKeys(optionB);

				String optionC = getData(sheetname, row1, 4);
				wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(qO3))).sendKeys(optionC);

				String optionD = getData(sheetname, row1, 5);
				wait.until(ExpectedConditions.visibilityOf(ldriver.findElement(qO4))).sendKeys(optionD);

				WebElement crtAnswer = ldriver.findElement(crtAns);
				Select select = new Select(crtAnswer);
				select.selectByValue("1");
				ldriver.findElement(subAss).click();
			}
		//}
	}
	
	public void checkTotalAssessment() {
		WebElement questionCount = ldriver.findElement(By.xpath("//div[@id='datatable_info']"));
		String questionText = questionCount.getText();
		String [] split = questionText.split("\\s+/\\s+");
		String numQue = split[0];
		System.out.println("Total number of question: " +numQue);
	}
	
	

}
