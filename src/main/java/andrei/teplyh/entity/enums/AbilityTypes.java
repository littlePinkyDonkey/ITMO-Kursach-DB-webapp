package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum AbilityTypes {
    ATTACK("attack"),
    DEFENCE("defence"),
    HEAL("heal"),
    CHATTING("chatting");

    private String description;

    AbilityTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static AbilityTypes of(String value) {
        return Stream.of(AbilityTypes.values())
                .filter(type -> type.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
