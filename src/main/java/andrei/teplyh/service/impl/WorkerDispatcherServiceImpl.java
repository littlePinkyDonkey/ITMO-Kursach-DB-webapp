package andrei.teplyh.service.impl;

import andrei.teplyh.entity.enums.*;
import andrei.teplyh.repository.workers.*;
import andrei.teplyh.service.WorkerDispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkerDispatcherServiceImpl implements WorkerDispatcherService {
    private final ApplicationContext applicationContext;

    @Autowired
    public WorkerDispatcherServiceImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void dispatch(List<String> roles, int mainWorkerId) {
        for (String role : roles) {
            if (role.equals("ROLE_ART_DIRECTOR")) {
                ArtDirectorRepository artDirectorRepository
                        = applicationContext.getBean("artDirectorRepository", ArtDirectorRepository.class);
                artDirectorRepository.addExistingArtDirector(mainWorkerId);
            } else if (role.equals("ROLE_ARTIST")) {
                ArtistsRepository artistsRepository
                        = applicationContext.getBean("artistsRepository", ArtistsRepository.class);
                artistsRepository.addExistingArtist(mainWorkerId, ArtistTypes.CHARACTER_ARTIST.getDescription(), UsingTechnologies.DRAWING.getDescription());
            } else if (role.equals("ROLE_AUDIO_SPECIALIST")) {
                AudioSpecialistRepository audioSpecialistRepository
                        = applicationContext.getBean("audioSpecialistRepository", AudioSpecialistRepository.class);
                audioSpecialistRepository.addExistingAudioSpecialist(mainWorkerId);
            } else if (role.equals("ROLE_DIGITIZER")) {
                DigitizerRepository digitizerRepository
                        = applicationContext.getBean("digitizerRepository", DigitizerRepository.class);
                digitizerRepository.addExistingDigitizer(mainWorkerId);
            } else if (role.equals("ROLE_EDITOR")) {
                EditorRepository editorRepository
                        = applicationContext.getBean("editorRepository", EditorRepository.class);
                editorRepository.addExistingEditor(mainWorkerId, EditorPositions.MAIN_EDITOR.getDescription());
            } else if (role.equals("ROLE_PRODUCER")) {
                ProducerRepository producerRepository
                        = applicationContext.getBean("producerRepository", ProducerRepository.class);
                producerRepository.addExistingProducer(mainWorkerId, ProducerRoles.EXECUTIVE_PRODUCER.getDescription());
            } else if (role.equals("ROLE_RECORDING_ACTOR")) {
                RecordingActorRepository recordingActorRepository
                        = applicationContext.getBean("recordingActorRepository", RecordingActorRepository.class);
                recordingActorRepository.addExistingRecordingActor(mainWorkerId, RecordingActorsPositions.SECOND_ROLE.getDescription());
            } else if (role.equals("ROLE_REGISSEUR")) {
                RegisseurRepository regisseurRepository
                        = applicationContext.getBean("regisseurRepository", RegisseurRepository.class);
                regisseurRepository.addExistingRegisseur(mainWorkerId, 0);
            } else if (role.equals("ROLE_ROLES_DESIGNER")) {
                RolesDesignerRepository rolesDesignerRepository
                        = applicationContext.getBean("rolesDesignerRepository", RolesDesignerRepository.class);
                rolesDesignerRepository.addExistingRolesDesigner(mainWorkerId);
            } else if (role.equals("ROLE_SCREENWRITER")) {
                ScreenwriterRepository screenwriterRepository
                        = applicationContext.getBean("screenwriterRepository", ScreenwriterRepository.class);
                screenwriterRepository.addExistingScreenwriter(mainWorkerId, 0);
            } else if (role.equals("ROLE_SMOOTHING_SPECIALIST")) {
                SmoothingSpecialistRepository smoothingSpecialistRepository
                        = applicationContext.getBean("smoothingSpecialistRepository", SmoothingSpecialistRepository.class);
                smoothingSpecialistRepository.addExistingSmoothingSpecialist(mainWorkerId);
            } else if (role.equals("ROLE_STORYBOARD_ARTIST")) {
                StoryboardArtistRepository storyboardArtistRepository
                        = applicationContext.getBean("storyboardArtistRepository", StoryboardArtistRepository.class);
                storyboardArtistRepository.addExistingStoryboardArtist(mainWorkerId);
            }
        }
    }
}
