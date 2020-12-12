package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum ColoringTypes {
    COLORED("colored"),
    BLACK_WHITE("black-white");

    private String description;

    ColoringTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ColoringTypes of(String value) {
        return Stream.of(ColoringTypes.values())
                .filter(type -> type.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
