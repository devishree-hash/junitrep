package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
     public static WebDriver driver;
     public static TakesScreenshot ts;
     public static Actions actions;
     public static Workbook book;
     public static File file;
     public static Sheet sheet ;
     public static Row row ;
     public static Cell cell;
    public static FileOutputStream fileOutputStream;
    public static BaseClass base=new BaseClass();
    public static org.pagemanager.PageManager pageManager = new org.pagemanager.PageManager();
    public static ExtentSparkReporter spark=new ExtentSparkReporter("target\\report.html");
    public static ExtentReports extend=new ExtentReports();
    public static ExtentTest test ;
	@BeforeClass
	public static void beforeClass() {
		
		extend.attachReporter(spark);
	    test = extend.createTest("snapdeal validation");
		test.assignAuthor("devi");
		test.assignCategory("Smoke test");
		test.assignDevice("Chrome");
			
	}
	@AfterClass
	public static void afterClass() {
		extend.flush();
	}
	
	 
    public void getDriver(String browserType,String url) {
    	 switch(browserType) {
    	 case "Chrome":
    		 WebDriverManager.chromedriver().setup();
        	 driver=new ChromeDriver();
        	 driver.get(url);
        	 break;
    	 case "Edge"	:
    		 WebDriverManager.edgedriver().setup();
        	 driver=new EdgeDriver();
        	 driver.get(url);
        default:
        	System.out.println("Invalid_browserType");
    	 
    	 }
      }
     public String readExcell(int rownum,int cellnum) throws IOException {
		 file=new File("DataBase\\snapdealbook.xlsx");
		FileInputStream input=new FileInputStream(file);
		 book=new XSSFWorkbook(input);
    	 sheet = book.getSheet("SnapDealCredentials");
    	 row = sheet.getRow(rownum);
    	 cell = row.getCell(cellnum); 
    	CellType cellType = cell.getCellType();
    	String value=null;
    	switch(cellType) {
    	case STRING:
    		value = cell.getStringCellValue();
    		break;
    	
    	case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
				 value = simpleDateFormat.format(dateCellValue);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long l=(long) numericCellValue;
				BigDecimal valueOf = BigDecimal.valueOf(l);
				 value = valueOf.toString();
				
			}
			break;
			default:
				System.out.println("Invalid Cell Type");
    	}
    	return value;
    	
	}
     public void excelReportgetRowcreateCell(int rownum,int column,WebElement element) throws IOException {
    	 fileOutputStream=new FileOutputStream(file);
         row = sheet.getRow(rownum);
		 cell = row.createCell(column);
		 
		if(element.isDisplayed()) {
        	cell.setCellValue("PASS");
        }
        else {
        	cell.setCellValue("FAIL");
        }
        book.write(fileOutputStream);

   }
	
    public void excelReportgetRowcreateCell1(int rownum,int column,String comment) throws IOException {
    	 fileOutputStream=new FileOutputStream(file);
         cell=sheet.getRow(rownum).createCell(column);
        cell.setCellValue(comment);
        book.write(fileOutputStream);

   }
     public void getWindowMax() {
		driver.manage().window().maximize();

	}
     public void sendKeyByJava(WebElement element,String text) {
		element.sendKeys(text);

	}
     public void clickButton(WebElement element) {
		element.click();

	}
     public void handlingWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> li=new LinkedList();
		li.addAll(windowHandles);
		driver.switchTo().window(li.get(1));
	}
     public void parentWindow() {
		String parentWindow = driver.getWindowHandle();
    	 driver.switchTo().window(parentWindow);
	}
     public void mouseOverActions(WebElement element) {
		actions=new Actions(driver);
		actions.moveToElement(element);

	}
     public void getScreenShot() throws IOException {
		ts=(TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("ErrorMessage\\"+System.currentTimeMillis()+".png"));
	}
	
	
	
	
	
	
}
