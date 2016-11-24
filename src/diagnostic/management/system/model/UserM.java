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
public class UserM {
    private int id;
    private String name;
    private String fullname;
    private String password;
    private String type;

    public UserM(int id, String name, String fullname, String password, String type) {
        this.id = id;
        this.name = name;
        this.fullname = fullname;
        this.password = password;
        this.type = type;
    }
    public UserM(String name, String fullname, String password, String type) {
        this.name = name;
        this.fullname = fullname;
        this.password = password;
        this.type = type;
    }
    
    
    
}
