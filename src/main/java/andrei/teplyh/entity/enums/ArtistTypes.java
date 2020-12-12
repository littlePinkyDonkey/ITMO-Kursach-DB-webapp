package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum ArtistTypes {
    CHARACTER_ARTIST("character artist"),
    BATTLE_ARTIST("battle artist"),
    LOCATION_ARTIST("location artist"),
    BACKGROUND_ARTIST("background artist"),
    EFFECT_ARTIST("effect artist"),
    ANIMATION_ARTIST("animation artist"),
    COLORING_ARTIST("coloring artist");

    private String description;

    ArtistTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ArtistTypes of(String value) {
        return Stream.of(ArtistTypes.values())
                .filter(type -> type.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
