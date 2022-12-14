package model;

public class PremiumCar extends Car {

  public PremiumCar() {
    super();
  }

  public PremiumCar(String id, String name, int capacity) {
    super(id, name, capacity, "Premium Car");
    if (!checkCapacity(capacity, 2000, 3000)) {
      throw new IllegalArgumentException("Capacity must be between 2000 and 3000");
    }
  }

  public int getPrice(int days) {
    return super.solvePrice(days, 50000, 40000);

  }


}
