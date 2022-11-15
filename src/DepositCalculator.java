import java.util.Scanner;
import java.lang.Math;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().readAndPrint();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double payment = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundSum(payment, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundSum(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundSum(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void readAndPrint() {
        int amount;
        int period;
        int action;
        double yearRate = 0.06;  // хорошее решение- создать переменные
        double finalAmount = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            finalAmount = calculateSimplePercent(amount, yearRate, period);
        } else if (action == 2) {
            finalAmount = calculateComplexPercent(amount, yearRate, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + finalAmount);
    }


}
