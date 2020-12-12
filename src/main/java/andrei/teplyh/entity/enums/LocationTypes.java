package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum LocationTypes {
    FIELD("field"),
    FOREST("forest"),
    CITY("city"),
    VILLAGE("village"),
    JUNGLE("jungle"),
    LAKE("lake"),
    MOUNTAINS("lake"),
    DESERT("desert"),
    CAVE("cave"),
    WATERFALL("waterfall"),
    CASTLE("castle");

    private String description;

    LocationTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static LocationTypes of(String value) {
        return Stream.of(LocationTypes.values())
                .filter(type -> type.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
