package model;

public class Truck extends Car {
  private String type;

  public Truck() {
    super();
  }

  public String solveType(String capacity) {
    int number = Integer.parseInt(capacity);
    if (number <= 1) {
      return "Large Truck";
    } else if (number <= 4) {
      return "Medium Truck";
    } else {
      return "Small Truck";
    }
  }

  public Truck(String id, String name, String capacity) {
    super(id, name, capacity);
    this.type = solveType(capacity);
  }

  public String toString() {
    return super.toString() + "_" + type;
  }
}
