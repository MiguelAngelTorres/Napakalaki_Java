
package GUI;
import java.awt.Component;
import napakalakiGame.Player;
import napakalakiGame.CultistPlayer;
import napakalakiGame.BadConsequence;
import napakalakiGame.Napakalaki;
import java.util.ArrayList;
import napakalakiGame.Treasure;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PlayerView extends javax.swing.JPanel {
    Player playerModel ;
    private Napakalaki napakalakiModel;

    public PlayerView() {
        initComponents();
    }
    private void fillTreasurePanel(JPanel aPanel, ArrayList<Treasure> aList){
        aPanel.removeAll();
        for(Treasure t : aList){
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure(t);
            aTreasureView.setVisible(true);
            aPanel.add(aTreasureView);
        }
        aPanel.repaint();
        aPanel.revalidate();
    } 
    private void fillPendingPanel(JTextArea aPanel, BadConsequence pendingbads){
        aPanel.removeAll();
        if(pendingbads != null){
            aPanel.setText(pendingbads.toString());
        }else{
            aPanel.setText("No hay nada pendiente.");
        }
        aPanel.repaint();
        aPanel.revalidate();
    }
    public void setNapakalaki(Napakalaki game){
        napakalakiModel = game;
    }
    
    public void setPlayer(Player p){
        playerModel = p;
        if(playerModel instanceof CultistPlayer){
            cultist.setText("Sí");
        }else{
            cultist.setText("No");
        }
        level.setText(""+playerModel.getLevels());
        name.setText(playerModel.getName());
        fillTreasurePanel(visibleTreasures, playerModel.getVisibleTreasures());
        fillTreasurePanel(hiddenTreasures, playerModel.getHiddenTreasures());
        fillPendingPanel(pending,playerModel.getPendingBadConsequence());
        if(playerModel.infight){
            discardAllTreasures.setEnabled(false);
            discardTreasures.setEnabled(false);
            makeVisible.setEnabled(false);
            discardAllTreasures.setVisible(false);
            discardTreasures.setVisible(false);
            makeVisible.setVisible(false);
        }else{
            discardAllTreasures.setEnabled(true);
            discardTreasures.setEnabled(true);
            makeVisible.setEnabled(true);
            discardAllTreasures.setVisible(true);
            discardTreasures.setVisible(true);
            makeVisible.setVisible(true);
        }
        repaint();
        revalidate();
    }
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel){ 
        TreasureView tv; 
        ArrayList<Treasure> output = new ArrayList(); 
        for (Component c : aPanel.getComponents()){
            tv = (TreasureView)c;
            if (tv.isSelected())
                output.add(tv.getTreasure());
        } 
        return output;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cultist = new javax.swing.JLabel();
        hiddenTreasures = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        makeVisible = new javax.swing.JButton();
        discardTreasures = new javax.swing.JButton();
        discardAllTreasures = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pending = new javax.swing.JTextArea();

        name.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        name.setText("#PLAYERNAME#");

        level.setText("#LEVEL#");

        jLabel1.setText("Nivel:");

        jLabel2.setText("Sectario:");

        cultist.setText("#BOOL#");

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 20, 20), 2));
        hiddenTreasures.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jLabel4.setText("Tesoros equipados");

        jLabel5.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jLabel5.setText("Tesoros no equipados");

        visibleTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 30, 20), 2));
        visibleTreasures.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        visibleTreasures.setOpaque(false);

        makeVisible.setText("Equipar Tesoros");
        makeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleActionPerformed(evt);
            }
        });

        discardTreasures.setText("Descartar Tesoros");
        discardTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardTreasuresActionPerformed(evt);
            }
        });

        discardAllTreasures.setText("Descartar Todo");
        discardAllTreasures.setActionCommand("");
        discardAllTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardAllTreasuresActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Viner Hand ITC", 0, 15)); // NOI18N
        jLabel6.setText("Mal rollo pendiente");

        pending.setColumns(20);
        pending.setRows(5);
        jScrollPane1.setViewportView(pending);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cultist, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(makeVisible)
                        .addGap(18, 18, 18)
                        .addComponent(discardTreasures)
                        .addGap(27, 27, 27)
                        .addComponent(discardAllTreasures))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(level, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cultist)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(makeVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(discardTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(discardAllTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void makeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleActionPerformed
        ArrayList<Treasure> selectedones = getSelectedTreasures(hiddenTreasures);
        napakalakiModel.makeTreasureVisible(selectedones);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_makeVisibleActionPerformed

    private void discardTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardTreasuresActionPerformed
        ArrayList<Treasure> selectedones = getSelectedTreasures(visibleTreasures);
        napakalakiModel.discardVisibleTreasures(selectedones);
        selectedones = getSelectedTreasures(hiddenTreasures);
        napakalakiModel.discardHiddenTreasures(selectedones);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_discardTreasuresActionPerformed

    private void discardAllTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardAllTreasuresActionPerformed
       napakalakiModel.getCurrentPlayer().discardAllTreasures();
       setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_discardAllTreasuresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cultist;
    private javax.swing.JButton discardAllTreasures;
    private javax.swing.JButton discardTreasures;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel level;
    private javax.swing.JButton makeVisible;
    private javax.swing.JLabel name;
    private javax.swing.JTextArea pending;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
