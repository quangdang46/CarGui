package model;

public class Carx extends Car {
  private String type;

  public Carx() {
    super();
  }

  public String solveType(String capacity) {
    int number = Integer.parseInt(capacity);
    if (number < 1000) {
      return "Economy Car";
    } else if (number < 2000) {
      return "Small Car";
    } else if (number < 3000) {
      return "Premium Car";
    } else {
      return "Luxury Car";
    }
  }

  public Carx(String id, String name, String capacity) {
    super(id, name, capacity);
    this.type = solveType(capacity);
  }

  public String toString() {
    return super.toString() + "_" + type;
  }
}
