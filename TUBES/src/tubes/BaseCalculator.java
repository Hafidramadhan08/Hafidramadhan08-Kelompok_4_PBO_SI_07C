package tubes;

/**
 *
 * @author dell G7
 */
abstract class BaseCalculator {
    protected double weight;
    protected double temperature;
    
    public BaseCalculator(double weight, double temperature) {
        this.weight = weight;
        this.temperature = temperature;
    }
    
    public abstract double calculate();
    
    protected boolean validateInputs() {
        return weight > 0 && temperature > 0;
    }
}