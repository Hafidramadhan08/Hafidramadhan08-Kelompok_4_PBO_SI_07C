package tubes;

import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class WaterIntakeCalculator extends javax.swing.JFrame {

    /**
     * Creates new form WaterInTake
     */
    public WaterIntakeCalculator() {
        initComponents();
        // Add action listeners for the buttons
        btHitungBalance.addActionListener(evt -> calculateBalanceCairan());
        btHitungKebutuhan.addActionListener(evt -> calculateKebutuhanCairan());
    }

    private void calculateBalanceCairan() {
        try {
            float infus = Float.parseFloat(txtInfus.getText());
            float airMinum = Float.parseFloat(txtAirMinum.getText());
            float sariMakanan = Float.parseFloat(txtSariMakanan.getText());
            float beratBadan = Float.parseFloat(txtBBBalance.getText());
            float muntah = Float.parseFloat(txtMuntah.getText());
            float urin = Float.parseFloat(txtUrin.getText());
            float feses = Float.parseFloat(txtFeses.getText());
            float suhu = Float.parseFloat(txtSuhuBalance.getText());

            if (suhu > 100) {
                suhu = suhu / 10.0f;
            }

            float intake = infus + airMinum + sariMakanan;
            float airMetabolisme = beratBadan * 5;
            float output = muntah + urin + feses;
            int konsIWL = 15;
            float IWL_normal = konsIWL * beratBadan;
            float kenaikanSuhu = Math.abs(suhu - 37.5f);
            float IWL_naik = (0.1f * intake) * kenaikanSuhu + IWL_normal;

            float hasilBC;
            if (suhu > 37.5) {
                hasilBC = (intake + airMetabolisme) - (output + IWL_naik);
            } else {
                hasilBC = (intake + airMetabolisme) - (output + IWL_normal);
            }

            labelHasilBalance.setText(String.format("Balance Cairan: %.2f ml", hasilBC));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Harap masukkan angka valid di semua kolom", "Kesalahan Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateKebutuhanCairan() {
        try {
            int umur = Integer.parseInt(txtUmur.getText());
            float suhu = Float.parseFloat(txtSuhuKebutuhan.getText());
            int beratBadan = Integer.parseInt(txtBBKebutuhan.getText());

            if (suhu > 100) {
                suhu = suhu / 10.0f;
            }

            int[] konsUmur = {40, 35, 30, 25};
            float hasilKonsUmur;

            if (umur >= 16 && umur <= 30) {
                hasilKonsUmur = konsUmur[0];
            } else if (umur >= 31 && umur <= 55) {
                hasilKonsUmur = konsUmur[1];
            } else if (umur >= 56 && umur <= 75) {
                hasilKonsUmur = konsUmur[2];
            } else if (umur >= 76) {
                hasilKonsUmur = konsUmur[3];
            } else {
                hasilKonsUmur = konsUmur[0];
            }

            float hasilKC = beratBadan * hasilKonsUmur;
            if (suhu > 37.5) {
                float konsNaik = hasilKC * (Math.abs(suhu - 37.5f) * 0.06f);
                hasilKC += konsNaik;
            }

            labelHasilKebutuhan.setText(String.format("Kebutuhan Cairan: %.2f ml", hasilKC));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Harap masukkan angka valid di semua kolom", "Kesalahan Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtInfus = new javax.swing.JTextField();
        txtAirMinum = new javax.swing.JTextField();
        txtSariMakanan = new javax.swing.JTextField();
        txtBBBalance = new javax.swing.JTextField();
        txtMuntah = new javax.swing.JTextField();
        txtFeses = new javax.swing.JTextField();
        txtUrin = new javax.swing.JTextField();
        txtSuhuBalance = new javax.swing.JTextField();
        btHitungBalance = new javax.swing.JButton();
        labelHasilBalance = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtUmur = new javax.swing.JTextField();
        btHitungKebutuhan = new javax.swing.JButton();
        labelHasilKebutuhan = new javax.swing.JLabel();
        txtSuhuKebutuhan = new javax.swing.JTextField();
        txtBBKebutuhan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Infus (ml)");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Air Minum (ml)");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Sari Makanan (ml)");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Berat Badan (kg)");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Muntah (ml)");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Urin (ml)");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Feses (ml)");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Suhu (C)");

        txtInfus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInfusActionPerformed(evt);
            }
        });

        txtBBBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBBBalanceActionPerformed(evt);
            }
        });

        txtMuntah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMuntahActionPerformed(evt);
            }
        });

        txtUrin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUrinActionPerformed(evt);
            }
        });

        btHitungBalance.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btHitungBalance.setText("Hitung");

        labelHasilBalance.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelHasilBalance.setText("Hasil");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("OUTPUT");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("INPUT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btHitungBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelHasilBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSuhuBalance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFeses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBBBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSariMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAirMinum, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInfus, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMuntah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUrin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtInfus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAirMinum, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSariMakanan, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBBBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMuntah, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUrin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFeses)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSuhuBalance))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btHitungBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHasilBalance))
                .addGap(91, 91, 91))
        );

        jTabbedPane3.addTab("Balance Cairan", jPanel2);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Umur");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Suhu (C)");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Berat Badan (kg)");

        txtUmur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUmurActionPerformed(evt);
            }
        });

        btHitungKebutuhan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btHitungKebutuhan.setText("Hitung");

        labelHasilKebutuhan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelHasilKebutuhan.setText("Hasil");

        txtSuhuKebutuhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSuhuKebutuhanActionPerformed(evt);
            }
        });

        txtBBKebutuhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBBKebutuhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSuhuKebutuhan, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(txtUmur, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBBKebutuhan, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(btHitungKebutuhan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)
                    .addComponent(labelHasilKebutuhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(32, 32, 32)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel10))
                    .addComponent(txtUmur, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSuhuKebutuhan, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBBKebutuhan, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(24, 24, 24))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap(455, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btHitungKebutuhan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelHasilKebutuhan))
                    .addGap(87, 87, 87)))
        );

        jTabbedPane3.addTab("Kebutuhan Cairan", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBBBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBBBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBBBalanceActionPerformed

    private void txtInfusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInfusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInfusActionPerformed

    private void txtMuntahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMuntahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMuntahActionPerformed

    private void txtUrinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUrinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUrinActionPerformed

    private void txtUmurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUmurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUmurActionPerformed

    private void txtSuhuKebutuhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSuhuKebutuhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSuhuKebutuhanActionPerformed

    private void txtBBKebutuhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBBKebutuhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBBKebutuhanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btHitungBalance;
    private javax.swing.JButton btHitungKebutuhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel labelHasilBalance;
    private javax.swing.JLabel labelHasilKebutuhan;
    private javax.swing.JTextField txtAirMinum;
    private javax.swing.JTextField txtBBBalance;
    private javax.swing.JTextField txtBBKebutuhan;
    private javax.swing.JTextField txtFeses;
    private javax.swing.JTextField txtInfus;
    private javax.swing.JTextField txtMuntah;
    private javax.swing.JTextField txtSariMakanan;
    private javax.swing.JTextField txtSuhuBalance;
    private javax.swing.JTextField txtSuhuKebutuhan;
    private javax.swing.JTextField txtUmur;
    private javax.swing.JTextField txtUrin;
    // End of variables declaration//GEN-END:variables
}
