package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum RecordingActorsPositions {
    MAIN("main"),
    SECOND_ROLE("second_role");

    private String description;

    RecordingActorsPositions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static RecordingActorsPositions of(String value) {
        return Stream.of(RecordingActorsPositions.values())
                .filter(position -> position.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
