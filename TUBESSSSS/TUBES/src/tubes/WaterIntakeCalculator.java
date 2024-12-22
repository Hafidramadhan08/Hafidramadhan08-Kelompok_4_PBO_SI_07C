/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tubes;

/**
 *
 * @author dell G7
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WaterIntakeCalculator extends JFrame {
    private JTextField[] inputFields;
    private JLabel resultLabel;
    private final JTabbedPane tabbedPane;
    
    // Mode constants
    private static final int MODE_BALANCE_CAIRAN = 0;
    private static final int MODE_KEBUTUHAN_CAIRAN = 1;
    
    // Input fields for Balance Cairan mode
    private static final String[] BC_LABELS = {
        "Infus (ml)", "Air Minum (ml)", "Sari Makanan (ml)", 
        "Berat Badan (kg)", "Muntah (ml)", "Urin (ml)", 
        "Feses (ml)", "Suhu (°C)"
    };
    
    // Input fields for Kebutuhan Cairan mode
    private static final String[] KC_LABELS = {
        "Umur", "Suhu (°C)", "Berat Badan (kg)"
    };
    
    public WaterIntakeCalculator() {
        setTitle("Kalkulator H2O");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Create tabbed pane for two modes
        tabbedPane = new JTabbedPane();
        
        // Balance Cairan Mode Panel
        JPanel balanceCairanPanel = createInputPanel(BC_LABELS, MODE_BALANCE_CAIRAN);
        tabbedPane.addTab("Balance Cairan", balanceCairanPanel);
        
        // Kebutuhan Cairan Mode Panel
        JPanel kebutuhanCairanPanel = createInputPanel(KC_LABELS, MODE_KEBUTUHAN_CAIRAN);
        tabbedPane.addTab("Kebutuhan Cairan", kebutuhanCairanPanel);
        
        add(tabbedPane, BorderLayout.CENTER);
    }
    
    private JPanel createInputPanel(String[] labels, int mode) {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        inputFields = new JTextField[labels.length];
        
        // Create input fields
        for (int i = 0; i < labels.length; i++) {
            panel.add(new JLabel(labels[i]));
            inputFields[i] = new JTextField(10);
            panel.add(inputFields[i]);
        }
        
        // Calculate button
        JButton calculateButton = new JButton("Hitung");
        calculateButton.addActionListener(e -> calculateResult(mode));
        panel.add(calculateButton);
        
        // Result label
        resultLabel = new JLabel("Hasil: ");
        panel.add(resultLabel);
        
        return panel;
    }
    
    private void calculateResult(int mode) {
        try {
            if (mode == MODE_BALANCE_CAIRAN) {
                calculateBalanceCairan();
            } else {
                calculateKebutuhanCairan();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Harap masukkan angka valid di semua kolom", 
                "Kesalahan Input", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void calculateBalanceCairan() {
        float infus = Float.parseFloat(inputFields[0].getText());
        float airMinum = Float.parseFloat(inputFields[1].getText());
        float sariMakanan = Float.parseFloat(inputFields[2].getText());
        float beratBadan = Float.parseFloat(inputFields[3].getText());
        float muntah = Float.parseFloat(inputFields[4].getText());
        float urin = Float.parseFloat(inputFields[5].getText());
        float feses = Float.parseFloat(inputFields[6].getText());
        float suhu = Float.parseFloat(inputFields[7].getText());
        
        // Adjust suhu if input seems to be in tenths
        if (suhu > 100) {
            suhu = suhu / 10.0f;
        }
        
        float intake = infus + airMinum + sariMakanan;
        float airMetabolisme = beratBadan * 5;
        float output = muntah + urin + feses;
        
        // Constants
        int konsMetabolisme = 5;
        int konsIWL = 15;
        
        float IWL_normal = konsIWL * beratBadan;
        float kenaikanSuhu = Math.abs(suhu - 37.5f);
        float IWL_naik;
        float hasilBC;
        
        IWL_naik = (0.1f * intake) * kenaikanSuhu + IWL_normal;
        
        if (suhu > 37.5) {
            hasilBC = Math.abs(intake + airMetabolisme) - (output + IWL_naik);
        } else {
            hasilBC = (intake + airMetabolisme) - (output + IWL_normal);
        }
        
        resultLabel.setText(String.format("Kebutuhan Cairan: %.2f ml", hasilBC));
    }
    
    private void calculateKebutuhanCairan() {
        int umur = Integer.parseInt(inputFields[0].getText());
        float suhu = Float.parseFloat(inputFields[1].getText());
        int beratBadan = Integer.parseInt(inputFields[2].getText());
        
        // Adjust suhu if input seems to be in tenths
        if (suhu > 100) {
            suhu = suhu / 10.0f;
        }
        
        // Age-based constants
        int[] konsUmur = {40, 35, 30, 25};
        float hasilKonsUmur;
        
        // Determine constant based on age groups
        if (umur >= 16 && umur <= 30) {
            hasilKonsUmur = konsUmur[0];
        } else if (umur >= 31 && umur <= 55) {
            hasilKonsUmur = konsUmur[1];
        } else if (umur >= 56 && umur <= 75) {
            hasilKonsUmur = konsUmur[2];
        } else if (umur >= 76) {
            hasilKonsUmur = konsUmur[3];
        } else {
            hasilKonsUmur = konsUmur[0]; // Default to youngest group
        }
        
        float hasilKC = beratBadan * hasilKonsUmur;
        
        // Adjust for elevated temperature
        if (suhu > 37.5) {
            float konsNaik = hasilKC * (Math.abs(suhu - 37.5f) * 0.06f);
            hasilKC += konsNaik;
        }
        
        resultLabel.setText(String.format("Kebutuhan Cairan: %.2f ml", hasilKC));
    }
    
    public static void main(String[] args) {
        // Use Swing thread for thread safety
        SwingUtilities.invokeLater(() -> {
            new WaterIntakeCalculator().setVisible(true);
        });
    }
}

