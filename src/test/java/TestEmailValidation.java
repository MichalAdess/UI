import infra.BaseTest;
import org.testng.annotations.Test;
import pages.FormPage;

public class TestEmailValidation extends BaseTest {

    @Test
    public void testEmailValidation(){

        new FormPage().validateEmail("aa");
//        new FormPage().validateEmail("11");

    }

}
