/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalakiGame;
import GUI.Dice ;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

public class Maine {
    public static void main(String[] args){
        //INIT MODEL-VISUAL
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        Dice.createInstance(napakalakiView);
        
        // INIT NAMES
        ArrayList<String> names;
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView,true);
        names = namesCapture.getNames();
        // INIT GAME
        game.initGame(names);
        napakalakiView.setNapakalaki(game);
        napakalakiView.setVisible(true);
    }
}
