package model;

public class Suv extends Car {
  private String type;

  public Suv() {
    super();
  }

  public String solveType(String capacity) {
    int number = Integer.parseInt(capacity);
    if (number < 150) {
      return "Economy Suv";
    } else if (number < 250) {
      return "Small Suv";
    } else if (number < 350) {
      return "Premium Car";
    } else {
      return "Luxury Car";
    }
  }

  public Suv(String id, String name, String capacity) {
    super(id, name, capacity);
    this.type = solveType(capacity);
  }

  public String toString() {
    return super.toString() + "_" + type;
  }
}
