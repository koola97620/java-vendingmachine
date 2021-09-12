package vendingMachine.view;

public class OutputView {
    private static final String REMAIN_MONEY = "남은 금액: ";

    public void printRemainMoney(int remainMoney) {
        System.out.println(REMAIN_MONEY + remainMoney);
    }

    public void printBalance() {
        System.out.println("잔돈");
    }
}
