package org.example;

/**
 * Класс фрилансера
 */
public class Freelancer extends WorkPerson{
    public Freelancer(String name, int age, int payment, String currencyType) {
        super(name, age, payment, currencyType, "in hour");
    }

    public Freelancer(String name, int age, int payment) {
        super(name, age, payment, "rub", "in hour");
    }

    @Override
    public double getAverageMonthlyPayment() {
        return 20.8 * 8 * getPayment();
    }
}
