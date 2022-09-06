package dat3.cars.service;

import dat3.cars.api.CarController;
import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.dto.MemberRequest;
import dat3.cars.dto.MemberResponse;
import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

  CarRepository carRepository;

  public CarService(CarRepository carRepository){
    this.carRepository = carRepository;
  }

  public void deleteById(int id) {
    carRepository.deleteById(id);
  }

public CarResponse addCar(CarRequest carRequest, boolean includeAll){
  Car newCar = CarRequest.getCarEntity(carRequest);
  newCar = carRepository.save(newCar);

  return new CarResponse(newCar, includeAll);
}

  public List<CarResponse> getCars() {
    List<Car> cars = carRepository.findAll();
    List<CarResponse> response = cars.stream().map(car -> new CarResponse(car,false)).collect(Collectors.toList());
    return response;
  }

  public void save(Car car){
    carRepository.save(car);
  }

  public CarResponse findCarById(int id) {
    Car found = carRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
    return new CarResponse(found,false);
  }
}
