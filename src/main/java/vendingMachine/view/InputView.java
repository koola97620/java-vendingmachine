package vendingMachine.view;

import java.util.Scanner;

public class InputView {

    public static final String VENDING_MACHINE_POSSESS_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    public static final String VENDING_MACHINE_PRODUCTS = "상품명과 수량, 금액을 입력해 주세요.";
    public static final String INPUT_MONEY = "투입 금액을 입력해 주세요.";
    public static final String INPUT_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";

    public int settingVendingMachinePossessedMoney() {
        System.out.println(VENDING_MACHINE_POSSESS_MONEY);
        return new Scanner(System.in).nextInt();
    }

    public String[] inputProducts() {
        System.out.println(VENDING_MACHINE_PRODUCTS);
        String productsString = new Scanner(System.in).next();
        return productsString.split(";");
    }

    public int inputMoney() {
        System.out.println(INPUT_MONEY);
        return new Scanner(System.in).nextInt();
    }

    public String inputProductName() {
        System.out.println(INPUT_PRODUCT_NAME);
        return new Scanner(System.in).next();
    }
}
