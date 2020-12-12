package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum RevisionTypes {
    FULL_REVISION("full revision"),
    PART_REVISION("part revision");

    private String description;

    RevisionTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static RevisionTypes of(String value) {
        return Stream.of(RevisionTypes.values())
                .filter(type -> type.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
