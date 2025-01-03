/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tubes;

/**
 *
 * @author dell G7
 */
class FluidBalanceCalculator extends BaseCalculator {
    private final double infusion;
    private double waterIntake;
    private double foodLiquid;
    private double vomit;
    private double urine;
    private double feces;
    
    public FluidBalanceCalculator(double weight, double temperature, double infusion, 
            double waterIntake, double foodLiquid, double vomit, double urine, double feces) {
        super(weight, temperature);
        this.infusion = infusion;
        this.waterIntake = waterIntake;
        this.foodLiquid = foodLiquid;
        this.vomit = vomit;
        this.urine = urine;
        this.feces = feces;
    }
    
    @Override
    public double calculate() {
        if (!validateInputs()) return 0;
        double intake = infusion + waterIntake + foodLiquid;
        double output = vomit + urine + feces;
        return intake - output;
    }
}