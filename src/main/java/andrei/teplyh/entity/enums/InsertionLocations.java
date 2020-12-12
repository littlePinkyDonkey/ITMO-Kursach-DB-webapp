package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum InsertionLocations {
    THE_BEGINNING("the beginning"),
    THE_MIDDLE("the middle"),
    THE_END("the end");

    private String description;

    InsertionLocations(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static InsertionLocations of(String value) {
        return Stream.of(InsertionLocations.values())
                .filter(location -> location.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
