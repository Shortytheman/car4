package dat3.cars.service;

import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.entity.Car;
import java.util.List;
import dat3.cars.repository.CarRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class CarServiceMockWithH2Test {

  public CarService carService;
  public static CarRepository carRepository;

  static int car1Id;
  static int car2Id;

  @BeforeAll
  public static void setupTestData(@Autowired CarRepository carRepository1){
  carRepository = carRepository1;
  carRepository.deleteAll();

    Car garbo = Car.builder().brand("Garbo").model("numeroUno").pricePrDay(1337).bestDiscount(420).build();
    Car trasha = Car.builder().brand("Trasha").model("wurfles").pricePrDay(420).bestDiscount(1337).build();
    garbo = carRepository.save(garbo);
    trasha = carRepository.save(trasha);

    car1Id = garbo.getId();
    car2Id = trasha.getId();
  }

  @BeforeEach
  public void setupEach(){
  carService = new CarService(carRepository);
  }

  @Test
  void addCar(){
    CarRequest carRequest = new CarRequest();
    carRequest.setBrand("sæbe");
    carRequest.setModel("honinng");
    CarResponse carResponse = carService.addCar(carRequest,true);

  }

}
