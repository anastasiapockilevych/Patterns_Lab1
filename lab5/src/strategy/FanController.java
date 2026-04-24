package strategy;

public class FanController {

    public void applyCooling(CoolingStrategy strategy) {
        strategy.cool();
    }

    public static void main(String[] args) {
        FanController controller = new FanController();

        controller.applyCooling(CoolingStrategy.silent());
        controller.applyCooling(CoolingStrategy.turbo());
        controller.applyCooling(CoolingStrategy.custom(1500, "Збалансовано"));

        controller.applyCooling(() -> System.out.println("Охолодження: авто-режим"));
    }
}