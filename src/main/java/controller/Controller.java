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

}
