package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum ArtifactTypes {
    IMAGE("image"),
    VIDEO("video"),
    TEXT("text"),
    MUSIC("music"),
    SOUNDS("sounds");

    private String description;

    ArtifactTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ArtifactTypes of(String value) {
        return Stream.of(ArtifactTypes.values())
                .filter(type -> type.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
