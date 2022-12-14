package model;

public class MediumTruck extends Car {

  public MediumTruck() {
    super();
  }

  public MediumTruck(String id, String name, double capacity) {
    super(id, name, capacity, "Medium Truck");
    if (!checkCapacity(capacity, 1, 4)) {
      throw new IllegalArgumentException("Capacity must be between 1 and 4");
    }
  }

  public int getPrice(int days) {
    return super.getPriceByTruck(days, 40000);
  }

}