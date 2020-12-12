package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum EffectLevels {
    AAA("AAA"),
    AA("AA"),
    A("A"),
    BBB("BBB"),
    BB("BB"),
    B("B"),
    CCC("CCC"),
    CC("CC"),
    C("C");

    private String description;

    EffectLevels(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static EffectLevels of(String value) {
        return Stream.of(EffectLevels.values())
                .filter(level -> level.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
