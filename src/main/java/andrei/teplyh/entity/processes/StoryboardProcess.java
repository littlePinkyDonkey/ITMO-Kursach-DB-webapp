package andrei.teplyh.entity.processes;

import andrei.teplyh.entity.workers.StoryboardArtist;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "storyboard_process")
public class StoryboardProcess extends Process {
    @Column(name = "PROCESS_ID")
    private int processId;

    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @Column(name = "FRAME_NUMBER")
    private int frameNumber;

    @ManyToMany
    @JoinTable(
            name = "artist_storyboard_process",
            joinColumns = @JoinColumn(name = "PROCESS_ID"),
            inverseJoinColumns = @JoinColumn(name = "WORKER_ID")
    )
    private List<StoryboardArtist> artists = new ArrayList<>();

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

    public int getFrameNumber() {
        return frameNumber;
    }
    public void setFrameNumber(int frameNumber) {
        this.frameNumber = frameNumber;
    }

    public List<StoryboardArtist> getArtists() {
        return artists;
    }
    public void setArtists(List<StoryboardArtist> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "StoryboardProcess{" +
                "processId=" + processId +
                ", mainProcessId=" + mainProcessId +
                ", frameNumber=" + frameNumber +
                '}';
    }
}
