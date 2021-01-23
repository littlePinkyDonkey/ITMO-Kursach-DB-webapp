package andrei.teplyh.entity.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum UserRoles {
    ART_DIRECTOR("ROLE_ART_DIRECTOR") {
        @Override
        public String toString() {
            return "ART_DIRECTOR";
        }

        @Override
        public List<String> getAvailableProcesses() {
            return Arrays.asList(
                    "REVISION_PROCESS",
                    "REVISION_STORYBOARDING",
                    "REVISION_ADDING_SOUND",
                    "REVISION_SMOOTHING",
                    "REVISION_ADDING_EFFECTS",
                    "REVISION_ANIMATION",
                    "REVISION_COLORING"
            );
        }
    },
    ARTIST("ROLE_ARTIST"){
        @Override
        public String toString() {
            return "ARTIST";
        }

        @Override
        public List<String> getAvailableProcesses() {
            return Arrays.asList(
                    "CHARACTER_DRAWING_PROCESS",
                    "BATTLE_DRAWING_PROCESS",
                    "LOCATION_DRAWING_PROCESS",
                    "ADDING_EFFECT_PROCESS",
                    "ANIMATION_PROCESS",
                    "COLORING_PROCESS"
            );
        }
    },
    AUDIO_SPECIALIST("ROLE_AUDIO_SPECIALIST"){
        @Override
        public String toString() {
            return "AUDIO_SPECIALIST";
        }

        @Override
        public List<String> getAvailableProcesses() {
            return Collections.singletonList(
                    "ADDING_SOUND_PROCESS"
            );
        }
    },
    DIGITIZER("ROLE_DIGITIZER"){
        @Override
        public String toString() {
            return "DIGITIZER";
        }

        @Override
        public List<String> getAvailableProcesses() {
            return Collections.singletonList("DIGITIZATION_PROCESS");
        }
    },
    EDITOR("ROLE_EDITOR"){
        @Override
        public String toString() {
            return "EDITOR";
        }

        @Override
        public List<String> getAvailableProcesses() {
            return Collections.singletonList("CHARACTER_SELECT_PROCESS");
        }
    },
    PRODUCER("ROLE_PRODUCER"){
        @Override
        public String toString() {
            return "PRODUCER";
        }

        @Override
        public List<String> getAvailableProcesses() {
            return Collections.singletonList("ADVERTISING_PROCESS");
        }
    },
    RECORDING_ACTOR("ROLE_RECORDING_ACTOR"){
        @Override
        public String toString() {
            return "RECORDING_ACTOR";
        }

        @Override
        public List<String> getAvailableProcesses() {
            return Collections.singletonList("VOICE_ACTING_PROCESS");
        }
    },
    REGISSEUR("ROLE_REGISSEUR"){
        @Override
        public String toString() {
            return "REGISSEUR";
        }

        @Override
        public List<String> getAvailableProcesses() {
            return Arrays.asList(
                    "LOCATION_DESCRIPTION_PROCESS",
                    "PLOT_PROCESS"
            );
        }
    },
    ROLES_DESIGNER("ROLE_ROLES_DESIGNER"){
        @Override
        public String toString() {
            return "ROLES_DESIGNER";
        }

        @Override
        public List<String> getAvailableProcesses() {
            return Arrays.asList(
                    "CHARACTER_DESCRIPTION_PROCESS",
                    "ABILITY_DESCRIPTION_PROCESS"
            );
        }
    },
    SCREENWRITER("ROLE_SCREENWRITER"){
        @Override
        public String toString() {
            return "SCREENWRITER";
        }

        @Override
        public List<String> getAvailableProcesses() {
            return Arrays.asList(
                    "PLOT_PROCESS",
                    "BATTLE_DESCRIPTION_PROCESS"
            );
        }
    },
    SMOOTHING_SPECIALIST("ROLE_SMOOTHING_SPECIALIST"){
        @Override
        public String toString() {
            return "SMOOTHING_SPECIALIST";
        }

        @Override
        public List<String> getAvailableProcesses() {
            return Collections.singletonList("SMOOTHING_PROCESS");
        }
    },
    STORYBOARD_ARTIST("ROLE_STORYBOARD_ARTIST"){
        @Override
        public String toString() {
            return "STORYBOARD_ARTIST";
        }

        @Override
        public List<String> getAvailableProcesses() {
            return Collections.singletonList("STORYBOARD_PROCESS");
        }
    };

    private String description;
    private List<String> availableProcesses;

    UserRoles(String description) {
        this.description = description;
        this.availableProcesses = availableProcesses;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getAvailableProcesses() {
        return availableProcesses;
    }

    public static List<String> getAllRoles() {
        return Stream.of(UserRoles.values())
                .map(UserRoles::getDescription)
                .collect(Collectors.toList());
    }

    public static UserRoles of(String value) {
        return Stream.of(UserRoles.values())
                .filter(type -> type.getDescription().equals(value))
                .findFirst()
                .orElse(null);
    }
}
