package mediator;

public class AsusMotherboard implements Motherboard {
    public void notify(String sender, String event) {
        if (sender.equals("CPU") && event.equals("ReadData")) {
            System.out.println("Материнка: Передаю запит від CPU до RAM...");
        }
    }
}
