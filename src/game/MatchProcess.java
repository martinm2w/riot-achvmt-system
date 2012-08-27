/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import achievement.*;
import game.*;
import java.io.*;
import java.util.*;
import player.*;

/**
 *
 * @author ruobo
 * @lastupdate Aug 19, 2012 
 */
public class MatchProcess {
//===============================constructor====================================
//==================================public======================================
    public static void main(String[] args){
        InputStreamReader istream = new InputStreamReader(System.in) ;
        BufferedReader bufRead = new BufferedReader(istream) ;
        MatchProcess mp = new MatchProcess();
        boolean endProcess = false;
            System.out.println("Welcome To m2w's LOL simulation program");
            System.out.println("Both team player Objects were pre-serialized with some saved history stats");
            //use hashmaps of sirialized player objs to simulate hibernate
            try {
                while(endProcess != true){
                    System.out.println("+++++++++++++++++++++++++++ LOL Simulation System ++++++++++++++++++++++++++");
                    System.out.println("1. If you wish to see certain player's stats, please enter \"stats(gameID)\" , e.g: stats(b1), note: \"b1~b5\", or \"p1~p5\" as blue or purple team player 1 to 5");
                    System.out.println("2. If you wish to clear the saved history stats, please enter \"clearstats(gameID)\", or \"clearstats3(all)\" to clear all players' history stats records");
                    System.out.println("3. If you wish to play a few games, please enter how many games want to play(an int)");
                    System.out.println("4. If you wish to quit this program, please enter \"end\"");
                    System.out.println("please enter the command: ");
                    String command = bufRead.readLine();
                    //
                    if(Character.isDigit(command.charAt(0))){
                        mp.runGameCommand(command);
                    }else if(command.startsWith("stats(") && command.endsWith(")")){
                        mp.printOutPlayerInfoAndStats(command);
                    }else if(command.startsWith("clearstats")){
                        mp.clearPlayerHistStats(command);
                    }else if(command.equalsIgnoreCase("end")){
                        endProcess = true;
                    }else{
                        System.out.println("###1Not a valid command, please pick one from the 3 kinds of commands###");
                        System.out.println();
                    }
                }
          }catch (IOException err) {
               System.out.println("###Error reading line###");
               System.out.println();
          }catch(NumberFormatException err) {
               System.out.println("###Error Converting Number###");
               System.out.println();
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("###2Not a valid command, please pick one from the 3 kinds of commands###");
              System.out.println();
          }
    }
//=================================private======================================
    /*1. print out player stats command*/
    private void printOutPlayerInfoAndStats(String command){
        try{
            Player p = null;
            String playerGameID = command.split("[()]")[1];
            Character.toString(playerGameID.charAt(1));
            int index = Integer.parseInt(Character.toString(playerGameID.charAt(1))) - 1;
            if(playerGameID.charAt(0) == 'p' || playerGameID.charAt(0) == 'P'){
                p = purple_team.get(index);
            }else if(playerGameID.charAt(0) == 'b' || playerGameID.charAt(0) == 'B'){
                p = blue_team.get(index);
            }
            p.printPlayerInfoAndStats();

            System.out.println();
            System.out.println();
        }catch(Exception e){
            System.out.println("###Not a valid stats command, correct format example: \"stats(b1)\"###");
            System.out.println();
        }
    }
    /*2. clear players history stats command*/
    private void clearPlayerHistStats(String command){
        try{
            String playerGameID = command.split("[()]")[1];
            if(playerGameID.equalsIgnoreCase("all")){
                //check blue team
                for(Player p : blue_team){
                    p.getHisStats().clear();
                }
                //check purple team
                for(Player p : purple_team){
                    p.getHisStats().clear();
                }
                System.out.println("###All players' history stats have been cleared.###");
                System.out.println();
            }else{
                Player p = null;
                Character.toString(playerGameID.charAt(1));
                int index = Integer.parseInt(Character.toString(playerGameID.charAt(1))) - 1;
                if(playerGameID.charAt(0) == 'p' || playerGameID.charAt(0) == 'P'){
                    p = purple_team.get(index);
                }else if(playerGameID.charAt(0) == 'b' || playerGameID.charAt(0) == 'B'){
                    p = blue_team.get(index);
                }
                p.getHisStats().clear();
                System.out.println("###Player["+p.getInfo().getGameID()+"]'s history stats has been cleared.###");
                System.out.println();
            }
            System.out.println();
        }catch(Exception e){
            System.out.println("###Not a valid clearstats command, correct format example: \"clearstats(b1)\"###");
            System.out.println();
        }
    }
    /*3. run game command and its sub-level methods*/
    private void runGameCommand(String command){
        int gameCountint = Integer.parseInt(command);
        for(int i = 0; i < gameCountint; i++){
            System.out.println("+++Game " + (i+1) + " +++");

            //major calculation and printouts.
            
            /*1. generate one match result*/
            Game currGame = this.oneMatch(); //will not return null if has ended.
            
            /*2. update player history and achievement stats*/
            if(currGame!=null){//if game ended
                this.updatePlayerHistStats();
                this.updatePlayerAchvStats();
                this.updatePlayerIpandExp();
            }else{
                System.out.println("The current game hasn't end yet.");
            }
            
            /*3. prints game summary*/
            currGame.printGameSummary(currGame);
            
            /*4. prints newly earned achievements*/
            this.printNewAchievements();
        }
        
        System.out.println();
        System.out.println();
    }
    
