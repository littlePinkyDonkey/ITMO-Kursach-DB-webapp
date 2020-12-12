package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum ProcessStatuses {
    STARTED("started"),
    IN_PROCESS("in process"),
    REVISION("revision"),
    FINISHED("finished");

    private String description;

    ProcessStatuses(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ProcessStatuses of(String value) {
        return Stream.of(ProcessStatuses.values())
                .filter(status -> status.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
