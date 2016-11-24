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
public class Patient {
    //id not null GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), ...rest
    public static String createTable = "create table app.patient(p_id int NOT NULL, p_name varchar(20) NOT NULL, p_address varchar(200), p_phoneno varchar(20),p_ref varchar(20), p_photo blob)";
    
    private int p_id;
    private String p_name;
    private String p_address;
    private String p_phoneno;
    private String p_ref;
    private byte[] p_photo;

    public Patient(int p_id, String p_name, String p_address, String p_phoneno, String p_ref, byte[] p_photo) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_address = p_address;
        this.p_phoneno = p_phoneno;
        this.p_ref = p_ref;
        this.p_photo = p_photo;
    }    

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    
    
    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_address() {
        return p_address;
    }

    public void setP_address(String p_address) {
        this.p_address = p_address;
    }

    public String getP_phoneno() {
        return p_phoneno;
    }

    public void setP_phoneno(String p_phoneno) {
        this.p_phoneno = p_phoneno;
    }

    public String getP_ref() {
        return p_ref;
    }

    public void setP_ref(String p_ref) {
        this.p_ref = p_ref;
    }

    public byte[] getP_photo() {
        return p_photo;
    }

    public void setP_photo(byte[] p_photo) {
        this.p_photo = p_photo;
    }
    
    
    
}
