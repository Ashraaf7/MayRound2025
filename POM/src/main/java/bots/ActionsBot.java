package bots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsBot {
    private WebDriver driver;
    private WaitBot waitBot;

    public ActionsBot(WebDriver driver) {
        this.driver = driver;
        this.waitBot = new WaitBot(driver);
    }

    //Clicking
    public void click(By locator) {
        waitBot.fluentWait().until(d ->
                {
                    try {
                        WebElement element = d.findElement(locator);
                        new Actions(d).scrollToElement(element);
                        element.click();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
        );
    }

    //Typing
    public void type(By locator, String text) {
        waitBot.fluentWait().until(d ->
                {
                    try {
                        WebElement element = d.findElement(locator);
                        new Actions(d).scrollToElement(element);
                        element.clear();
                        element.sendKeys(text);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
        );
    }

    //Getting text
    public String getText(By locator) {
        return waitBot.fluentWait().until(d ->
                {
                    try {
                        WebElement element = d.findElement(locator);
                        new Actions(d).scrollToElement(element);
                        String msg = element.getText();
                        return !msg.isEmpty() ? msg : null;
                    } catch (Exception e) {
                        return null;
                    }
                }
        );
    }
}
