package vendingMachine.view;

import vendingMachine.domain.Money;

import java.util.Scanner;

public class InputView {

    public static final String VENDING_MACHINE_POSSESS_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    public Money inputVendingMachineMoney() {
        System.out.println(VENDING_MACHINE_POSSESS_MONEY);
        return new Money(new Scanner(System.in).nextInt());
    }
}
