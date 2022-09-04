package dat3.cars.dto;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarRequest {
  int id;
  String brand;
  String model;
  double pricePrDay;
  double bestDiscount;


  public static Car getCarEntity(CarRequest c){
    return new Car(c.getId(),c.getBrand(),c.getModel(), c.getPricePrDay(), c.getBestDiscount());
  }

  // Member to MemberRequest conversion
  public CarRequest(Car c){
    this.brand = c.getBrand();
    this.model = getModel();
    this.pricePrDay = getPricePrDay();
    this.bestDiscount = c.getBestDiscount();
  }
}