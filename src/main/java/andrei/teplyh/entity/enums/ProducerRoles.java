package andrei.teplyh.entity.enums;

import java.util.stream.Stream;

public enum ProducerRoles {
    PRODUCER("producer"),
    EXECUTIVE_PRODUCER("executive producer"),
    CO_PRODUCER("co-producer"),
    ASSOCIATE_PRODUCER("associate producer");

    private String description;

    ProducerRoles(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ProducerRoles of(String value) {
        return Stream.of(ProducerRoles.values())
                .filter(role -> role.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
