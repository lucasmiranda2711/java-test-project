import java.util.Comparator;

public class HotelService {

    IHotelRepository hotelRepository;

    public HotelService(IHotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public String findCheapest(HotelRequest hotelRequest) {

        var hotelList = hotelRepository.findAll();

        var cheapestHotelName = hotelList.stream()
                .min(Comparator.comparingInt((Hotel i) -> getSum(hotelRequest, i))
                        .thenComparing(Hotel::getClassification));

        return cheapestHotelName.get().getName();
    }

    private int getSum(HotelRequest hotelRequest, Hotel i) {
        return hotelRequest.getDateList()
                .stream().mapToInt(date -> i.getPriceByTypeAndDate(hotelRequest.getType(), date)).sum();
    }
}
