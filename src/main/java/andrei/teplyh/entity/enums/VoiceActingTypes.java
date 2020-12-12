package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum VoiceActingTypes {
    PRELIMINARY("preliminary"),
    FOLLOW_UP("follow-up");

    private String description;

    VoiceActingTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static VoiceActingTypes of(String value) {
        return Stream.of(VoiceActingTypes.values())
                .filter(type -> type.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
