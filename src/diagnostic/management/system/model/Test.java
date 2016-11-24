/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic.management.system.model;

/**
 *
 * @author Muhi
 */
public class Test {
    
    //tabel creation query
    public static String createTable = "CREATE TABLE ("
            + "id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
            + "testname VARCHAR(100) NOT NULL,"
            + "price FLOAT NOT NULL,"
            + "maxtime VARCHAR(20))";
    
    //column name and data type
    private int id;
    private String testname;
    private float price;
    private String maxtime;

    //constuctor without id
    public Test(String testname, float price, String maxtime) {
        this.testname = testname;
        this.price = price;
        this.maxtime = maxtime;
    }
    
    //constructor with id
    public Test(int id, String testname, float price, String maxtime) {
        this.id = id;
        this.testname = testname;
        this.price = price;
        this.maxtime = maxtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMaxtime() {
        return maxtime;
    }

    public void setMaxtime(String maxtime) {
        this.maxtime = maxtime;
    }
    
    
}
