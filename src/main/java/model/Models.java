package model;

import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Models {

  public Models() {

  }

  public void initCars(ArrayList<Object> list, String path) {
    try {
      File file = new File(path);
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] arr = line.split("_");
        String type = arr[0].toUpperCase().replaceAll("\\d", "");
        String id = arr[1];
        String name = arr[2];
        String capacity = arr[3];
        switch (type) {
          case "CAR":
            Carx car = new Carx(id, name, capacity);
            list.add(car);
            break;
          case "TRUCK":
            Truck truck = new Truck(id, name, capacity);
            list.add(truck);
            break;
          case "SUV":
            Suv suv = new Suv(id, name, capacity);
            list.add(suv);
            break;
          default:
            break;
        }

      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void initListRentalCustomer(ArrayList<Object> list) {
    try {
      File file = new File("./Rental.txt");
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] arr = line.split("_");
        String idCar = arr[0];
        String nameCar = arr[1];
        String capacity = arr[2];
        Object car = null;
        switch (idCar.toUpperCase().replaceAll("//d", "")) {
          case "CAR":
            car = new Carx(idCar, nameCar, capacity);
            break;
          case "TRUCK":
            car = new Truck(idCar, nameCar, capacity);
            break;
          case "SUV":
            car = new Suv(idCar, nameCar, capacity);
            break;
          default:
            break;
        }

        String stringCustomer = line.split(",")[1];
        String[] arrCustomer = stringCustomer.split("_");
        String nameCustomer = arrCustomer[0];
        String phone = arrCustomer[1];
        String stringDate = line.split(",")[2];
        String timeRental = line.split(",")[3];
        Customer customer = new Customer(nameCustomer, phone);
        Date date = null;

        try {
          date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
        } catch (ParseException e) {
          e.printStackTrace();
        } catch (Exception e) {
          System.out.println(e);
        }
        list.add(new Rental(car, customer, date, timeRental));

      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
