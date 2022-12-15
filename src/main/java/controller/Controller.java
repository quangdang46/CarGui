package controller;

import model.*;
import java.util.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.text.*;

public class Controller {
  public ArrayList<Object> listCars;
  public ArrayList<Object> listRental;
  public ArrayList<Object> listRentalCustomers;
  public ArrayList<Object> listReceive;
  private Models model;

  public Controller() {
    listCars = new ArrayList<Object>();
    listRental = new ArrayList<Object>();
    listRentalCustomers = new ArrayList<Object>();
    listReceive = new ArrayList<Object>();
    model = new Models();
  }

  public void init() {
    listRental.clear();
    listCars.clear();
    listRentalCustomers.clear();
    listReceive.clear();
    model.initCars(listCars, "./Cars.txt");
    model.initCars(listRental, "./Rental.txt");
    model.initListRentalCustomer(listRentalCustomers, "./Rental.txt");
    model.initListRentalCustomer(listReceive, "./Receive.txt");
  }

  public void addCarToTable(JTable table, Car car) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.addRow(new Object[] { car.getId(), car.getName(), car.getCapacity() });
  }

  public void addCustomer(JTable table, Rental rental) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.addRow(new Object[] {
        rental.getId(), rental.getName(), rental.getCapacity(), rental.getStartDate(), rental.getTimeRental(),
        rental.getNameCustomer(), rental.getPhone()

    });
  }

  public void deleteId(ArrayList<Object> list, String id) {
    for (int i = 0; i < list.size(); i++) {
      Car car = (Car) list.get(i);
      if (car.getId().equals(id)) {
        list.remove(i);
        break;
      }
    }
  }

  public Object findCar(ArrayList<Object> list, String id) {
    for (Object obj : list) {
      Car car = (Car) obj;
      if (car.getId().equals(id)) {
        return car;
      }
    }
    return null;
  }

  public void deleteRental(String id) {
    for (int i = 0; i < listRentalCustomers.size(); i++) {
      Rental rental = (Rental) listRentalCustomers.get(i);
      if (rental.getId().equals(id)) {
        listRentalCustomers.remove(i);
        break;
      }
    }
  }

  public Rental findRental(String id) {
    for (Object obj : listRentalCustomers) {
      Rental rental = (Rental) obj;
      if (rental.getId().equals(id)) {
        return rental;
      }
    }
    return null;
  }

  public void reservation(Rental rental, Object car) throws Exception {
    listRental.add(car);
    listRentalCustomers.add(rental);
    deleteId(listCars, ((Car) car).getId());
    model.writeFile(listRentalCustomers, "./Rental.txt", false);
    model.writeFile(listCars, "./Cars.txt", false);
  }

  public void returnCar(String id) throws Exception {
    Object car = findCar(listRental, id);
    listCars.add(car);
    deleteRental(id);
    deleteId(listRental, id);
    model.writeFile(listRentalCustomers, "./Rental.txt", false);
    model.writeFile(listCars, "./Cars.txt", false);
  }

  public void receiveRental(String id) throws Exception {
    Rental rental = findRental(id);
    deleteRental(id);
    deleteId(listRental, id);
    listReceive.add(rental);
    model.writeFile(listRentalCustomers, "./Rental.txt", false);
    model.writeFile(listReceive, "./Receive.txt", false);
  }
}
