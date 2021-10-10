/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;
public class ModelPerson {
    private int id;
    private String firstname;
    private String lastname;
    private String dob;
    private String office;
    
    
    public ModelPerson() {
    }

    public ModelPerson(int id, String firstname, String lastname, String dob, String office) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.office = office;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
    
    
}
