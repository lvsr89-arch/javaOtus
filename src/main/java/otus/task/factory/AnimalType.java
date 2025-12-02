package otus.task.factory;
import java.util.ArrayList;
import java.util.List;

public enum AnimalType {
    DOG,
    DUCK,
    CAT;

    public static List<String> TYPES = collectTypes();

    public static List<String> collectTypes() {
        List<String> result = new ArrayList<>();
        for (AnimalType collectTypes : AnimalType.values()) {
            result.add(collectTypes.name());
        }
        return result;
    }

    public static boolean doesNotContain(String value){
        if (value == null) {
            return true;
        }
        return !TYPES.contains(value.toUpperCase().trim());
    }

    public static AnimalType fromString(String value){
        if (value == null) {
            return null;
        }
        return AnimalType.valueOf(value.toUpperCase().trim());
    }

}
