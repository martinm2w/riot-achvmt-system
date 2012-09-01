package achievement;

import java.util.*;
import player.*;
/**
 * m2w: each player has a AchievementsHandler which has a map of achievements. 
 *      1. At this stage of the design, I decided to create them as inner classes. 
 *          For different achievements has different requirement calculations.
 *      2. If we need many more, say 100-200 achievements, we might need to separate them 
 *          into different categories, e.g: physical related achievements, 
 *          containing "sharpshooter" and "bruiser". etc. And make different classes containing 
 *          these inner classes, for cleaner and more readable code structure.
 * @author ruobo
 * @lastupdate Aug 19, 2012 
 */
public class AchievementsHandler {
//===============================constructor====================================
    /**
     * m2w: create the map of achievements with all achievements we currently have.
     *      the achievement names are the keys. actual achievement objects are the values.
     *      -------new achievements should be added here.-------------
     */
    public AchievementsHandler(){
        Achievement bigWinner = new Achv_BigWinner();
        Achv_Bruiser bruiser = new Achv_Bruiser();
        Achv_SharpShooter sharpShooter= new Achv_SharpShooter();
        Achv_Veteran veteran = new Achv_Veteran();
        Achv_TowerDown towerDown = new Achv_TowerDown();
        Achv_TowerManiac towerManiac = new Achv_TowerManiac();
        Achv_Assitant assistant = new Achv_Assitant();
        this.allAchvmnts.put(bigWinner.getAchv_name(), bigWinner);
        this.allAchvmnts.put(bruiser.getAchv_name(), bruiser);
        this.allAchvmnts.put(sharpShooter.getAchv_name(), sharpShooter);
        this.allAchvmnts.put(veteran.getAchv_name(), veteran);
        this.allAchvmnts.put(towerDown.getAchv_name(), towerDown);
        this.allAchvmnts.put(towerManiac.getAchv_name(), towerManiac);
        this.allAchvmnts.put(assistant.getAchv_name(), assistant);
    }
//================================public========================================    
    /**
     * m2w: this wrapper method runs in the Match Process class's run match command,
     *      it first update the player's achv status, and will reward if any un-rewarded
     *      and fulfilled achievement is found.
     *      2. update player history stats, achievements, ip, exp, level.
     *           this.updatePlayerHistStats();
     *           this.updatePlayerAchvStats();     <------- here
     *           this.updatePlayerIpandExp();
     * @param player 
     */
    public void checkAndRewardAchvAfterGame(Player player){
        this.updateAchvmntsStats(player);
        this.rewardFulfilledAchvmnts(player);
    }
//=================================private======================================
    /**
     * m2w: this method checks the player's achievements, and will set to fulfilled 
     *      if the criteria was met.
     * @param player 
     * @lastupdate 8/19/12 
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
        super("Sharp Shooter", 50);
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

class Achv_TowerDown extends Achievement {
    public Achv_TowerDown(){
        super("Tower Down", 80);
    }
    @Override
    public boolean checkAchvCriteria(Player player) {
        if(player == null) return false;
        int towersTotal = player.getHisStats().getTotal_towers_takedowns();
        if(towersTotal >= 30){
            return true;
        }
        return false;
    }
}

class Achv_TowerManiac extends Achievement {
    public Achv_TowerManiac(){
        super("Tower Maniac", 180);
    }
    @Override
    public boolean checkAchvCriteria(Player player) {
        if(player == null) return false;
        int towersTotal = player.getHisStats().getTotal_towers_takedowns();
        int totalGames = player.getHisStats().getTotal_wins() + player.getHisStats().getTotal_losses();
        int average = (int)(towersTotal / totalGames);
        if(average >= 3){
            return true;
        }
        return false;
    }
}

class Achv_Assitant extends Achievement {
    public Achv_Assitant(){
        super("Assitant", 80);
    }
    @Override
    public boolean checkAchvCriteria(Player player) {
        if(player == null) return false;
        int assistsTotal = player.getHisStats().getTotal_assists();
        if(assistsTotal >= 100){
            return true;
        }
        return false;
    }
}