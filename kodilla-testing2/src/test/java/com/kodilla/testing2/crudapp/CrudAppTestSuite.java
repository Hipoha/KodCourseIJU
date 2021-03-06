//package com.kodilla.testing2.crudapp;
//
//import com.kodilla.testing2.config.WebDriverConfig;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoAlertPresentException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//import java.util.stream.Collectors;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//public class CrudAppTestSuite {
//    private static final String BASE_URL = "https://Meteo-R.github.io";
//    private WebDriver driver;
//    private Random generator;
//
//    @Before
//    public void initTests() {
//        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
//        driver.get(BASE_URL);
//        generator = new Random();
//    }
//
//    @After
//    public void cleanUpAfterTest() {
//        driver.close();
//    }
//
//    private String createCrudAppTestTask() throws InterruptedException {
//        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
//        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
//        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
//        String taskName = "Task number " + generator.nextInt(100000);
//        String taskContent = taskName + " content";
//
//        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
//        name.sendKeys(taskName);
//
//        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
//        content.sendKeys(taskContent);
//
//        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
//        addButton.click();
//        Thread.sleep(2000);
//
//        return taskName;
//    }
//
//    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
//        driver.navigate().refresh();
//
//        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());
//
//        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
//                .filter(anyForm ->
//                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
//                                .getText().equals(taskName))
//                .forEach(theForm -> {
//                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
//                    Select select = new Select(selectElement);
//                    select.selectByIndex(1);
//
//                    WebElement buttonCreateCard =
//                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
//                    buttonCreateCard.click();
//                });
//        Thread.sleep(2000);
//
//        try {
//            driver.switchTo().alert().accept();
//        } catch (NoAlertPresentException e) {
//            // Do nothing
//        }
//
//        Thread.sleep(2000);
//    }
//
//    private void deleteTaskFromCrudApp(String taskName) throws InterruptedException {
//
//        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
//                .filter(anyForm ->
//                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
//                                .getText().equals(taskName))
//                .forEach(theForm -> theForm.findElement(By.xpath(".//button[contains(., \"Delete\")]")).click());
//
//        Thread.sleep(2000);
//    }
//
//    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
//        final String TRELLO_URL = "https://trello.com/login";
//        final String XPATH_TABLICA_STARTOWA = "//ul[@class=\"boards-page-board-section-list\"]" +
//                "//span[@title=\"Tablica startowa\"]";
//        final String XPATH_CARD_NAMES = "//div[@class=\"list js-list-content\"]//span[contains(@class, \"list-card-title js-card-name\")]";
//
//        boolean result = false;
//        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
//        driverTrello.get(TRELLO_URL);
//
//        driverTrello.findElement(By.id("user")).sendKeys("trello_login");
//        driverTrello.findElement(By.id("password")).sendKeys("trello_password");
//        driverTrello.findElement(By.id("login")).click();
//
//        Thread.sleep(6000);
//
//        driverTrello.findElement(By.xpath("//nav[@class=\"home-left-sidebar-container\"]"))
//                .findElement(By.linkText("Tablice")).click();
//
//        Thread.sleep(2000);
//
//        driverTrello.findElement(By.xpath(XPATH_TABLICA_STARTOWA)).click();
//
//        Thread.sleep(2000);
//
//        driverTrello.findElements(By.xpath(XPATH_CARD_NAMES));
//
//        result = driverTrello.findElements(By.xpath(XPATH_CARD_NAMES)).stream()
//                .filter(theSpan -> theSpan.getText().contains(taskName))
//                .collect(Collectors.toList())
//                .size() > 0;
//
//        driverTrello.close();
//
//        return result;
//    }
//
//    @Test
//    public void shouldCreateTrelloCard() throws InterruptedException {
//        String taskName = createCrudAppTestTask();
//        sendTestTaskToTrello(taskName);
//        deleteTaskFromCrudApp(taskName);
//        assertTrue(checkTaskExistsInTrello(taskName));
//    }
//
//}
