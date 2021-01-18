package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.workers.Artist;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "animation_process")
public class AnimationProcess extends Process {
    @Column(name = "PROCESS_ID")
    private int processId;

    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @Column(name = "FRAME_RATE")
    private int frameRate;

    @Column(name = "ANIMATION_TECHNOLOGY")
    private String animationTechnology;

    @ManyToMany
    @JoinTable(
            name = "artist_animation_process",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID")
    )
    private List<Artist> workers = new ArrayList<>();

    public int getProcessId() {
        return processId;
    }
    public void setProcessId(int processId) {
        this.processId = processId;
    }

    @Override
    public int getMainProcessId() {
        return mainProcessId;
    }
    @Override
    public void setMainProcessId(int mainProcessId) {
        this.mainProcessId = mainProcessId;
    }

    public int getFrameRate() {
        return frameRate;
    }
    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }

    public String getAnimationTechnology() {
        return animationTechnology;
    }
    public void setAnimationTechnology(String animationTechnology) {
        this.animationTechnology = animationTechnology;
    }

    public List<Artist> getWorkers() {
        return workers;
    }
    public void setWorkers(List<Artist> workers) {
        this.workers = workers;
    }
}
