package infra.ui;
//רכיב מסוג אינפוט ומאפשר הקלדה וחליצה לצורך הסרת פוקוס
public class InputWe extends BaseWE {

    public InputWe(String description, LocateBy selectBy, String selector) {
        super(description, selectBy, selector);
    }

    public InputWe sendKeys(String val) {
        System.out.println("going to send key on: " + this.getDescription() + " with value: " + val);
        this.findElement().sendKeys(val);
        return this;
    }

    public InputWe click() {
        this.findElement().click();
        return this;
    }

}
