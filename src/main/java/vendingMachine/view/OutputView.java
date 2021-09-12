package vendingMachine.view;

import vendingMachine.domain.VendingMachine;

public class OutputView {
    private static final String REMAIN_MONEY = "남은 금액: ";

    public void printRemainMoney(VendingMachine vendingMachine) {
        System.out.println(REMAIN_MONEY + vendingMachine.getRemainMoney());
    }

    public void printBalance() {
        System.out.println("잔돈");
    }
}
