package otus.task.animal;

import otus.task.Command;

import java.util.ArrayList;
import java.util.List;

public enum Color {

    UNDEFINED("неизвестный"),
    WHITE("Белый"),
    BLACK("Черный");

    public static List<String> COLORS = collectNames();

    private String value;
    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private static List<String> collectNames() {
        List<String> result = new ArrayList<>();
        for (Color color : Color.values()) {
            result.add(color.name());
        }
        return result;
    }
}
