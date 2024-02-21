package org.example.comparators;

import org.example.WorkPerson;

import java.util.Comparator;

/**
 * Сортировка по среднемесячной заработной плате
 */
public class MonthlyPaymentComp implements Comparator<WorkPerson> {
    private float koeffRubToEur;
    private float koeffUsToEur;

    public MonthlyPaymentComp(float koeffRubToEur, float koeffUsToEur) {
        this.koeffRubToEur = koeffRubToEur;
        this.koeffUsToEur = koeffUsToEur;
    }

    @Override
    public int compare(WorkPerson o1, WorkPerson o2) {
        double payment1 = o1.getAverageMonthlyPayment();
        if(o1.getCurrencyType().equals("rub")){
            payment1 *= koeffRubToEur;
        } else if(o1.getCurrencyType().equals("us")){
            payment1 *= koeffUsToEur;
        }

        double payment2 = o2.getAverageMonthlyPayment();
        if(o2.getCurrencyType().equals("rub")){
            payment2 *= koeffRubToEur;
        } else if(o2.getCurrencyType().equals("us")){
            payment2 *= koeffUsToEur;
        }

        return (int) (payment1 - payment2);
    }
}
