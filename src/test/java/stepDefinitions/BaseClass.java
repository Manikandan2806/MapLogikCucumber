package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import pageObjects.AddAssessment;
import pageObjects.AddTrainingDetails;
import pageObjects.LoginDetails;

public class BaseClass {
	public WebDriver driver;
	//public WebDriverWait wait = new WebDriverWait(driver, 10);
	public LoginDetails ld;
	public AddTrainingDetails addTrain;
	public JavascriptExecutor jsExecutor ;
	public AddAssessment addAss;
	public static Logger logger;
	public Properties configProp;
	
	public String getData(String sheetName, XSSFRow row, int column) {
		return row.getCell(column).getStringCellValue();
	}
	
}
