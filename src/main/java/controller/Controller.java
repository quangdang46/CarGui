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
  private Models model;

  public Controller() {
    listCars = new ArrayList<Object>();
    listRental = new ArrayList<Object>();
    listRentalCustomers = new ArrayList<Object>();
    model = new Models();
  }

  public void init() {
    model.initCars(listCars, "./Cars.txt");
    model.initCars(listRental, "./Rental.txt");
    model.initListRentalCustomer(listRentalCustomers);
  }

  public void addCarToTable(JTable table, Car car) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.addRow(new Object[] { car.getId(), car.getName(), car.getCapacity() });
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
    for (int i = 0; i < list.size(); i++) {
      Car car = (Car) list.get(i);
      if (car.getId().equals(id)) {
        return car;
      }
    }
    return null;
  }

  public void reservation(Rental rental) throws Exception {
    listRental.add(rental);
    deleteId(listCars, ((Car) rental.getCar()).getId());
    model.writeFile(listRental, "./Rental.txt", false);
    model.writeFile(listCars, "./Cars.txt", false);
  }
}
