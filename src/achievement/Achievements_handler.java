/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package achievement;

import java.util.*;
import player.*;
/**
 *
 * @author ruobo
 * @lastupdate Aug 19, 2012 
 */
public class Achievements_handler {
//===============================constructor====================================
    public Achievements_handler(){
        Achv_BigWinner bigWinner = new Achv_BigWinner();
        Achv_Bruiser bruiser = new Achv_Bruiser();
        Achv_SharpShooter sharpShooter= new Achv_SharpShooter();
        Achv_Veteran veteran = new Achv_Veteran();
        this.allAchvmnts.put(bigWinner.getAchv_name(), bigWinner);
        this.allAchvmnts.put(bruiser.getAchv_name(), bruiser);
        this.allAchvmnts.put(sharpShooter.getAchv_name(), sharpShooter);
        this.allAchvmnts.put(veteran.getAchv_name(), veteran);
    }
//================================public========================================    
    public void updateAchvmntsStats(Player player){
        for(String achvName : allAchvmnts.keySet()){
            Achievement tmpAchv = allAchvmnts.get(achvName);
            tmpAchv.checkAchvCriteria(player);
        }
    }
    
    /**
     * m2w: check achvmnts if any of them fulfilled  and reward if did.
     * @lastupdate 8/19/12 1:00 PM
     */
    public void checkFulfilledAchvmnts(Player player){
        for(String achvName : allAchvmnts.keySet()){
            Achievement tmpAchv = allAchvmnts.get(achvName);
            if(tmpAchv.isFulfilled()){
                tmpAchv.rewardIfFullfilled(player);
            }
        }
    }
//=================================private======================================
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
