import infra.BaseTest;
import org.testng.annotations.Test;
import pages.FormPage;
//מחלקה שבודקת את שדה הרשימה מקום מגורים
public class TestCityValidation extends BaseTest {

    @Test
    public void testCityValidation(){

        new FormPage().validateCity();

    }

}
