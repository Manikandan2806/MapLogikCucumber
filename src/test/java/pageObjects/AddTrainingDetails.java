package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.BaseClass;


public class AddTrainingDetails extends BaseClass{
	public WebDriver ldriver;
	public WebDriverWait wait;

	public String excelFile = "C:\\Users\\rajag\\OneDrive\\Desktop\\MapLogik\\JJ College of Engineering\\B.E_EEE\\Add Trainings.xlsx";
	public String sheetName = "Trainings";
	public String sheetname = "PCB Design";

	public AddTrainingDetails(WebDriver rdriver) {
		ldriver = rdriver;
		wait = new WebDriverWait(rdriver, 30);
		PageFactory.initElements(rdriver, this); 
	}



	By adminEmail = By.xpath("//input[@id='login-email']");
	By adminPassword = By.xpath("//input[@id='login-password']");
	By loginButton = By.xpath("//button[@class='btn btn-primary w-100 waves-effect waves-float waves-light']");

	By skillEnhancement = By.xpath("//*[contains(text(), 'Skill Enhancement')]");
	By allTrainings = By.xpath("//*[contains(text(), 'All Trainings')]");

	By addNew = By.xpath("//*[contains(text(), 'Add New')]");
	By title = By.xpath("//div[3]/div[3]/div[1]//h2");

	By trainingName = By.xpath("//input[@name='training_name']");
	By imag = By.xpath("//input[@id='imag']");
	By autho = By.xpath("//input[@name='author']");
	By intr = By.xpath("//textarea[@name='introduction']");
	By point1 = By.xpath("//select[@name='points']");
	By freePoint = By.xpath("//input[@value='Free']");
	By paidPoint = By.xpath("//input[@value='Paid']");
	By feePoint = By.xpath("//input[@name='fees']");
	By deePoint = By.xpath("//select[@id='select2-multiple']");
	By durTime = By.xpath("//input[@name='duration']");
	//By yPoint = By.xpath("(//input[@value='Yes'])[1]");
	By yPoint = By.cssSelector("#basic-horizontal-layouts > div > div > div > div.card-body > form > div:nth-child(9) > div > div.col-sm-9 > input[type=radio]:nth-child(1)");
	By nPoint = By.xpath("(//input[@value='No'])[1]");
	By yesPoint = By.xpath("(//input[@name='is_popular'])[1]");
	By noPoint = By.xpath("(//input[@name='is_popular'])[2]");
	By curArea = By.xpath("//textarea[@name='coursecontent']");
	By nuStudent = By.xpath("//input[@name='number_of_students']");
	By nuCompanies = By.xpath("//input[@name='number_of_companies']");
	By assdur = By.xpath("//input[@name='duration_assessment']");
	By nuAss = By.xpath("//input[@name='num_que_for_assessment']");
	By queMark = By.xpath("//input[@name='individual_que_marks']");
	By assCode = By.xpath("//input[@name='assessment_code']");
	By assName = By.xpath("//input[@name='assessment_name']");
	By subMit = By.cssSelector("#submitbtn");
	By vIntr = By.id("title_video1");
	By vLink = By.xpath("//input[@id='video1']");
	By saveButton = By.xpath("//button[contains(text(), 'Save and Continue')]");
	By conText = By.xpath("//div[@class='alert alert-success']");

	JavascriptExecutor js = (JavascriptExecutor)ldriver;

	//Create Methods
	public String getTitle() {
		return ldriver.getTitle();
	}
	public void clickSkillEnhancement() {
		ldriver.findElement(skillEnhancement).click();
	}

	public void clickAllTrainings() {
		ldriver.findElement(allTrainings).click();
	}

	public void clickAddNew() {
		ldriver.findElement(addNew).click();
	}


	@SuppressWarnings("deprecation")
	public void trainingDetails() throws IOException, InterruptedException {
		wait = new WebDriverWait(ldriver, 10);
		File file = new File(excelFile);
		FileInputStream fil = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fil);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		XSSFRow row = sheet.getRow(1);

		String trainingTitle = getData(sheetName, row, 0);
		ldriver.findElement(trainingName).sendKeys(trainingTitle) ;

		String image = getData(sheetName, row, 1);
		ldriver.findElement(imag).sendKeys(image);

		String auth = getData(sheetName, row, 2);
		ldriver.findElement(autho).sendKeys(auth);

		String intro = getData(sheetName, row, 3);
		ldriver.findElement(intr).sendKeys(intro);

		Cell cell0 = sheet.getRow(1).getCell(4);
		cell0.setCellType(CellType.STRING);
		String points = cell0.getStringCellValue();
		String freepoint = "5";
		if(points.equalsIgnoreCase(freepoint)) {
			WebElement point =  ldriver.findElement(point1);
			Select select = new Select(point);
			select.selectByIndex(1);
		}else {
			WebElement point =  ldriver.findElement(point1);
			Select select = new Select(point);
			select.selectByIndex(2);
		}

		String type =  getData(sheetName, row, 5);
		String free = "Free";
		if(type.equals(free)) 
		{
			ldriver.findElement(freePoint).click();
		}
		else 
		{
			ldriver.findElement(paidPoint).click();
			Cell cell = sheet.getRow(1).getCell(6);
			cell.setCellType(CellType.STRING);
			String fee = cell.getStringCellValue();
			WebElement fees =  ldriver.findElement(feePoint);
			fees.clear();
			fees.sendKeys(String.valueOf(fee));
		}

