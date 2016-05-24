package napakalakiGame;

import java.util.ArrayList;

public class SpecificBadConsequence extends BadConsequence{
    ArrayList<TreasureKind> specificVisibleTreasures;
    ArrayList<TreasureKind> specificHiddenTreasures;
    
    SpecificBadConsequence(String text, int level, ArrayList<TreasureKind> specVisible, ArrayList<TreasureKind> specHidden){
        super(text,level);
        specificHiddenTreasures = specHidden;
        specificVisibleTreasures = specVisible;
    }
    @Override
    public boolean isEmpty(){
        if(specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty()){
            return true;
        }
    return false;       
    }
    public ArrayList<TreasureKind> getspecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    public ArrayList<TreasureKind> getspecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    @Override
    public void substractHiddenTreasure(Treasure t){
        specificHiddenTreasures.remove(t.getType());
    }
    @Override
    public void substractVisibleTreasure(Treasure t){
        specificVisibleTreasures.remove(t.getType());
    }
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        ArrayList<TreasureKind> aux = new ArrayList(specificVisibleTreasures);
        ArrayList<TreasureKind> Visible = new ArrayList();
        ArrayList<TreasureKind> Hidden = new ArrayList();
            
        for(Treasure i : v){
            for(TreasureKind j : aux){
                if(i.getType() == j){
                    Visible.add(j);
                    aux.remove(j);
                }
            }
        }
        aux = new ArrayList(specificHiddenTreasures);
        for(Treasure i : h){
            for(TreasureKind j : aux){
                if(i.getType() == j){
                    Hidden.add(j);
                    aux.remove(j);
                }
            }
        }
        BadConsequence res = new SpecificBadConsequence(text+"(MODIFICADO)",levels,Visible,Hidden);
        return res;
    }
    public String toString(){
        String visible, hidden;
        
        return text + "\n\tNiveles perdidos: " + levels + "\n\tTesoros visibles: " + specificVisibleTreasures + "\n\tTesoros ocultos: " + specificHiddenTreasures ;
    }    
}
