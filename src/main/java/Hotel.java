import java.time.DayOfWeek;
import java.time.LocalDate;

public class Hotel {

    private String name;
    private int classification;
    private int price;
    private int weekendPrice;
    private int fidelityPrice;
    private int fidelityWeekendPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public int getPrice() {
        return price;
    }

    public int getPriceByType(String type){
        return "Fidelity".equals(type) ? fidelityPrice : price;
    }

    public int getWeekendPriceByType(String type){
        return "Fidelity".equals(type) ? fidelityWeekendPrice : weekendPrice;
    }
    public int getPriceByTypeAndDate(String type, LocalDate date) {

        return isWeekend(date) ? getWeekendPriceByType(type) : getPriceByType(type);

    }

    private boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeekendPrice() {
        return weekendPrice;
    }

    public void setWeekendPrice(int weekendPrice) {
        this.weekendPrice = weekendPrice;
    }

    public int getFidelityPrice() {
        return fidelityPrice;
    }

    public void setFidelityPrice(int fidelityPrice) {
        this.fidelityPrice = fidelityPrice;
    }

    public int getFidelityWeekendPrice() {
        return fidelityWeekendPrice;
    }

    public void setFidelityWeekendPrice(int fidelityWeekendPrice) {
        this.fidelityWeekendPrice = fidelityWeekendPrice;
    }
}
