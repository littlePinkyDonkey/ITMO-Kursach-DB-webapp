package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum EditorPositions {
    LITERATURE_EDITOR("literature editor"),
    TECHNICAL_EDITOR("technical editor"),
    ART_DIRECTOR("art editor"),
    MAIN_EDITOR("main editor");

    private String description;

    EditorPositions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static EditorPositions of(String value) {
        return Stream.of(EditorPositions.values())
                .filter(position -> position.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
