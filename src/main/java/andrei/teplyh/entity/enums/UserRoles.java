package andrei.teplyh.entity.enums;

public enum UserRoles {
    ART_DIRECTOR("ART_DIRECTOR"),
    ARTIST("ARTIST"),
    AUDIO_SPECIALIST("AUDIO_SPECIALIST"),
    DIGITIZER("DIGITIZER"),
    EDITOR("EDITOR"),
    PRODUCER("PRODUCER"),
    RECORDING_ACTOR("RECORDING_ACTOR"),
    REGISSEUR("REGISSEUR"),
    ROLES_DESIGNER("ROLES_DESIGNER"),
    SCREENWRITER("SCREENWRITER"),
    SMOOTHING_SPECIALIST("SMOOTHING_SPECIALIST"),
    STORYBOARD_ARTIST("STORYBOARD_ARTIST");

    private String description;

    UserRoles(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
