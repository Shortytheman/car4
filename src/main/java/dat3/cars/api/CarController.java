package dat3.cars.api;


import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/cars")
public class CarController {

  CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  @PostMapping
  public CarResponse addCar(@RequestBody CarRequest body) {
    return carService.addCar(body, true);
  }

  @GetMapping
  public List<CarResponse> getCars() {
    return carService.getCars();
  }

  //Security ADMIN
  @DeleteMapping("/{id}")
  public void deleteCarById(@PathVariable int id) {
    carService.deleteById(id);
  }



}