package andrei.teplyh.service.impl;

import andrei.teplyh.entity.enums.*;
import andrei.teplyh.entity.workers.RecordingActor;
import andrei.teplyh.repository.workers.*;
import andrei.teplyh.service.WorkerDeterminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkerDeterminationServiceImpl implements WorkerDeterminationService {
    private final ArtDirectorRepository artDirectorRepository;
    private final ArtistsRepository artistsRepository;
    private final AudioSpecialistRepository audioSpecialistRepository;
    private final DigitizerRepository digitizerRepository;
    private final EditorRepository editorRepository;
    private final ProducerRepository producerRepository;
    private final RecordingActorRepository recordingActorRepository;
    private final RegisseurRepository regisseurRepository;
    private final RolesDesignerRepository rolesDesignerRepository;
    private final ScreenwriterRepository screenwriterRepository;
    private final SmoothingSpecialistRepository smoothingSpecialistRepository;
    private final StoryboardArtistRepository storyboardArtistRepository;

    @Autowired
    public WorkerDeterminationServiceImpl(
            ArtDirectorRepository artDirectorRepository,
            ArtistsRepository artistsRepository,
            AudioSpecialistRepository audioSpecialistRepository,
            DigitizerRepository digitizerRepository,
            EditorRepository editorRepository,
            ProducerRepository producerRepository,
            RecordingActorRepository recordingActorRepository,
            RegisseurRepository regisseurRepository,
            RolesDesignerRepository rolesDesignerRepository,
            ScreenwriterRepository screenwriterRepository,
            SmoothingSpecialistRepository smoothingSpecialistRepository,
            StoryboardArtistRepository storyboardArtistRepository
    ) {
        this.artDirectorRepository = artDirectorRepository;
        this.artistsRepository = artistsRepository;
        this.audioSpecialistRepository = audioSpecialistRepository;
        this.digitizerRepository = digitizerRepository;
        this.editorRepository = editorRepository;
        this.producerRepository = producerRepository;
        this.recordingActorRepository = recordingActorRepository;
        this.regisseurRepository = regisseurRepository;
        this.rolesDesignerRepository = rolesDesignerRepository;
        this.screenwriterRepository = screenwriterRepository;
        this.smoothingSpecialistRepository = smoothingSpecialistRepository;
        this.storyboardArtistRepository = storyboardArtistRepository;
    }

    @Override
    public void addWorker(List<String> roles, int mainWorkerId) {
        for (String role : roles) {
            if (role.equals("ROLE_ART_DIRECTOR")) {
                artDirectorRepository.addExistingArtDirector(mainWorkerId);
            } else if (role.equals("ROLE_ARTIST")) {
                artistsRepository.addExistingArtist(mainWorkerId, ArtistTypes.CHARACTER_ARTIST.getDescription(), UsingTechnologies.DRAWING.getDescription());
            } else if (role.equals("ROLE_AUDIO_SPECIALIST")) {
                audioSpecialistRepository.addExistingAudioSpecialist(mainWorkerId);
            } else if (role.equals("ROLE_DIGITIZER")) {
                digitizerRepository.addExistingDigitizer(mainWorkerId);
            } else if (role.equals("ROLE_EDITOR")) {
                editorRepository.addExistingEditor(mainWorkerId, EditorPositions.MAIN_EDITOR.getDescription());
            } else if (role.equals("ROLE_PRODUCER")) {
                producerRepository.addExistingProducer(mainWorkerId, ProducerRoles.EXECUTIVE_PRODUCER.getDescription());
            } else if (role.equals("ROLE_RECORDING_ACTOR")) {
                recordingActorRepository.addExistingRecordingActor(mainWorkerId, RecordingActorsPositions.SECOND_ROLE.getDescription());
            } else if (role.equals("ROLE_REGISSEUR")) {
                regisseurRepository.addExistingRegisseur(mainWorkerId, 0);
            } else if (role.equals("ROLE_ROLES_DESIGNER")) {
                rolesDesignerRepository.addExistingRolesDesigner(mainWorkerId);
            } else if (role.equals("ROLE_SCREENWRITER")) {
                screenwriterRepository.addExistingScreenwriter(mainWorkerId, 0);
            } else if (role.equals("ROLE_SMOOTHING_SPECIALIST")) {
                smoothingSpecialistRepository.addExistingSmoothingSpecialist(mainWorkerId);
            } else if (role.equals("ROLE_STORYBOARD_ARTIST")) {
                storyboardArtistRepository.addExistingStoryboardArtist(mainWorkerId);
            }
        }
    }
}
