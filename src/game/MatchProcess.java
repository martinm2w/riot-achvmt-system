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
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("1. If you wish to see certain player's stats, please enter \"stats(gameID)\" , e.g: stats(b1), note: \"b1~b5\", or \"p1~p5\" as blue or purple team player 1 to 5");
                    System.out.println("2. If you wish to clear the saved history stats, please enter clearStats(gameID)");
                    System.out.println("3. If you wish to play a few games, please enter how many games want to play(an int)");
                    System.out.println("4. If you wish to quit this program, please enter \"end\"");
                    System.out.println("please enter the command: ");
                    String command = bufRead.readLine();
                    //
                    if(Character.isDigit(command.charAt(0))){
                        mp.runGameCommand(command);
                    }else if(command.startsWith("stats")){
                        
                    }else if(command.startsWith("clearStats")){
                        
                    }else if(command.equalsIgnoreCase("end")){
                        endProcess = true;
                    }else{
                        System.out.println("Not a valid command, please pick one from the 3 kinds of commands");
                    }
                }
               System.out.println("Please enter which player(ID)'s stats you wish to examine: ");
               String playerGameID = bufRead.readLine();
               //get which player, and prints its stats
          }
          catch (IOException err) {
               System.out.println("Error reading line");
          }
          catch(NumberFormatException err) {
               System.out.println("Error Converting Number");
          }
    }
//=================================private======================================
    /*1. print out player stats command*/
    /*1. clear players history stats command*/
    /*3. run game command and its sub-level methods*/
    private void runGameCommand(String command){
        ArrayList<Player> blue_team = this.createBlueTeam();
        ArrayList<Player> purple_team = this.createPurpleTeam();
        int gameCountint = Integer.parseInt(command);
        for(int i = 0; i < gameCountint; i++){
            System.out.println("+++Game " + (i+1) + " +++");

            //major calculation and printouts.
            /*1. generate one match result*/
            Game currGame = this.oneMatch(); //will not return null if has ended.
            /*2. update */
            if(currGame!=null){
                this.updatePlayerAchvStats(currGame);
            }else{
                System.out.println("The current game hasn't end yet.");
            }
            
            /*3. prints game summary*/
            this.printGameSummary(currGame);
            
        }
        /*4. prints newly earned achievements*/
        this.printNewAchievements();
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
    private void updatePlayerAchvStats(Game game){
        //check blue team
        for(Player p : game.getBlue_team()){
            p.getAchvHandler().checkAndRewardAchvAfterGame(p);
        }
        //check purple team
        for(Player p : game.getPurple_team()){
            p.getAchvHandler().checkAndRewardAchvAfterGame(p);
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
    
    private void printGameSummary(Game game){
        if(game.isBlueWins()){
            System.out.println("blue team won");
        }else{
            System.out.println("purple team won");
        }
        System.out.println("blue total kills: " + game.getTotalBlueKills());
        System.out.println("purple total kills: " + game.getTotalPurpleKills());
        System.out.println("========================================================================================");
        System.out.println("ID      K\\D\\A           Items          CS count       towers \t");
        for(int i = 0; i < 5; i++){
            Player blueP = game.getBlue_team().get(i);
            //info
            String bluePgameID = blueP.getInfo().getGameID();
            
            String killString = Integer.toString(blueP.getCurrStats().getKills());
            String deathString = Integer.toString(blueP.getCurrStats().getDeaths());
            String assistString = Integer.toString(blueP.getCurrStats().getAssists());
            String kdaString = killString + "\\" + deathString + "\\" + assistString;
            
            String CsString = Integer.toString(blueP.getCurrStats().getCsCount());
            String towersTaken = Integer.toString(blueP.getCurrStats().getTowersTaken());
                    
            //stats
            System.out.print(bluePgameID + "    \t" + kdaString + "    \t" + "items" + "    \t" + CsString + "        \t" + towersTaken + "    \t\n");
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        for(int i = 0; i < 5; i++){
            Player PurpleP = game.getPurple_team().get(i);
            //info
            String PurplePgameID = PurpleP.getInfo().getGameID();
            
            String killString = Integer.toString(PurpleP.getCurrStats().getKills());
            String deathString = Integer.toString(PurpleP.getCurrStats().getDeaths());
            String assistString = Integer.toString(PurpleP.getCurrStats().getAssists());
            String kdaString = killString + "\\" + deathString + "\\" + assistString;
            
            String CsString = Integer.toString(PurpleP.getCurrStats().getCsCount());
            String towersTaken = Integer.toString(PurpleP.getCurrStats().getTowersTaken());
                    
            //stats
            System.out.print(PurplePgameID + "    \t" + kdaString + "    \t" + "items" + "    \t" + CsString + "        \t" + towersTaken + "    \t\n");
        }
        System.out.println("========================================================================================");
        System.out.println();
    }
    
    private void printNewAchievements(){
        //blue achievements
        System.out.println("------blue new achvs-------");
        for(Player p : getBlue_team()){
            AchievementsHandler ah = p.getAchvHandler();
            for(Achievement achv : ah.getAllAchvmnts().values()){
                if(achv.isFulfilled() && achv.isNewAchv()){
                    System.out.println("Player " + p.getInfo().getGameID() + " has earn a new achievement: " + achv.getAchv_name() + ". Congratulations!!!");
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
                    System.out.println("Player " + p.getInfo().getGameID() + "has earn a new achievement: " + achv.getAchv_name() + ". Congratulations!!!");
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
