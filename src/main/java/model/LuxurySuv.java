package model;

public class LuxurySuv extends Car {
  public LuxurySuv() {
    super();
  }

  public LuxurySuv(String id, String name, int capacity) {
    super(id, name, capacity, "Luxury Suv");
    if (!checkCapacity(capacity, 350, Integer.MAX_VALUE)) {
      throw new IllegalArgumentException("Capacity must be greater than 350");
    }
  }

  public int getPrice(int days) {
    return super.getPriceBySuv(days, 80000, 80000, 70000);
  }

}
