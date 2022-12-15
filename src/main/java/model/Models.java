package model;

import java.util.*;
import java.io.*;
import java.text.*;

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
        String id = arr[0];
        String name = arr[1];
        String capacity = arr[2];
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
        String classname = arr[0].toUpperCase().replaceAll("\\d", "");
        Object car = null;
        System.out.println(classname);
        switch (classname) {
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

  public void writeFile(ArrayList<Object> list, String path, boolean isContinue) throws Exception {
    try {
      File file = new File(path);
      FileWriter fileWriter = new FileWriter(file, isContinue);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      for (Object obj : list) {
        bufferedWriter.write(obj.toString());
        bufferedWriter.newLine();
      }
      bufferedWriter.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
