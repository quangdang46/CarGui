package model;

public class Car {
  protected String id;
  protected String name;
  protected String capacity;

  public Car() {

  }

  public Car(String id, String name, String capacity) {
    this.id = id;
    this.name = name;
    this.capacity = capacity;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCapacity() {
    return capacity;
  }

  public String toString() {
    return id + "_" + name + "_" + capacity;
  }
}
