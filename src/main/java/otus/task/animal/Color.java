package otus.task.animal;

import otus.task.factory.AnimalType;

import java.util.ArrayList;
import java.util.List;

public enum Color {

    UNDEFINED("неизвестный"),
    WHITE("Белый"),
    BLACK("Черный");

    private String value;
    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<String> COLORS = collectTypes();

    public static List<String> collectTypes() {
        List<String> result = new ArrayList<>();
        for (Color collectTypes : Color.values()) {
            result.add(collectTypes.name());
        }
        return result;
    }

    public static boolean doesNotContain(String value){
        if (value == null) {
            return true;
        }
        return !COLORS.contains(value.toUpperCase().trim());
    }
}
