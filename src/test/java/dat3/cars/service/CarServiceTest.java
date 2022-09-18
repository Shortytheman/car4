package dat3.cars.service;


import dat3.cars.dto.CarResponse;
import dat3.cars.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;

@DataJpaTest
public class CarServiceTest {


  CarService carService;

  @BeforeEach
  void setupBeforeEach(){
    Car garbo = Car.builder().brand("Garbo").model("numeroUno").pricePrDay(1337).bestDiscount(420).build();
    Car trasha = Car.builder().brand("Trasha").model("wurfles").pricePrDay(420).bestDiscount(1337).build();
    carService.save(garbo);
    carService.save(trasha);
  }

  @Test
  void findAmountOfCars(@Autowired ){
    List<CarResponse> cars = carService.getCars();

  }

}