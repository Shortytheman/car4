package dat3.cars.api;


import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  @GetMapping("/{id}")
  public CarResponse getCarById(@PathVariable int id){
    return carService.findCarById(id);
  }

  //Security ADMIN
  @DeleteMapping("/{id}")
  public void deleteCarById(@PathVariable int id) {
    carService.deleteById(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Boolean> editCar(@RequestBody CarRequest body, @PathVariable int id){
    carService.editCar(body,id);
    return new ResponseEntity<>(true, HttpStatus.OK);
  }


}