package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum DigitizationTypes {
    ADDING_CONTRAST_THEN_SCANNING("adding contrast, then scanning"),
    SCANNING_THEN_ADDING_CONTRAST("scanning, then adding contrast");

    private String description;

    DigitizationTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static DigitizationTypes of(String value) {
        return Stream.of(DigitizationTypes.values())
                .filter(type -> type.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
