package game;

import achievement.*;
import game.*;
import java.io.*;
import java.util.*;
import player.*;

/**
 * m2w: this class tends to emulate the actual match process, many are simplified.
 * For user inputs there are 4 types of commands:
 * 1. "stats(gameID)" to print out certain player's stats. e.g: stats(b1). b as blue, p as purple, 1-5 as 5 team members.
 * 2. "clearstats(gameID)" to clear a certain player's history stats. e.g: clearstats(b1)
 * 3. "n", n is an integer. Runs the game n times. e.g. 100, or 1000, or 1, etc.          ------- see logic below.
 * 4. "end", ends the simulation program.
 * 
 * ------------------------------------------------------------------------------------------------------------------------------------------------
 * runGameCommand() Logic, each game run:  (simulation of the actual system when playing a game/s)
 * 
 * 1. The java platfrom setup teams composition. ----> Both team Player Objects were created at the beginning when creating the MatchProcess Object.
 * 
 * 2. Java Platfrom passes the info and start the client to run the game. ---> Create a Game Object and run gameStart() and gameEnd(), player current 
 *    game info were generated while running game and saved in each player's CurrGameStats object..
 * 
 * 3. After the game, game info were passed to the Java Platform for stats update ---> Use each player's saved CurrGameStats Object to update players 
 *    HistoryStats Object, and AchievementHandler Object and IP, Exp, Level, etc.. (each fulfilled Achievement will reward player with certain amount of
 *    IP, rewarded Achievements wont reward again)
 * 
 * 4. Printing game summary after each game ---> prints game summaries after each game run, in similar format as the actual game.
 * 
 * 5. Check for newly earned achievements for each player, print them out. (if not a new achievement wont print.)
 * -------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * @author ruobo
 * @lastupdate 8/27/12 8:44 PM
 */
public class MatchProcess {
//===============================constructor====================================
//==================================public======================================
    /**
     * the program starting point.
     * @param args 
     * @lastupdate 8/27/12 9:27 PM
     */
    public static void main(String[] args){
        InputStreamReader istream = new InputStreamReader(System.in) ;
        BufferedReader bufRead = new BufferedReader(istream) ;
        MatchProcess mp = new MatchProcess();
        boolean endProcess = false;
        System.out.println("Welcome To m2w's LOL simulation program");
        System.out.println("Both team player Objects were created with empty history stats");
        try {
            while(endProcess != true){
                System.out.println("+++++++++++++++++++++++++++ LOL Simulation System ++++++++++++++++++++++++++");
                System.out.println("1. If you wish to see certain player's stats, please enter \"stats(gameID)\" , e.g: stats(b1), note: \"b1~b5\", or \"p1~p5\" as blue or purple team player 1 to 5");
                System.out.println("2. If you wish to clear the saved history stats, please enter \"clearstats(gameID)\", or \"clearstats3(all)\" to clear all players' history stats records");
                System.out.println("3. If you wish to play a few games, please enter how many (an int) games want to play.");
                System.out.println("4. If you wish to quit this program, please enter \"end\"");
                System.out.println("please enter the command: ");
                String command = bufRead.readLine();
                if(Character.isDigit(command.charAt(0))){// if it's run game command.
                    mp.runGameCommand(command);
                }else if(command.startsWith("stats(") && command.endsWith(")")){ // if it's stats command
                    mp.printOutPlayerInfoAndStats(command);
                }else if(command.startsWith("clearstats")){// if it's clearstats command
                    mp.clearPlayerHistStats(command);
                }else if(command.equalsIgnoreCase("end")){// if it's end command
                    endProcess = true;
                }else{
                    System.out.println("###Not a valid command, please pick one from the 3 kinds of commands###");
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
            System.out.println("###Not a valid command, please pick one from the 3 kinds of commands###");
            System.out.println();
        }
    }
//=================================private======================================
    /**
     * 1. print out player stats command
     * m2w: this is the wrapper method for "stats()" command. It parses the user's
     *      command and locate the player's stats which was wanted to print.
     * @param command : user command, e.g: stats(b1)
     */
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
            //calling from Player class.
            p.printPlayerInfoAndStats();

            System.out.println();
            System.out.println();
        }catch(Exception e){
            System.out.println("###Not a valid stats command, correct format example: \"stats(b1)\"###");
            System.out.println();
        }
    }
   
    /**
     * 2. clear players history stats command
     * m2w: this is the wrapper method for clearing player's stats command. It 
     * parses the user's command and clear the player's/all players' stats.
     * @param command : user command, e.g: clearstats(p1)
     */
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

    /**
     * 3. run game command and its sub-level methods
     * m2w: the game running wrapper method. 
     * It does:
     *      1. Creates a Game Object, run the gameStart() and gameEnd() method which create current game stats 
     *         for each player.
     *      2. If the game has ended, update each player's history stats, achievements, and IP, exp, level. 
     *         Players with un-rewarded fulfilled achievements will be rewarded with certain amount of IP.
     *      3. Prints the game summary.
     *      4. Prints newly earned achievements, if they are "new" (haven't been print out.)
     * @param command : user command, e.g: 5 or 500, 1000, etc.
     */
    private void runGameCommand(String command){
        int gameCountint = Integer.parseInt(command);
        for(int i = 0; i < gameCountint; i++){
            System.out.println("+++Game " + (i+1) + " +++");

            /*1. generate one game result*/
            Game currGame = new Game(purple_team, blue_team);
            currGame.gameStart();
            currGame.gameEnd();
            
            /*2. update player history stats, achievements, ip, exp, level.*/
            if(currGame.hasEnded()){
                this.updatePlayerHistStats();
                this.updatePlayerAchvStats();
                this.updatePlayerIpandExp();
            }else{
                System.out.println("The current game hasn't end yet.");
            }
            
            /*3. prints game summary*/
            currGame.printGameSummary();
            
            /*4. prints newly earned achievements*/
            this.printNewAchievements();
        }
        
        System.out.println();
        System.out.println();
    }
    
    /**
     * 3.2 update stats
     * m2w: this method checks each player in the 2 teams, if any achievement's criteria is met, set as fulfilled, and reward ip.
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
    
    /**
     * 3.2 update stats
     * m2w: this method update each player's history stats in the 2 teams, using their CurrGameStats object.
     * @lastupdate 8/27/12 9:10 PM
     */
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
    
    /**
     * 3.2 update stasts
     * m2w: this method update each player's ip and exp, will level up if reached next level's exp, 
     *      won't print out if player level up. Can be seen in later game runs summaries
     * @lastupdate 8/27/12 9:12 PM
     */
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
     * 3.4 prints achievements
     * m2w: this method prints out new achievements in the last step of run game command.
     *      If the flag "isNew" is false, means has been printed, won't print.
     * @lastupdate 8/27/12 9:17 PM
     */
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
    
    /**
     * m2w : wrapper method of creating blue team -- as an instance variable.
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
     * m2w : wrapper method of creating purple team -- as an instance variable.
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
