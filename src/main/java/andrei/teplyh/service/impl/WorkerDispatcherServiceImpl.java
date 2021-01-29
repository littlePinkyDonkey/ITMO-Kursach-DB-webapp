package andrei.teplyh.service.impl;

import andrei.teplyh.entity.enums.*;
import andrei.teplyh.repository.workers.*;
import andrei.teplyh.service.WorkerDispatcherService;
import andrei.teplyh.service.workers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WorkerDispatcherServiceImpl implements WorkerDispatcherService {
    private final ApplicationContext applicationContext;

    @Autowired
    public WorkerDispatcherServiceImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void dispatch(String role, int mainWorkerId) {
        if (role.equals("ROLE_ART_DIRECTOR")) {
            ArtDirectorService artDirectorService
                    = applicationContext.getBean("artDirectorServiceImpl", ArtDirectorService.class);
            artDirectorService.addExistingArtDirector(mainWorkerId);
        } else if (role.equals("ROLE_ARTIST")) {
            ArtistsService artistsService
                    = applicationContext.getBean("artistsServiceImpl", ArtistsService.class);
            artistsService.addExistingArtist(mainWorkerId, ArtistTypes.CHARACTER_ARTIST.getDescription(), UsingTechnologies.DRAWING.getDescription());
        } else if (role.equals("ROLE_AUDIO_SPECIALIST")) {
            AudioSpecialistService audioSpecialistService
                    = applicationContext.getBean("audioSpecialistServiceImpl", AudioSpecialistService.class);
            audioSpecialistService.addExistingAudioSpecialist(mainWorkerId);
        } else if (role.equals("ROLE_DIGITIZER")) {
            DigitizerService digitizerService
                    = applicationContext.getBean("digitizerServiceImpl", DigitizerService.class);
            digitizerService.addExistingDigitizer(mainWorkerId);
        } else if (role.equals("ROLE_EDITOR")) {
            EditorService editorService
                    = applicationContext.getBean("editorServiceImpl", EditorService.class);
            editorService.addExistingEditor(mainWorkerId, EditorPositions.MAIN_EDITOR.getDescription());
        } else if (role.equals("ROLE_PRODUCER")) {
            ProducerService producerService
                    = applicationContext.getBean("producerServiceImpl", ProducerService.class);
            producerService.addExistingProducer(mainWorkerId, ProducerRoles.EXECUTIVE_PRODUCER.getDescription());
        } else if (role.equals("ROLE_RECORDING_ACTOR")) {
            RecordingActorService recordingActorService
                    = applicationContext.getBean("recordingActorServiceImpl", RecordingActorService.class);
            recordingActorService.addExistingRecordingActor(mainWorkerId, RecordingActorsPositions.SECOND_ROLE.getDescription());
        } else if (role.equals("ROLE_REGISSEUR")) {
            RegisseurService regisseurService
                    = applicationContext.getBean("regisseurServiceImpl", RegisseurService.class);
            regisseurService.addExistingRegisseur(mainWorkerId, 0);
        } else if (role.equals("ROLE_ROLES_DESIGNER")) {
            RolesDesignerService rolesDesignerService
                    = applicationContext.getBean("rolesDesignerServiceImpl", RolesDesignerService.class);
            rolesDesignerService.addExistingRolesDesigner(mainWorkerId);
        } else if (role.equals("ROLE_SCREENWRITER")) {
            ScreenwriterService screenwriterService
                    = applicationContext.getBean("screenwriterServiceImpl", ScreenwriterService.class);
            screenwriterService.addExistingScreenwriter(mainWorkerId, 0);
        } else if (role.equals("ROLE_SMOOTHING_SPECIALIST")) {
            SmoothingSpecialistService smoothingSpecialistService
                    = applicationContext.getBean("smoothingSpecialistServiceImpl", SmoothingSpecialistService.class);
            smoothingSpecialistService.addExistingSmoothingSpecialist(mainWorkerId);
        } else if (role.equals("ROLE_STORYBOARD_ARTIST")) {
            StoryboardArtistService storyboardArtistService
                    = applicationContext.getBean("storyboardArtistServiceImpl", StoryboardArtistService.class);
            storyboardArtistService.addExistingStoryboardArtist(mainWorkerId);
        }
    }
}
