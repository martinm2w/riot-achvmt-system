package achievement;

import player.*;

/**
 *
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
    public abstract boolean checkAchvCriteria(Player player);
    public void rewardIfFullfilled(Player player) {
        if(player ==null) return;
        if(!rewarded && fulfilled){
            player.setInfluencePoints(player.getInfluencePoints()+getRewardIP());
            this.setRewarded(true);
        }
    }
//=================================private======================================
//==============================instance vars===================================
    private boolean fulfilled;
    private String achv_name;
    private boolean newAchv = true;
    private boolean rewarded = false;
    private int rewardIP = 0;
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
