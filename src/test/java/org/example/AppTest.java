package org.example;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class AppTest {
    WebDriver driver;


    @BeforeMethod
    public void setUpLauncher() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("chrome  is selected to run");

        driver.get("https:/test1.z2data.com/SCRisk/View/ItemsSummary?BomId=893eebc8-bf65-40b5-95ec-5a813c36f136&dType=2");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='Username']")).sendKeys("ahmed.mahdy@z2data.com");
        driver.findElement(By.id("Password")).sendKeys("Am@123456");
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/form/button")).click();
        Thread.sleep(5000);
        WebElement switcher = driver.findElement(By.xpath("//div[@class='jtoggler-handle']"));
    switcher.click();

        Thread.sleep(3000);
    }
/*
    @Test(priority = 1)
    public void validateTotalCardCardMatchWithMainTable() throws InterruptedException {
        Thread.sleep(8000);
        WebElement showingCounterNumber = driver.findElement(By.className("CrossRef_2_InfoTotal"));

        System.out.println("Showing Counter paging is displayed " + showingCounterNumber.isDisplayed());
        String expectedResult = showingCounterNumber.getText() + " Total";
        System.out.println(driver.findElement(By.className("CrossRef_2_Info")).getText() + " " + expectedResult);
        WebElement totalcard = driver.findElement(By.className("circletag"));
        String actulResult = totalcard.getText();
        System.out.println("TotalCard = " + actulResult);
        Assert.assertEquals(expectedResult, actulResult, "total card not match with Counter");
    }

    @Test(priority = 2)
    public void validateLowRiskCardMatchWithMainTable() throws InterruptedException {
        Thread.sleep(4000);
        WebElement lowRiskCard = driver.findElement(By.xpath("//*[@id='RemainMainPage']/app-srm/app-item-ipnview/div[1]/app-statistic/carousel/div[1]/div/div[2]/div[2]/div"));
        lowRiskCard.click();
        Thread.sleep(8000);
        String actulResult = lowRiskCard.getText();
        System.out.println("Green Card  (lowRisk)=  " + actulResult);
        WebElement showingCounterNumber = driver.findElement(By.className("CrossRef_2_InfoTotal"));

        String expectedResult = showingCounterNumber.getText() + " Total";
        System.out.println("Showing Counter  = " + expectedResult);
        Assert.assertEquals(expectedResult, actulResult, "LowRisk card not match with Counter");

    }

    @Test(priority = 3)
    public void validateMediumRiskCardMatchWithMainTable() throws InterruptedException {

        WebElement mediumRiskCard = driver.findElement(By.xpath("//*[@id='RemainMainPage']/app-srm/app-item-ipnview/div[1]/app-statistic/carousel/div[1]/div/div[3]/div[2]/div"));
        mediumRiskCard.click();
        Thread.sleep(10000);
        String actulResult = mediumRiskCard.getText();
        System.out.println("Yellow Card  (MediumRisk)=  " + actulResult);
        WebElement showingCounterNumber = driver.findElement(By.className("CrossRef_2_InfoTotal"));

        String expectedResult = showingCounterNumber.getText() + " Total";
        System.out.println("Showing Counter  = " + expectedResult);
        Assert.assertEquals(expectedResult, actulResult, "MediumRisk card not match with Counter");
    }
    @Test(priority = 4)
    public void validateHighRiskCardMatchWithMainTable() throws InterruptedException {

        WebElement HighRiskCard = driver.findElement(By.xpath("//*[@id='RemainMainPage']/app-srm/app-item-ipnview/div[1]/app-statistic/carousel/div[1]/div/div[4]/div[2]/div"));
        HighRiskCard.click();
        Thread.sleep(10000);
        String actulResult = HighRiskCard.getText();
        System.out.println("Red Card  (HighRisk)=  " + actulResult);
        WebElement showingCounterNumber = driver.findElement(By.className("CrossRef_2_InfoTotal"));

        String expectedResult = showingCounterNumber.getText() + " Total";
        System.out.println("Showing Counter  = " + expectedResult);
        Assert.assertEquals(expectedResult, actulResult, "HighRisk card not match with Counter");
    }
    @Test(priority = 5)
    public void validateUnknownCardMatchWithMainTable() throws InterruptedException {

        WebElement UnknownRiskCard = driver.findElement(By.xpath("//*[@id='RemainMainPage']/app-srm/app-item-ipnview/div[1]/app-statistic/carousel/div[1]/div/div[5]/div[2]/div"));
        UnknownRiskCard.click();
        Thread.sleep(10000);
        String actulResult = UnknownRiskCard.getText();
        System.out.println("Black Card  (Unknown)=  " + actulResult);
        WebElement showingCounterNumber = driver.findElement(By.className("CrossRef_2_InfoTotal"));

        String expectedResult = showingCounterNumber.getText() + " Total";
        System.out.println("Showing Counter  = " + expectedResult);
        Assert.assertEquals(expectedResult, actulResult, "Unknown card not match with Counter");
    }
*/
    @Test(enabled = false)
    public void getColumnNames(){
        WebElement ActualColumnHeader = driver.findElement(By.xpath("//*[@id=\"RemainMainPage\"]/app-srm/app-sc-items-summary/div[2]/app-scitems/div/div/div[2]/app-z2-table/div/div/table/thead/tr"));
        String ExpectedHeaderColumnsName ="Item Uploaded MPN Supplier Commodity Location Type Site Owner Country Sites MPN Sourcing Status Impact Score company name validation";
        System.out.println(ActualColumnHeader.getText());
        Assert.assertEquals(ActualColumnHeader,ExpectedHeaderColumnsName,"There is Missing Column in Table ");


    }
    @Test
    public void getRowCount() throws InterruptedException {

      //mpnView  List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"RemainMainPage\"]/app-srm/app-sc-items-summary/div[2]/app-scitems/div/div/div[2]/app-z2-table/div/div/table/tbody/tr"));
        List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"RemainMainPage\"]/app-srm/app-sc-items-summary/div[2]/app-item-ipnview/div/div/div[2]/app-z2-table/div/div/table/tbody/tr"));
        int rowscount =row.size();
        System.out.println("Rows in first page = "+rowscount);
        driver.findElement(By.xpath("//a[normalize-space()='Last']")).click();
        Thread.sleep(10000);

    //mpnview    List<WebElement> rowlast =driver.findElements(By.xpath("//*[@id=\"RemainMainPage\"]/app-srm/app-sc-items-summary/div[2]/app-scitems/div/div/div[2]/app-z2-table/div/div/table/tbody/tr"));
        List<WebElement> rowlast =driver.findElements(By.xpath("//*[@id=\"RemainMainPage\"]/app-srm/app-sc-items-summary/div[2]/app-item-ipnview/div/div/div[2]/app-z2-table/div/div/table/tbody/tr"));
        int rowlaast =rowlast.size();


        driver.findElement(By.xpath("//a[normalize-space()='Previous']")).click();
        String countofprevious =driver.findElement(By.xpath("(//li[@class='pagination-page page-item active'])[1]")).getText();
        System.out.println("countofprevious = "+countofprevious);
        System.out.println("Rows in Last page = "+rowlaast);
        WebElement showingCounterNumber = driver.findElement(By.className("CrossRef_2_InfoTotal"));
        String totalCount = showingCounterNumber.getText();
        System.out.println("total count ="+totalCount);
        int y = Integer.parseInt(totalCount);
        int displayedPage = (((y-rowlaast)/rowscount)+1);

        System.out.println("Displayed Pages  = "+ displayedPage);


    }
    @Test(enabled = false)
    public void getDisplayedPages(){

        WebElement lastpage =driver.findElement(By.linkText("Last"));

        WebElement firstpage =driver.findElement(By.linkText("First"));



    }

    @Test(enabled = false)
    public void getCellCount() throws InterruptedException {
        Thread.sleep(4000);

        List<WebElement> de =driver.findElements(By.tagName("td"));
        System.out.println(de.size());

    }
/*
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

*/
}
