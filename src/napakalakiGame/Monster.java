/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;

/**
 *
 * @author Windows
 */
public class Monster {
    private String name;
    private int combatLevel;
    private BadConsequence Bads;
    private Prize goods;
    private int levelChangedAgainstCultistsPlayer ;
    
    public String getName(){
        return name;
    }
    public int getCombatLevel(){
        return combatLevel;
    }
    public int getCombatLevelAgainstCultistsPlayer(){
        return levelChangedAgainstCultistsPlayer + getCombatLevel();
    }
    public BadConsequence getBadConsequence(){
        return Bads;
    }
    public int getLevelsGained(){
        return goods.getLevel();
    }
     public int getTreasuresGained(){
        return goods.getTreasures();
    }
     
     public Monster(String nm, int lvl, BadConsequence bc, Prize prize){
        name = nm;
        combatLevel=lvl;
        Bads=bc;
        goods=prize;
        levelChangedAgainstCultistsPlayer = 0;
    }
    public Monster(String nm, int lvl, BadConsequence bc, Prize prize, int lC){
        name = nm;
        combatLevel=lvl;
        Bads=bc;
        goods=prize;
        levelChangedAgainstCultistsPlayer = lC;
    }
    public String toString(){
        return name + "(" + combatLevel + ")" + "\nMal rollo:" + Bads.toString() + "\nPrize:" + goods.toString();
    }
}
