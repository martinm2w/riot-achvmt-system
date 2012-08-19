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
    public abstract boolean checkAchvCriteria(PlayerHistoryStats hisStats);
    public abstract void rewardIfFullfilled();
//=================================private======================================
//==============================instance vars===================================
    private boolean fulfilled;
    private String achv_name;
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


}
