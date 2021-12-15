package infra.ui;

import infra.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//מחלקה אבא של כל הרכיבים ותפקידה לספק פונקציונליות משותפת לכלל האוביקטים כמו חיפוש או בדיקה של טקסט
public class BaseWE {

    private String description;
    private LocateBy selectBy;
    private String selector;
    private WebElement we;
    protected int action = 0;

    public String getDescription() {
        return description;
    }

    //constructor - init fields
    public BaseWE(String description, LocateBy selectBy, String selector) {
        this.description = description;
        this.selectBy = selectBy;
        this.selector = selector;
    }

    //find the element and return WEbElement
    protected WebElement findElement() {

        try {
            we = Browser.driver().findElement(by());
        } catch (StaleElementReferenceException e) {
            this.findElement();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return we;
    }

    //convert the given string by to By object
    private By by() {
        By by = null;
        switch (selectBy) {
            case ID:
                by = By.id(this.selector);
                break;
            case ClassName:
                by = By.className(this.selector);
                break;
            case IDX:
                by = By.cssSelector("[id*='" + this.selector + "']");
                break;
            case XPATH:
                by = By.xpath(this.selector);
                break;
            case CSS:
                by = By.cssSelector(this.selector);
                break;
        }

        return by;
    }

    //validate Web element text according expected
    public void validateText(String exp) {
        String text = this.findElement().getText();
        boolean equals = text.equals(exp);
        String msg = equals ? "text validation is like expected::" + exp : "text should be: " + exp + " but actual is: " + text;
        try {
            Assert.assertTrue(equals);
            System.out.println(msg);
        } catch (Throwable e) {
            System.err.println(msg);
        }
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    //return WebElement, in case of null find it
    public WebElement getWe() {
        if (we == null) {
            this.findElement();
        }
        return we;
    }

    public enum LocateBy {

        XPATH,
        CSS,
        ClassName,
        IDX,
        ID;


    }


}
