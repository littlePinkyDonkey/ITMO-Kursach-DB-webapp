package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum SoundTypes {
    MUSIC("music"),
    NOISES("noises");

    private String description;

    SoundTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static SoundTypes of(String value) {
        return Stream.of(SoundTypes.values())
                .filter(type -> type.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
