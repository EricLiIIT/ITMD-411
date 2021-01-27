/* Eric Li
A20419312
ITMD 411
Lab 2 */

import java.io.File; // Imports file class
import java.io.FileNotFoundException; // Class to handle errors
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

// Comparator for male/female
class SexComparator implements Comparator<BankRecords> {
  public int compare(BankRecords m, BankRecords f) {
    int mf = m.getSex().compareTo(f.getSex());
    return mf;
  }
}

// Comparator for location
class LocationComparator implements Comparator<BankRecords> {
  public int compare(BankRecords o1, BankRecords o2) {
    int loc = o1.getRegion().compareTo(o2.getRegion());
    return loc;
  }
}

public class Records extends BankRecords {
  // Creates new .txt file
  static FileWriter fw = null;

	public Records() {
		try {
			fw = new FileWriter("BankRecords.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
  }

  // Sorts/calculates male/female average income
  public static void AvgIncome() {
    Arrays.sort(bank_records, new SexComparator());

    int maleQty = 0, femQty = 0;
    double maleInc = 0, femInc = 0;

    for (int i = 0; i < bank_records.length; i++) {
        if (bank_records[i].getSex().equals("MALE")) {
            ++maleQty;
            maleInc += bank_records[i].getIncome();
        }
        else {
            ++femQty;
            femInc += bank_records[i].getIncome();
        }
    }
    System.out.printf("The average income for males is: $%.2f", maleInc/maleQty);
    System.out.printf("\nThe average income for females is: $%.2f",femInc/femQty);

    // Writes to .txt file
    try{
      fw.write("The average income for males is: $" + String.format("%.2f",maleInc/maleQty));
      fw.write("\n");
      fw.write("The average income for females is: $" + String.format("%.2f",femInc/femQty));
      fw.write("\n");
    }
    catch (IOException e) {
    e.printStackTrace();
    }
  }

  // Sorts females with a mortgage and savings account
  public static void fms() {
    Arrays.sort(bank_records, new SexComparator());

    int fms = 0;

    for (int i = 0; i < bank_records.length; i++) {
      if (bank_records[i].getSex().equals("FEMALE") && bank_records[i].getMortgage().equals("YES") && bank_records[i].getSave_act().equals("YES")) {
        ++fms;
      }
    }
    System.out.println("\nThe amount of females with a mortgage and savings account: " + fms);

    // Writes to .txt file
    try{
      fw.write("The amount of females with a mortgage and savings account: " + fms);
      fw.write("\n");
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Sorts males with a child and a car in each location
  public static void mccl() {
    Arrays.sort(bank_records, new LocationComparator());

    int innerCity = 0;
    int suburbs = 0;
    int town = 0;
    int rural = 0;

    for (int i = 0; i < bank_records.length; i++) {
      if (bank_records[i].getSex().equals("MALE") && bank_records[i].getRegion().equals("INNER_CITY") && bank_records[i].getChildren() == 1 && bank_records[i].getCar().equals("YES")) {
        ++innerCity;
      }
      else if (bank_records[i].getSex().equals("MALE") && bank_records[i].getRegion().equals("SUBURBAN") && bank_records[i].getChildren() == 1 && bank_records[i].getCar().equals("YES")) {
        ++suburbs;
      }
      else if (bank_records[i].getSex().equals("MALE") && bank_records[i].getRegion().equals("RURAL") && bank_records[i].getChildren() == 1 && bank_records[i].getCar().equals("YES")) {
        ++rural;
      }
      else if (bank_records[i].getSex().equals("MALE") && bank_records[i].getRegion().equals("TOWN") && bank_records[i].getChildren() == 1 && bank_records[i].getCar().equals("YES")) {
        ++town;
      }
    }
    System.out.println("\nThe amount of males that have a car, one child and live in the inner city: " + innerCity + "\n" +
                       "The amount of males that have a car, one child and live in the suburbs: " + suburbs + "\n" +
                       "The amount of males that have a car, one child and live in a town: " + town + "\n" +
                       "The amount of males that have a car, one child and live in a rural area: " + rural);

    // Writes to .txt file
    try {
      fw.write("The amount of males that have a car, one child and live in the inner city: " + innerCity);
      fw.write("\n");
      fw.write("The amount of males that have a car, one child and live in the suburbs: " + suburbs);
      fw.write("\n");
      fw.write("The amount of males that have a car, one child and live in a town: " + town);
      fw.write("\n");
      fw.write("The amount of males that have a car, one child and live in a rural area: " + rural);
      fw.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
  }
  public static void main(String[] args) {
    Records br = new Records();
    br.readData();
    AvgIncome();
    fms();
    mccl();
  }
}


