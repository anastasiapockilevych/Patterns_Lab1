package strategy;

public class FanController {
    private CoolingStrategy strategy;
    public void setStrategy(CoolingStrategy strategy) { this.strategy = strategy; }
    public void applyCooling() { strategy.cool(); }
}