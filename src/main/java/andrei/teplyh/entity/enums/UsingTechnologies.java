package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum UsingTechnologies {
    DRAWING("drawings"),
    DOLLS("dolls"),
    THREE_D("3D");

    private String description;

    UsingTechnologies(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static UsingTechnologies of(String value) {
        return Stream.of(UsingTechnologies.values())
                .filter(technology -> technology.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
