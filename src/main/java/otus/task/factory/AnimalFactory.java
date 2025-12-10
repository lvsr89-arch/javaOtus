package otus.task.factory;

import otus.task.Animal;
import otus.task.animal.Cat;
import otus.task.animal.Dog;
import otus.task.birds.Duck;

public class AnimalFactory {

    public Animal create(AnimalType type) {
        if (type == null) {
            return null;
        }
        if (type == AnimalType.CAT) {
            return new Cat();
        }
        if (type == AnimalType.DOG) {
            return new Dog();
        }
        if (type == AnimalType.DUCK) {
            return new Duck();
        }
        throw new IllegalArgumentException("Неожиданный тип животного: " + type);
//        else return null;
    }
}
