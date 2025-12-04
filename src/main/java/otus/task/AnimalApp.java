package otus.task;

import otus.task.animal.Color;
import otus.task.factory.AnimalFactory;
import otus.task.factory.AnimalType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalApp {

    private static AnimalFactory animalFactory;

    static void main() {
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
                AnimalType animalType =  getAnimalType(scanner);
                Animal animal = animalFactory.create(animalType);
                //запросить параметры животного

                System.out.println("Введите имя животного");
                animal.setName(scanner.next());
                System.out.println("Введите возраст");
//                animal.setAge(Integer.parseInt(scanner.next()));
                String ageInput = scanner.next();

                    try {
                        animal.setAge(Integer.parseInt(ageInput));
                    } catch (NumberFormatException e) {
                        System.out.println("Не корректное число");
                        animal.setAge(Integer.parseInt(ageInput));
                    }

                System.out.println("Введите вес");
                String weightInput = scanner.next();

                    try {
                        animal.setWeight(Integer.parseInt(weightInput));
                    } catch (NumberFormatException e) {
                        System.out.println("Не корректное число");
                        animal.setWeight(Integer.parseInt(weightInput));
                    }

                System.out.println("Введите цвет");
                String colorInput = scanner.next();

                    try {
                        animal.setColor(Color.valueOf(colorInput.toUpperCase().trim()));
                    } catch (IllegalArgumentException e) {
                        animal.setColor(Color.UNDEFINED);
                    }

                animals.add(animal);
                animal.say();
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

    private static AnimalType getAnimalType(Scanner scanner) {
        String animalTypeInput = null;
        while (AnimalType.doesNotContain(animalTypeInput)) {
            if (animalTypeInput != null) {
                System.out.println("Неверный тип животного");
            }
            System.out.printf("Выберете тип животного (%s) :", String.join("/", AnimalType.TYPES));
            animalTypeInput = scanner.nextLine();
        }
        return AnimalType.fromString(animalTypeInput);
    }
}
