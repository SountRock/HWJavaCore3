package org.example;

/**
 * Класс базового рабочего
 */

public abstract class WorkPerson implements Comparable<WorkPerson>{
    private String name;
    private int age;
    private int payment;
    private String currencyType;
    private String typePayment;

    public WorkPerson(String name, int age, int payment, String currencyType, String typePayment) {
        testArgumentConstructor(age, payment);

        this.name = name;
        this.age = age;
        this.payment = payment;
        this.currencyType = currencyType;
        this.typePayment = typePayment;
    }

    /**
     * Проверить условия создания класса
     * @param age
     * @param payment
     */
    private static void testArgumentConstructor(int age, int payment){
        if(age < 18){
            throw new RuntimeException("sorry work person too young");
        }
        if(payment < 1){
            throw new RuntimeException("sorry payment too low");
        }
    }

    /**
     * Полкчить среднемесячную заработную плату
     * @return
     */
    public abstract double getAverageMonthlyPayment();

    /**
     * Получить значение платы за установленную единицу времени
     * @return
     */
    public String getPaymentInTime(){
        return payment + currencyType + " " + typePayment;
    }

    /**
     * Получить имя
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Получить зарплату в цифрах без учета валюты и типа оплаты
     * @return payment
     */
    public double getPayment(){
        return payment;
    }

    /**
     * Расчитать оплату по времени
     * @param time
     * @return payment * time
     */
    public double getPayment(int time){
        return payment * time;
    }

    /**
     * Получить в какой валюте выплачивается заплата
     * @return сurrency type
     */
    public String getCurrencyType(){
        return currencyType;
    }

    /**
     * Получить возраст
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Получить установить имя
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Установить возраст
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Установить зарплату в цифрах без учета валюты и типа оплаты
     * @param payment
     */
    public void setPayment(int payment) {
        this.payment = payment;
    }

    /**
     * Установить валюту
     * @param currencyType
     */
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    /**
     * Получить способ оплаты
     * @return
     */
    public String getTypePayment() {
        return typePayment;
    }

    @Override
    public String toString() {
        return "WorkPerson{" +
                "name=" + name +
                ", age=" + age +
                ", payment=" + payment + currencyType + " " + typePayment + '}';
    }

    @Override
    public int compareTo(WorkPerson o) {
        char[] name1 = this.name.replaceAll(" ", "").toLowerCase().toCharArray();
        char[] name2 = o.getName().replaceAll(" ", "").toLowerCase().toCharArray();

        int result = name1[0] - name2[0];

        if (result != 0){
            return result;
        } else {
            int length = name1.length < name2.length ? name1.length : name2.length;
            for (int i = 0; i < length; i++) {
                result = name1[i] - name2[i];
                if(result != 0){
                    return result;
                }
            }
        }

        return 0;
    }
}
