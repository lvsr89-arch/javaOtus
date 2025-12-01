package otus.task;

import otus.task.animal.Color;

public abstract class Animal {

    private String name;
    private int age;
    private int weight;
    private Color color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    @Override
    public String toString() {
        return String.format("«Привет! Меня зовут %s, мне age лет %d %s, я вешу - weight кг, мой цвет - color", name, age, getAgeSuffix(), weight, getColorValue());
    }

    private String getColorValue() {
        if (color == null) {
            return "неизвестный";
        }
        return color.getValue();
    }

    private String getAgeSuffix() {
        int remainder10 = age % 10;
        int remainder100 = age % 100;
        if (remainder10 == remainder100 && remainder100 != 11) {
            return "год";
        }
        if (remainder10 >= 2 && remainder10 <= 4 && remainder100 != 12 && remainder100 != 13 && remainder100 != 14) {
           return "года";
        }
        return "лет";
    }


}