		//String degree = getData(sheetName, row, 7);
		WebElement degrees = ldriver.findElement(deePoint);
		//String degreeText = degrees.getText();
		Select sel = new Select(degrees);
		sel.selectByVisibleText("BCA");
		sel.selectByVisibleText("B.E Information Technology");


		String duration = getData(sheetName, row, 8);
		ldriver.findElement(durTime).sendKeys(duration);

		JavascriptExecutor js1 = (JavascriptExecutor) ldriver;

		// Scroll down the page
		js1.executeScript("window.scrollBy(612, 734)");

		String mWant = getData(sheetName, row, 9);
		String yesOrno = "Yes ";

		if(mWant.equals(yesOrno)) {
			WebElement mostWantedRd = ldriver.findElement(By.xpath("(//input[@value='Yes'])[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(mostWantedRd));
			JavascriptExecutor js = (JavascriptExecutor) ldriver;
			js.executeScript("arguments[0].click()", mostWantedRd);
			//		mostWantedRd.click();

		}else {
			WebElement mostWantedRd = ldriver.findElement(By.xpath("(//input[@value='No'])[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(mostWantedRd));
			JavascriptExecutor js = (JavascriptExecutor) ldriver;
			js.executeScript("arguments[0].click()", mostWantedRd);
			//		mostWantedRd.click();

		}

		js1.executeScript("window.scrollBy(595, 714)");

		String mPopular = getData(sheetName, row, 10);
		String yesORno = "Yes ";
		if(mPopular.equals(yesORno)) 
		{
			WebElement mostWantedRd = ldriver.findElement(By.xpath("(//input[@value='Yes'])[2]"));
			wait.until(ExpectedConditions.elementToBeClickable(mostWantedRd));
			JavascriptExecutor js = (JavascriptExecutor) ldriver;
			js.executeScript("arguments[0].click()", mostWantedRd);
		}else 
		{
			WebElement mostWantedRd = ldriver.findElement(By.xpath("(//input[@value='No'])[2]"));
			wait.until(ExpectedConditions.elementToBeClickable(mostWantedRd));
			JavascriptExecutor js = (JavascriptExecutor) ldriver;
			js.executeScript("arguments[0].click()", mostWantedRd);
		}

		String content = getData(sheetName, row, 11);
		ldriver.findElement(curArea).sendKeys(content);

		Cell cell1 = sheet.getRow(1).getCell(12);
		cell1.setCellType(CellType.STRING);
		String noStudent = cell1.getStringCellValue();
		ldriver.findElement(nuStudent).sendKeys(String.valueOf(noStudent));

		Cell cell2 = sheet.getRow(1).getCell(13);
		cell2.setCellType(CellType.STRING);
		String noCompany = cell2.getStringCellValue();
		ldriver.findElement(nuCompanies).sendKeys(String.valueOf(noCompany));


		for(int j=1; j<=10; j++) {
			String companyImage = getData(sheetName, row, 14);
			ldriver.findElement(By.xpath("//input[@id='lgimag"+ j +"']")).sendKeys(companyImage);
		}

		Cell cell3 = sheet.getRow(1).getCell(15);
		cell3.setCellType(CellType.STRING);
		String assDur = cell3.getStringCellValue();
		WebElement assDura =  ldriver.findElement(assdur);
		assDura.clear();
		assDura.sendKeys(assDur);

		Cell cell4 = sheet.getRow(1).getCell(16);
		cell4.setCellType(CellType.STRING);
		String noAss = cell4.getStringCellValue();
		WebElement noAsse = ldriver.findElement(nuAss);
		noAsse.clear();
		noAsse.sendKeys(noAss);

		Cell cell5 = sheet.getRow(1).getCell(17);
		cell5.setCellType(CellType.STRING);
		String mark = cell5.getStringCellValue();
		WebElement marks = ldriver.findElement(queMark);
		marks.clear();
		marks.sendKeys(mark);

		String code = getData(sheetName, row, 18);
		ldriver.findElement(assCode).sendKeys(code);

		String name = getData(sheetName, row, 19);
		ldriver.findElement(assName).sendKeys(name);
	}

	public void clickSubmit() throws InterruptedException {
		JavascriptExecutor js1 = (JavascriptExecutor) ldriver;
		js1.executeScript("window.scrollBy(595, 714)");
		Thread.sleep(1000);
		ldriver.findElement(subMit).click();
		//wait.wait(2000);
	}	

	public void trainingVideo() throws IOException {
		File file = new File(excelFile);
		FileInputStream fil = new FileInputStream(file);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fil);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		XSSFRow row = sheet.getRow(1);
		//Add Training Videos
		ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String videoName = getData(sheetName, row, 20);
		ldriver.findElement(vIntr).sendKeys(videoName);

		String videoLink = getData(sheetName, row, 21);
		ldriver.findElement(vLink).sendKeys(videoLink);
	}

	public void clickSave() throws InterruptedException {

		WebElement sa = wait.until(ExpectedConditions.elementToBeClickable(ldriver.findElement(saveButton)));
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView(true);", sa);
		//ldriver.findElement(saveButton).click();
		//wait.wait(2000);
	}
}
