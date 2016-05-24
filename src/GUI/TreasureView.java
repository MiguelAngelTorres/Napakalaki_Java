/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import napakalakiGame.Treasure;
import napakalakiGame.TreasureKind;

public class TreasureView extends javax.swing.JPanel {
    Treasure treasureModel;
    boolean selected = false;
    
    public boolean isSelected(){
        return selected;
    }
    public Treasure getTreasure(){
        return treasureModel;
    }
    public TreasureView() {
        initComponents();
    }
    public void setTreasure(Treasure t){
        treasureModel = t;
        name.setText(treasureModel.getName());
        kind.setText(treasureModel.getType().toString());
        bonus.setText("" + treasureModel.getBonus());
        this.setVisible(true);
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        kind = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bonus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(80, 140, 200));
        setOpaque(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        name.setFont(new java.awt.Font("Viner Hand ITC", 0, 16)); // NOI18N
        name.setText("#NOMBRE#");

        kind.setText("#TREASUREKIND#");

        jLabel1.setText("+");

        bonus.setText("#BONUS#");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bonus))
            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bonus)
                    .addComponent(jLabel1)
                    .addComponent(kind))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        selected = !selected;
        this.setOpaque(selected);
        repaint();
        revalidate();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bonus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel kind;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}
