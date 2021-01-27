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

public class BankRecords extends Client {

    static BankRecords bank_records[] = new BankRecords[600];
    static ArrayList<List<String>> raw_data = new ArrayList<>();

    private String Id, region, sex, married, car, save_act, current_act, mortgage, pep;
    private int age, children;
    protected double income;

    public String getId() {
        return Id;
    }
    public void setId(String Id) {
        this.Id = Id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public double getIncome() {
        return income;
    }
    public void setIncome(double income) {
        this.income = income;
    }
    public String getMortgage() {
        return mortgage;
    }
    public void setMortgage(String mortgage) {
        this.mortgage = mortgage;
    }
    public int getChildren() {
        return children;
    }
    public void setChildren(int children) {
        this.children = children;
    }
    public String getMarriage() {
        return married;
    }
    public void setMarriage(String married) {
        this.married = married;
    }
    public String getCar() {
        return car;
    }
    public void setCar(String car) {
        this.car = car;
    }
    public String getSave_act() {
        return save_act;
    }
    public void setSave_act(String save_act) {
        this.save_act = save_act;
    }
    public String getCurrent_act() {
        return current_act;
    }
    public void setCurrent_act(String current_act) {
        this.current_act = current_act;
    }
    public String getPep() {
        return pep;
    }
    public void setPep(String pep) {
        this.pep = pep;
    }

    // Static bank_records for IO processing
    public void readData() {
        BufferedReader br;
        try { // Try/catch for error catching
            String line;
            br = new BufferedReader(new FileReader("bank-Detail.csv"));
            while ((line = br.readLine()) != null) {
                // Takes a line of data from file and stores them in raw_data in a comma separated format between each element
                raw_data.add(Arrays.asList(line.split(",")));
            }
            processData();
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not resolve file name");
            e.printStackTrace(); // Exception handling
        } catch (IOException f) { // IOException needed for br.readLine
            System.out.println("Error: " + f);
        }
    }

    public void processData() { // Enhanced For-Loop
        int idx = 0;

        for (List<String> rowData : raw_data) { // For each string in the
            bank_records[idx] = new BankRecords();
            bank_records[idx].setId(rowData.get(0));
            bank_records[idx].setAge(Integer.parseInt(rowData.get(1)));
            bank_records[idx].setSex(rowData.get(2));
            bank_records[idx].setRegion(rowData.get(3));
            bank_records[idx].setIncome(Double.parseDouble(rowData.get(4)));
            bank_records[idx].setMarriage(rowData.get(5));
            bank_records[idx].setChildren(Integer.parseInt(rowData.get(6)));
            bank_records[idx].setCar(rowData.get(7));
            bank_records[idx].setSave_act(rowData.get(8));
            bank_records[idx].setCurrent_act(rowData.get(9));
            bank_records[idx].setMortgage(rowData.get(10));
            bank_records[idx].setPep(rowData.get(11));

            idx++;
        }
        printData();
    }

    public void printData() {
        // Column headers
        System.out.print("ID" + "\t\t" + "Age" + "\t\t" + "Sex" + "\t\t" + "Region" + "\t\t" + "Mortgage" + "\t" + "Income" + "\n");
        // create for loop and grab each record bank_records' data onto the console
        for (int i = 0; i < 25; i++) {
            if (bank_records[i].getRegion().length() > 5) {
            System.out.print(bank_records[i].getId() + "\t\t");
            System.out.print(bank_records[i].getAge() + "\t\t");
            System.out.print(bank_records[i].getSex() + "\t\t");
            System.out.print(bank_records[i].getRegion() + "\t");
            System.out.print(bank_records[i].getMortgage() + "\t\t");
            System.out.print(bank_records[i].getIncome() + "\t\t");
            System.out.println();
            /*
            System.out.println(bank_records[i].getChildren() + "\t\t");
            System.out.println(bank_records[i].getCar() + "\t\t");
            System.out.println(bank_records[i].getSave_act() + "\t\t");
            System.out.println(bank_records[i].getCurrent_act() + "\t\t");
            System.out.println(bank_records[i].getMarriage() + "\t\t");
            System.out.println(bank_records[i].getPep() + "\t\t");
            */
        }   else { // Creates space between the region and mortgage data entries on print out
                System.out.print(bank_records[i].getId() + "\t\t");
                System.out.print(bank_records[i].getAge() + "\t\t");
                System.out.print(bank_records[i].getSex() + "\t\t");
                System.out.print(bank_records[i].getRegion() + "\t\t");
                System.out.print(bank_records[i].getMortgage() + "\t\t");
                System.out.print(bank_records[i].getIncome() + "\t\t");
                System.out.println();
            }
        }
    }
    /*
    public String toString() {
        return Id + "\t" + age + "\t" ;//+ sex + "\t" + region + "\t" + mortgage + "\t" + income + married + "\t"
        + children + "\t" + car + "\t" + save_act + "\t" + current_act + "\t" + pep + "\n";
    }
    */

    /* ===== Main Method In RECORDS.JAVA ===== */

}
