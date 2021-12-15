package infra;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void beforeClass() {
        Browser.driver().get("https://ft.govforms.gov.il/mw/forms/ApplicationToEnterIsrael@piba.gov.il");
    }

    @AfterClass
    public void afterClass() {
        Browser.driver().close();
    }
}
