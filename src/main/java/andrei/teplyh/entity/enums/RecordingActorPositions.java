package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum RecordingActorPositions {
    DUBBING("dubbing"),
    VOICE_ACTING_ROLES("voice acting roles"),
    MUSIC_RECORDING("music recording");

    private String description;

    RecordingActorPositions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static RecordingActorPositions of(String value) {
        return Stream.of(RecordingActorPositions.values())
                .filter(position -> position.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
