/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;

public class Cultist {
    private String name;
    private int gainedLevels;
    
    public Cultist(String nam, int gainedLevel){
        name = nam;
        gainedLevels = gainedLevel;
    }
    public int getGainedLevels(){
        return gainedLevels * CultistPlayer.getTotalCultistPlayers();
    }
}
