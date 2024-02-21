package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<WorkPerson> workPeople = new ArrayList<>();
        workPeople.add(new Worker("Alex Hirsh", 22, 34_000, "rub"));
        workPeople.add(new Freelancer("Jake Gisl", 30, 300, "us"));
        workPeople.add(new Freelancer("Lora Mycil", 45, 470, "us"));
        workPeople.add(new Worker("Rico Masil", 21, 41_250));
        workPeople.add(new Freelancer("Jill Kasia", 38, 250, "euro"));
        workPeople.add(new Worker("Lidia Dillia", 50, 12_250, "euro"));

        WorkPersonBank workPersonBank = new WorkPersonBank(workPeople);
        for (WorkPerson item : workPersonBank) {
            System.out.println(item);
        }

        System.out.println();

        System.out.println(workPersonBank.removePerson("Rico Masil"));

        System.out.println();
        for (WorkPerson item : workPersonBank) {
            System.out.println(item);
        }

        System.out.println();

        workPersonBank.addPerson(new Freelancer("Hank Storen", 44, 70_000));

        for (WorkPerson item : workPersonBank) {
            System.out.println(item);
        }

        System.out.println();
        System.out.println(workPersonBank.findPerson("Alex Hirsh"));

        System.out.println();

        System.out.println("Age Sort Positive:");
        workPersonBank.sortAge(false);
        for (WorkPerson item : workPersonBank) {
            System.out.println(item);
        }
        System.out.println("Age Sort Negative:");
        workPersonBank.sortAge(true);
        for (WorkPerson item : workPersonBank) {
            System.out.println(item);
        }

        System.out.println();

        System.out.println("Name Sort Positive:");
        workPersonBank.sortName(false);
        for (WorkPerson item : workPersonBank) {
            System.out.println(item);
        }
        System.out.println("Name Sort Negative:");
        workPersonBank.sortName(true);
        for (WorkPerson item : workPersonBank) {
            System.out.println(item);
        }

        System.out.println();

        System.out.println("Average Monthly Payment Sort Positive:");
        workPersonBank.sortMonthlyPayment(0.01001f, 0.925342f, false);
        for (WorkPerson item : workPersonBank) {
            System.out.println(item);
        }
        System.out.println("Average Monthly Payment Sort Negative:");
        workPersonBank.sortMonthlyPayment(0.01001f, 0.925342f, true);
        for (WorkPerson item : workPersonBank) {
            System.out.println(item);
        }

    }
}