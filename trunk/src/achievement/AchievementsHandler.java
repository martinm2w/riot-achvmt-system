package achievement;

import java.util.*;
import player.*;
/**
 * m2w: each player has a AchievementsHandler which has a map of achievements.
 * For the sake of later expand-ability on achievements and the achievements criteria might 
 * get more complicated, I decided to create them as actual classes.
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
//===============================inner classes==================================
class Achv_BigWinner extends Achievement{
    public Achv_BigWinner(){
        super("Big Winner", 300);
    }
    @Override
    public boolean checkAchvCriteria(Player player) {
        if(player ==null) return false;
        int totalWin = player.getHisStats().getTotal_wins();
        if(totalWin>=200){
            return true;
        }
        return false;
    }
}

class Achv_Bruiser extends Achievement {
    public Achv_Bruiser(){
        super("Bruiser", 50);
    }
    @Override
    public boolean checkAchvCriteria(Player player) {
        if(player ==null) return false;
        int currGameDmg = player.getCurrStats().getphysical_dmg();
        if(currGameDmg >= 500){
            return true;
        }
        return false;
    }
}


class Achv_SharpShooter extends Achievement {
    public Achv_SharpShooter(){
        super("SharpShooter", 50);
    }
    @Override
    public boolean checkAchvCriteria(Player player) {
        if(player ==null) return false;
        int totalHit = player.getCurrStats().getPhysical_hits_num();
        int totalMiss = player.getCurrStats().getPhysical_miss_num();
        double accuracy = (double)totalHit / (double)(totalHit+totalMiss);
        if(accuracy >= 0.75){
            return true;
        }
        return false;
    }
}

class Achv_Veteran extends Achievement {
    public Achv_Veteran(){
        super("Veteran", 200);
    }
    @Override
    public boolean checkAchvCriteria(Player player) {
        if(player == null) return false;
        int gamesPlayed = player.getHisStats().getGames_played();
        if(gamesPlayed >= 1000){
            return true;
        }
        return false;
    }
}