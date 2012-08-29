package achievement;

import player.*;

/**
 * m2w: this class is the abstract class for all achievements, designed as abstract class
 *      for each achievement have a different criteria for completion. 
 *      It has a non-abstract method rewardIfFullfilled(), and a instance variable "rewardIP"
 *      which was assigned in different implementation of the class as a constructor argument.
 *      So when rewarding, we just need to pass in the certain achievement's "rewardIP" as 
 *      an argument of rewardIfFullfilled().
 * @author ruobo
 * @lastupdate Aug 17, 2012 
 */
public abstract class Achievement {
//===============================constructor====================================
    public Achievement(String name, int rewardIP){
        this.setAchv_name(name);
        this.setFulfilled(false);
        this.setRewardIP(rewardIP);
    }
//================================public========================================    
    /**
     * m2w: this is the abstract method all non-abstract sub-classes need to implement
     *      Each achievement has a different criteria completion calculation.
     * @param player : the current player we are checking
     * @return : if has fulfilled
     */
    public abstract boolean checkAchvCriteria(Player player);
    
    /**
     * m2w: this method checks 2 instance variables of the certain player's achievement
     *      sub-class. see if the achievement is not rewarded and has fulfilled.
     * @param player 
     */
    public void rewardIfFullfilled(Player player) {
        if(player ==null) return;
        if(!rewarded && fulfilled){
            player.setInfluencePoints(player.getInfluencePoints()+getRewardIP());
            this.setRewarded(true);
        }
    }
//=================================private======================================
//==============================instance vars===================================
    private boolean fulfilled;          //if this achievement has been fulfilled
    private String achv_name;           //the achviement name, set while writing the sub-classes' constructors.
    private boolean newAchv = true;     //if the achviement has been announced.
    private boolean rewarded = false;   //if the achviement has been rewarded.
    private int rewardIP = 0;           //how much ip will it reward, also set in sub-classes' constructors.
//============================setters & getters=================================

    /**
     * @return the fulfilled
     */
    public boolean isFulfilled() {
        return fulfilled;
    }

    /**
     * @param fulfilled the fulfilled to set
     */
    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    /**
     * @return the achv_name
     */
    public String getAchv_name() {
        return achv_name;
    }

    /**
     * @param achv_name the achv_name to set
     */
    public void setAchv_name(String achv_name) {
        this.achv_name = achv_name;
    }

    /**
     * @return the newAchv
     */
    public boolean isNewAchv() {
        return newAchv;
    }

    /**
     * @param newAchv the newAchv to set
     */
    public void setNewAchv(boolean newAchv) {
        this.newAchv = newAchv;
    }

    /**
     * @return the rewarded
     */
    public boolean isRewarded() {
        return rewarded;
    }

    /**
     * @param rewarded the rewarded to set
     */
    public void setRewarded(boolean rewarded) {
        this.rewarded = rewarded;
    }

    /**
     * @return the rewardIP
     */
    public int getRewardIP() {
        return rewardIP;
    }

    /**
     * @param rewardIP the rewardIP to set
     */
    public void setRewardIP(int rewardIP) {
        this.rewardIP = rewardIP;
    }


}
