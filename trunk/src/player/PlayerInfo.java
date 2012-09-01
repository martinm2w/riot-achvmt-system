package player;

/**
 * m2w: this class simulates the database saving user's info, instead of getting data from DB, 
 *      we here just get the PlayerInfo object in Player instance to get ones info.
 * @author ruobo
 * @lastupdate 8/17/12 9:06 PM
 */
public class PlayerInfo {
//===============================constructor====================================
    /**
     * m2w: pass in basic info to create a new player, just like register from the website.
     * @param firstName
     * @param lastName
     * @param email
     * @param loginID
     * @param password
     * @param gameID 
     */
    public PlayerInfo(String firstName, String lastName, String email, String loginID, String password, String gameID){
        this.setEmail(email);
        this.setFirstName(firstName);
        this.setGameID(gameID);
        this.setLastName(lastName);
        this.setLoginID(loginID);
        this.setPassword(password);
    }
//================================public========================================    
//=================================private======================================
//==============================instance vars===================================
    private String firstName;
    private String lastName;
    private String email;
    private String loginID;
    private String password;    //pw should be encripted, omitted for simplicity.
    private String gameID;      //once set, can't change. setter is modified.
    
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
