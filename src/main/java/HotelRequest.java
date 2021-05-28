import java.time.LocalDate;
import java.util.List;

public class HotelRequest {

    private String type;
    private List<LocalDate> dateList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<LocalDate> getDateList() {
        return dateList;
    }

    public void setDateList(List<LocalDate> dateList) {
        this.dateList = dateList;
    }
}
