package andrei.teplyh.service.impl;

import andrei.teplyh.entity.enums.UserRoles;
import andrei.teplyh.repository.workers.*;
import andrei.teplyh.service.WorkerDeterminationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public void determinateWorker(List<String> roles) {
        for (String role : roles) {
            
        }
    }
}
