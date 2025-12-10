package otus.task;

import otus.task.animal.Color;
import otus.task.factory.AnimalFactory;
import otus.task.factory.AnimalType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalApp {

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
                AnimalType animalType =  getAnimalType(scanner);
                Animal animal = animalFactory.create(animalType);
                //запросить параметры животного

                System.out.println("Введите имя животного");
                animal.setName(scanner.nextLine());

                System.out.println("Введите возраст");
                animal.setAge(checkNumber(scanner));

                System.out.println("Введите вес");
                animal.setWeight(checkNumber(scanner));

                System.out.println("Введите цвет");
                String colorInput = scanner.nextLine().toUpperCase().trim();

                if (!Color.COLORS.contains(colorInput)) {
                    animal.setColor(Color.UNDEFINED);
                    System.out.println("Не понял что ты ввёл, поставил неизвестный");
                } else {
                    animal.setColor(Color.valueOf(colorInput));
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

    private static int checkNumber(Scanner scanner) {
        while (true) {
            String weightInput = scanner.nextLine();
            if (!weightInput.matches("^\\d{1,9}?$")) {
                System.out.println("Попробуй ещё раз");
                continue;
            }
            return Integer.parseInt(weightInput);
        }
    }
}