    private Game oneMatch(){
        Game game = new Game(purple_team, blue_team);
        game.gameStart();
        game.gameEnd();
        if(game.hasEnded()){//return the game Object if ended.
            return game;
        }
        return null;
    }
    
    /**
     * m2w: this method checks each player in the 2 teams, if any achievement's criteria is met, set as fulfilled. and reward ip.
     * @param game : the game just finished.
     * @lastupdate 8/24/12 8:42 PM 
     */
    private void updatePlayerAchvStats(){
        //check blue team
        for(Player p : blue_team){
            p.getAchvHandler().checkAndRewardAchvAfterGame(p);
        }
        //check purple team
        for(Player p : purple_team){
            p.getAchvHandler().checkAndRewardAchvAfterGame(p);
        }
    } 
    
    private void updatePlayerHistStats(){
        //check blue team
        for(Player p : blue_team){
            p.getHisStats().updatePlayerHistoryStats(p.getCurrStats());
        }
        //check purple team
        for(Player p : purple_team){
            p.getHisStats().updatePlayerHistoryStats(p.getCurrStats());
        }
    }
    
    private void updatePlayerIpandExp(){
        //check blue team
        for(Player p : blue_team){
            p.updatePlayerIPandExp();
        }
        //check purple team
        for(Player p : purple_team){
            p.updatePlayerIPandExp();
        }
    }
    
    /**
     * m2w : this is just making the class tidy. wrapper method of creating blue
     * @return the list of blue team players
     * @lastupdate 8/22/12 9:54 PM
     */
    private ArrayList<Player> createBlueTeam(){
        ArrayList<Player> blue_team = new ArrayList<Player>();
        for(int i = 1; i <=5; i++){
            PlayerInfo info = new PlayerInfo("blue"+i+"FN", "blue"+i+"LN", "blue"+i+"Email", "blue"+i+"ID", "blue"+i+"PW" , "b"+i+"");
            Player player = new Player(info);
            blue_team.add(player);
        }
        return blue_team;
    }
    
    /**
     * m2w : this is just making the class tidy. wrapper method of creating purple
     * @return the list of purple team player.
     * @lastupdate 8/22/12 9:54 PM
     */
    private ArrayList<Player> createPurpleTeam(){
        ArrayList<Player> purple_team = new ArrayList<Player>();
        for(int i = 1; i <=5; i++){
            PlayerInfo info = new PlayerInfo("purple"+i+"FN", "purple"+i+"LN", "purple"+i+"Email", "purple"+i+"ID", "purple"+i+"PW" , "p"+i+"");
            Player player = new Player(info);
            purple_team.add(player);
        }
        return purple_team;
    }
    
    private void printNewAchievements(){
        //blue achievements
        System.out.println("------blue new achvs-------");
        for(Player p : getBlue_team()){
            AchievementsHandler ah = p.getAchvHandler();
            for(Achievement achv : ah.getAllAchvmnts().values()){
                if(achv.isFulfilled() && achv.isNewAchv()){
                    System.out.println("Congratulations!!!"+" Player [" + p.getInfo().getGameID() + "] has benn awarded [" + achv.getRewardIP() + "] IP for the new achievement: [" + achv.getAchv_name() + "]");
                    achv.setNewAchv(false);//is an old achv after announced.
                }
            }
        }
        //purple achievements
        System.out.println("------purple new achvs-------");
        for(Player p : getPurple_team()){
            AchievementsHandler ah = p.getAchvHandler();
            for(Achievement achv : ah.getAllAchvmnts().values()){
                if(achv.isFulfilled() && achv.isNewAchv()){ 
                    System.out.println("Congratulations!!!"+" Player [" + p.getInfo().getGameID() + "] has benn awarded [" + achv.getRewardIP() + "] IP for the new achievement: [" + achv.getAchv_name() + "]");
                    achv.setNewAchv(false);//is an old achv after announced.
                }
            }
        }
    }
    /**/
//==============================instance vars===================================
    private ArrayList<Player> blue_team = this.createBlueTeam();
    private ArrayList<Player> purple_team = this.createPurpleTeam();
//============================setters & getters=================================

    /**
     * @return the blue_team
     */
    public ArrayList<Player> getBlue_team() {
        return blue_team;
    }

    /**
     * @param blue_team the blue_team to set
     */
    public void setBlue_team(ArrayList<Player> blue_team) {
        this.blue_team = blue_team;
    }

    /**
     * @return the purple_team
     */
    public ArrayList<Player> getPurple_team() {
        return purple_team;
    }

    /**
     * @param purple_team the purple_team to set
     */
    public void setPurple_team(ArrayList<Player> purple_team) {
        this.purple_team = purple_team;
    }
}
