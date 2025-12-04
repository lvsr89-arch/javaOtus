package otus.task.animal;

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
}
