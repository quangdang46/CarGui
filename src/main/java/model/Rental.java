package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Rental {
  private Object car;
  private Customer customer;
  private Date startDate;
  private String timeRental;
  private SimpleDateFormat simpleDateFormat;

  public Rental(Object car, Customer customer, Date startDate, String timeRental) {
    this.car = car;
    this.customer = customer;
    this.startDate = startDate;
    this.timeRental = timeRental;
    this.simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
  }

  public String getPhone() {
    return customer.getPhone();
  }

  public String getNameCustomer() {
    return customer.getName();
  }

  public String getId() {
    return ((Car) car).getId();
  }

  public String getName() {
    return ((Car) car).getName();
  }

  public String getCapacity() {
    return ((Car) car).getCapacity();
  }

  public Object getCar() {
    return car;
  }

  public void setCar(Object car) {
    this.car = car;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public String getTimeRental() {
    return timeRental;
  }

  public void setTimeRental(String timeRental) {
    this.timeRental = timeRental;
  }

  @Override
  public String toString() {
    return this.car.toString() + "," + this.customer.toString() + "," + simpleDateFormat.format(startDate) + ","
        + this.timeRental;
  }

}
