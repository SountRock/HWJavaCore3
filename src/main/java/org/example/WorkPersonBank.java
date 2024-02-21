package org.example;

import org.example.comparators.AgeComp;
import org.example.comparators.MonthlyPaymentComp;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Банк работников
 */
public class WorkPersonBank implements Iterable<WorkPerson>{
    private List<WorkPerson> listPersons;

    public WorkPersonBank(List<WorkPerson> listPersons) {
        this.listPersons = listPersons;
    }

    /**
     * Добавить список работников
     * @param list
     */
    public void addList(List<WorkPerson> list){
        listPersons.addAll(list);
    }

    /**
     * Добавить работника
     * @param person
     */
    public void addPerson(WorkPerson person){
        listPersons.add(person);
    }

    /**
     * Удалить работника
     */
    public WorkPerson removePerson(WorkPerson person){
        return listPersons.remove(listPersons.indexOf(person));
    }

    /**
     * Удалить работника по имени
     */
    public WorkPerson removePerson(String name){
        for (int i = 0; i < listPersons.size(); i++) {
            if(listPersons.get(i).getName().equals(name)){
                return listPersons.remove(i);
            }
        }

        return null;
    }

    @Override
    public Iterator<WorkPerson> iterator() {
        return listPersons.iterator();
    }

    /**
     * Найти работника
     */
    public WorkPerson findPerson(String name){
        for (int i = 0; i < listPersons.size(); i++) {
            if(listPersons.get(i).getName().equals(name)){
                return listPersons.get(i);
            }
        }

        return null;
    }

    /**
     * Сортировать по имени
     * @param isNegative
     * @return sorted list
     */
    public List<WorkPerson> sortName(boolean isNegative){
        if(!isNegative){
            Collections.sort(listPersons);
        } else {
            Collections.sort(listPersons, Collections.reverseOrder());
        }

        return listPersons;
    }

    /**
     * Сортировать по возрасту
     * @param isNegative
     * @return sorted list
     */
    public List<WorkPerson> sortAge(boolean isNegative){
        if(!isNegative){
            listPersons.sort(new AgeComp());
        } else {
            listPersons.sort(new AgeComp().reversed());
        }

        return listPersons;
    }

    /**
     * Сортировать по среднемесячной зарплате
     * @param koeffRubToEur
     * @param koeffUsToEur
     * @param isNegative
     * @return sorted list
     */
    public List<WorkPerson> sortMonthlyPayment(float koeffRubToEur, float koeffUsToEur, boolean isNegative){
        if(!isNegative){
            listPersons.sort(new MonthlyPaymentComp(koeffRubToEur, koeffUsToEur));
        } else {
            listPersons.sort(new MonthlyPaymentComp(koeffRubToEur, koeffUsToEur).reversed());
        }

        return listPersons;
    }
}
