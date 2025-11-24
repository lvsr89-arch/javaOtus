package otus.task;

import java.io.InputStream;

public class Main {
    static void main() {

        Dog Bobi = new Dog();
        Bobi.setName("Бобик");
//    Добавь проверку setAge чтобы не было отрицательным и не заваливалось больше инта
        Bobi.setAge(57322891);
        Bobi.setWeight(20);
        Bobi.setColor("Серый");

//        System.out.println(Bobi.toString());
//        System.out.println(Byte.MAX_VALUE);
        System.out.println("What do you want? \n1. Add\n2. List\n3. Exit ");


    }

}