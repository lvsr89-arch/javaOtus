package otus.task;

import otus.task.birds.Duck;
import otus.task.factory.AnimalFactory;
import otus.task.factory.AnimalType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalApp {

    private static AnimalFactory animalFactory;

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        AnimalFactory animalFactory = new AnimalFactory();

        Scanner scanner = new Scanner(System.in);
        Command currentCommand = null;

        while (currentCommand != Command.EXIT) {
            currentCommand = getCommand(scanner);
            if (currentCommand == Command.LIST) {
                if (animals.isEmpty()) {
                    System.out.println("Список пуст");
                }
                for (Animal animal : animals) {
                    System.out.println(animal);
                }
            } else if (currentCommand == Command.ADD) {
                AnimalType animalType = null;
                Animal animal = animalFactory.create(animalType);


                //запросить параметры животного

                System.out.println("Введите имя животного");
                System.out.println("Введите возраст");
                System.out.println("Введите вес");
                System.out.println("Введите цвет");
                animals.add(animal);
//                animal.say();
            }
        }
    }

    private static Command getCommand(Scanner scanner) {
        String commandInput = null;
        while (Command.doesNotContain(commandInput)) {
            if (commandInput != null) {
                System.out.println("Введена неверная команда");
            }
            System.out.printf("Введите одну из команд (%s) :", String.join("/", Command.NAMES));
            commandInput = scanner.nextLine();

        }
        return Command.fromString(commandInput);
    }
}
