/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ruobo
 * @lastupdate 8/15/12 11:33 PM
 */
public class Player {
    
    
    
//==========================getters & setters===================================
    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
    /**
     * @return the DateOfBirth
     */
    public String getDateOfBirth() {
        return DateOfBirth;
    }

    /**
     * @param DateOfBirth the DateOfBirth to set
     */
    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    
//===========================instance vars======================================
    private String Name;
    private String DateOfBirth;
    private String Email;


 
}
