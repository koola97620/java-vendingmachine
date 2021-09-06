package vendingMachine;

import vendingMachine.controller.VendingMachineController;

public class VendingMachineMain {
    public static void main(String[] args) {
        VendingMachineController vendingMachineController = new VendingMachineController();
        vendingMachineController.operate();
    }
}
