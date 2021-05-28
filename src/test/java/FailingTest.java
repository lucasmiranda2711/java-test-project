import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoRule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FailingTest {
   @Test
   public void shouldReturnTheCheapestHotelName() {
       var mockedRepository = Mockito.mock(IHotelRepository.class);

       Mockito.when(mockedRepository.findAll()).thenReturn(createMockedList());

       HotelService hotelService = new HotelService(mockedRepository);
       HotelRequest hotelRequest = new HotelRequest();


       hotelRequest.setType("Fidelity");
       hotelRequest.setDateList(Arrays.asList(LocalDate.of(2020,3,27),
               LocalDate.of(2020,3,28)));

       var hotelName = hotelService.findCheapest(hotelRequest);

       assertEquals("Parque das Flores", hotelName);

   }

    private List<Hotel> createMockedList() {

       List<Hotel> hotelList = new ArrayList<>();
       var hotel1 = new Hotel();
       hotel1.setName("Parque das Flores");
       hotel1.setClassification(3);
       hotel1.setPrice(110);
       hotel1.setFidelityPrice(80);
       hotel1.setWeekendPrice(90);
       hotel1.setFidelityWeekendPrice(80);

        var hotel2 = new Hotel();
        hotel2.setName("Jardim Botânico");
        hotel2.setClassification(4);
        hotel2.setPrice(160);
        hotel2.setFidelityPrice(110);
        hotel2.setWeekendPrice(60);
        hotel2.setFidelityWeekendPrice(50);

        /*var hotel3 = new Hotel();
        hotel3.setName("Mar Atlântico");
        hotel3.setClassification(5);
        hotel3.setPrice(220);
        hotel3.setFidelityPrice(100);
        hotel3.setWeekendPrice(150);
        hotel3.setFidelityWeekendPrice(40);*/

       hotelList.addAll(Arrays.asList(hotel1,hotel2));
       return hotelList;
    }
}
