package otus.task.birds;

import otus.task.Animal;

public class Duck extends Animal implements Flying {
    @Override
    public void fly() {

    }

    @Override
    public void say() {
        System.out.println("Кря");
    }
}
