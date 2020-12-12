package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum PlotTypes {
    MAIN("main"),
    ADDITIONAL("additional"),
    SPIN_OFF("spin-off");

    private String description;

    PlotTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static PlotTypes of(String value) {
        return Stream.of(PlotTypes.values())
                .filter(type -> type.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
