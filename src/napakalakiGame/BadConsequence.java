package napakalakiGame;

import java.util.ArrayList;

public abstract class BadConsequence {
    static final int MAXTREASURES = 10;
    protected String text;
    protected int levels;
    
    public abstract boolean isEmpty();
    
    public int getLevels(){
        return levels;
    }
    public BadConsequence(String txt, int lev){
        text=txt;
        levels=lev;
    }
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
    public abstract String toString();
}
