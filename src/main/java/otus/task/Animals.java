package otus.task;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Animals {
    String name;
    int age;
    int weight;
    String color;
    ArrayList<Animals> animals;


    //  Сеттеры/Геттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //  Методы
    public String say() {
        return "Я говорю";
    }

    public String go() {
        return "Я иду";
    }

    public String drink() {
        return "Я пью";
    }

    public String eat() {
        return "Я ем";
    }

    public String typeYear(int age) {
        int lastDigit = age % 10;
        if (age == 1 || age > 20 && lastDigit == 1) {
            return "год";
        } else if (age >= 2 && age <= 4 || age > 20 && lastDigit >= 2 && lastDigit <= 4) {
            return "года";
        } else if (age >= 5 && age <= 20 || age > 20 && lastDigit >= 5 || lastDigit == 0) {
            return "лет";
        } else {
            return "Чёт ты навертел мой друг ))";
        }
    }

    @Override
    public String toString() {
        return "Привет! Меня зовут " + name + ", мне " + age + " " + typeYear(age) + ", я вешу " + weight + " кг, мой цвет " + color;

    }
}
