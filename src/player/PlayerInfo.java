/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

/**
 *
 * @author ruobo
 * @lastupdate 8/17/12 9:06 PM
 */
public class PlayerInfo {
//===============================constructor====================================
    public PlayerInfo(String firstName, String lastName, String email, String loginID, String password, String gameID){
    }
//================================public========================================    
//=================================private======================================
//==============================instance vars===================================
    private String firstName;
    private String lastName;
    private String email;
    private String loginID;
    private String password;
    private String gameID;//once set, can't change.
    
//===========================setters & getters==================================
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the loginID
     */
    public String getLoginID() {
        return loginID;
    }

    /**
     * @param loginID the loginID to set
     */
    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the gameID
     */
    public String getGameID() {
        return gameID;
    }

    /**
     * m2w: you need to pay to change your game ID.
     * @param gameID the gameID to set
     */
    public void setGameID(String gameID) { 
        
        if(this.getGameID()==null){
            this.gameID = gameID;
        }else{
            System.out.println("You need to pay to your game ID!!");
        }
    }
}