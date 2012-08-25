/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package achievement;

import java.util.*;
import player.*;
/**
 * m2w: each player has a AchievementsHandler which has a map of achievements.
 * @author ruobo
 * @lastupdate Aug 19, 2012 
 */
public class AchievementsHandler {
//===============================constructor====================================
    public AchievementsHandler(){
        Achievement bigWinner = new Achv_BigWinner();
        Achv_Bruiser bruiser = new Achv_Bruiser();
        Achv_SharpShooter sharpShooter= new Achv_SharpShooter();
        Achv_Veteran veteran = new Achv_Veteran();
        this.allAchvmnts.put(bigWinner.getAchv_name(), bigWinner);
        this.allAchvmnts.put(bruiser.getAchv_name(), bruiser);
        this.allAchvmnts.put(sharpShooter.getAchv_name(), sharpShooter);
        this.allAchvmnts.put(veteran.getAchv_name(), veteran);
    }
//================================public========================================    
    public void checkAndRewardAchvAfterGame(Player player){
        this.updateAchvmntsStats(player);
        this.rewardFulfilledAchvmnts(player);
    }
//=================================private======================================
    /**
     * m2w: this method checks the player's achievements. and will set to fulfilled if the criteria was met.
     * @param player 
     */
    private void updateAchvmntsStats(Player player){
        for(String achvName : allAchvmnts.keySet()){
            Achievement tmpAchv = allAchvmnts.get(achvName);
            boolean fulfilled = tmpAchv.checkAchvCriteria(player);
            if(fulfilled) tmpAchv.setFulfilled(true);
        }
    }
    
    /**
     * m2w: check achvmnts if any of them fulfilled  and reward if did.
     * @lastupdate 8/19/12 1:00 PM
     */
    private void rewardFulfilledAchvmnts(Player player){
        for(String achvName : allAchvmnts.keySet()){
            Achievement tmpAchv = allAchvmnts.get(achvName);
            if(tmpAchv.isFulfilled()){
                tmpAchv.rewardIfFullfilled(player);
            }
        }
    }
//==============================instance vars===================================
    private HashMap<String, Achievement> allAchvmnts = new HashMap<String, Achievement>();
//============================setters & getters=================================

    /**
     * @return the allAchvmnts
     */
    public HashMap<String, Achievement> getAllAchvmnts() {
        return allAchvmnts;
    }

    /**
     * @param allAchvmnts the allAchvmnts to set
     */
    public void setAllAchvmnts(HashMap<String, Achievement> allAchvmnts) {
        this.allAchvmnts = allAchvmnts;
    }
}

//For the sake of later expand-ability on achievements and the achievements criteria might 
//get more complicated, I decided to create them as actual classes.