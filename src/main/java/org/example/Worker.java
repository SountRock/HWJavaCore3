package org.example;

/**
 * Класс рабочего
 */
public class Worker extends WorkPerson{
    public Worker(String name, int age, int payment, String currencyType) {
        super(name, age, payment, currencyType, "in monday");
    }

    public Worker(String name, int age, int payment) {
        super(name, age, payment, "rub", "in monday");
    }

    @Override
    public double getAverageMonthlyPayment() {
        return getPayment();
    }
}
