import infra.BaseTest;
import org.testng.annotations.Test;
import pages.FormPage;
//מחלקה שבודקת את שדה אימייל
public class TestEmailValidation extends BaseTest {

    @Test
    public void testEmailValidation() {

        FormPage formPage = new FormPage();
        formPage.validateEmail("aa@");
        formPage.validateEmail("11");

    }

}
