package infra.ui;
//רכיב לא מוגדר נוצר לצורך עבודה על האוביקטים של הודעות השגיאה
//ומאפשר פונקצינליות של המרת הסלקטור עם הID הנכון לצורך זיהוי ההודעה המותאמת לשדה
public class SimpleWE extends BaseWE {

    public SimpleWE(String description, LocateBy selectBy, String selector) {
        super(description, selectBy, selector);
    }

    public SimpleWE replaceId(String val) {
        val = val.replace("error-message-", "");
        String x = this.getSelector().replace("x", val);
        this.setSelector(x);
        return this;
    }
}
