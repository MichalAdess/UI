package pages;

import infra.ui.*;
//מחלקה שמתארת את הטופס מכילה את השדות ואת הפונקציונליות הנדרשת לצורך בדיקת הודעות השגיאה
public class FormPage {

    private InputWe email = new InputWe("email", BaseWE.LocateBy.CSS, "[data-testid='Email']");
    private InputWe cellphone = new InputWe("email", BaseWE.LocateBy.CSS, "[data-testid='cellphone']");
    private SimpleWE errValidation = new SimpleWE("err message", BaseWE.LocateBy.ID, "error-message-x");
    private ListBoxWE city = new ListBoxWE("city", BaseWE.LocateBy.CSS, "[data-testid='City']");
    private ButtonWE nextButton = new ButtonWE("nextButton", BaseWE.LocateBy.CSS, "[data-testid='nextButton']");

    public void validateEmail(String val) {
        email.sendKeys(val);
        //change the focus
        cellphone.click();
        errValidation.replaceId(email.getWe().getAttribute("id")).validateText("יש להזין כתובת תקינה של דואר אלקטרוני, באותיות באנגלית ללא רווחים, לדוגמא: myname@mailserver.co.il");
    }

    public void validateCity() {
        nextButton.click();
        errValidation.replaceId(city.getWe().getAttribute("aria-describedby")).validateText("חובה להזין ערך בשדה יישוב מגורים");
    }


}
