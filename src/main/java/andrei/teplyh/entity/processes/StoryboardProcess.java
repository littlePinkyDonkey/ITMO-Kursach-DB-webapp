package andrei.teplyh.entity.processes;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "storyboard_process")
public class StoryboardProcess extends Process {
    @Column(name = "PROCESS_ID")
    private int processId;

    @Column(name = "MAIN_PROCESS_ID")
    private int mainProcessId;

    @Column(name = "FRAME_NUMBER")
    private int frameNumber;

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

    @Override
    public String toString() {
        return "StoryboardProcess{" +
                "processId=" + processId +
                ", mainProcessId=" + mainProcessId +
                ", frameNumber=" + frameNumber +
                '}';
    }
}
