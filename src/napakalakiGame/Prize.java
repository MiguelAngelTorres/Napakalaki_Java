package napakalakiGame;

public class Prize {
    private int treasures;
    private int level;
    
    public Prize(int treas, int lev){
        treasures=treas;
        level=lev;
    }
    public int getTreasures(){
        return treasures;
    }
    public int getLevel(){
        return level;
    }
    public String toString(){
        return "Niveles ganados:" + level + " Tesoros ganados:" + treasures ;
    }
}
