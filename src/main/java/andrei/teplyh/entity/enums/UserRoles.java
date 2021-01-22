package andrei.teplyh.entity.enums;

public enum UserRoles {
    ART_DIRECTOR("ROLE_ART_DIRECTOR") {
        @Override
        public String toString() {
            return "ART_DIRECTOR";
        }
    },
    ARTIST("ROLE_ARTIST"){
        @Override
        public String toString() {
            return "ARTIST";
        }
    },
    AUDIO_SPECIALIST("ROLE_AUDIO_SPECIALIST"){
        @Override
        public String toString() {
            return "AUDIO_SPECIALIST";
        }
    },
    DIGITIZER("ROLE_DIGITIZER"){
        @Override
        public String toString() {
            return "DIGITIZER";
        }
    },
    EDITOR("ROLE_EDITOR"){
        @Override
        public String toString() {
            return "EDITOR";
        }
    },
    PRODUCER("ROLE_PRODUCER"){
        @Override
        public String toString() {
            return "PRODUCER";
        }
    },
    RECORDING_ACTOR("ROLE_RECORDING_ACTOR"){
        @Override
        public String toString() {
            return "RECORDING_ACTOR";
        }
    },
    REGISSEUR("ROLE_REGISSEUR"){
        @Override
        public String toString() {
            return "REGISSEUR";
        }
    },
    ROLES_DESIGNER("ROLE_ROLES_DESIGNER"){
        @Override
        public String toString() {
            return "ROLES_DESIGNER";
        }
    },
    SCREENWRITER("ROLE_SCREENWRITER"){
        @Override
        public String toString() {
            return "SCREENWRITER";
        }
    },
    SMOOTHING_SPECIALIST("ROLE_SMOOTHING_SPECIALIST"){
        @Override
        public String toString() {
            return "SMOOTHING_SPECIALIST";
        }
    },
    STORYBOARD_ARTIST("ROLE_STORYBOARD_ARTIST"){
        @Override
        public String toString() {
            return "STORYBOARD_ARTIST";
        }
    };

    private String description;

    UserRoles(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
