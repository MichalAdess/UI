import infra.BaseTest;
import org.testng.annotations.Test;
import pages.FormPage;

public class TestCityValidation extends BaseTest {

    @Test
    public void testCityValidation(){

        new FormPage().validateCity();

    }

}
