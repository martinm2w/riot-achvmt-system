/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package achievement;

import player.*;

/**
 *
 * @author ruobo
 * @lastupdate Aug 17, 2012 
 */
public abstract class Achievement {
//===============================constructor====================================
    public Achievement(String name){
        this.setAchv_name(name);
        this.setFulfilled(false);
    }
//================================public========================================    
    public abstract boolean checkAchvCriteria(Player player);
    public abstract void rewardIfFullfilled(Player player);
//=================================private======================================
//==============================instance vars===================================
    private boolean fulfilled;
    private String achv_name;
    private boolean newAchv = true;
    private boolean rewarded = false;
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


}
