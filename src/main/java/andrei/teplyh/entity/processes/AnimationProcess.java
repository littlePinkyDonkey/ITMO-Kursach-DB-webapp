package andrei.teplyh.entity.processes;

import javax.persistence.Column;
import javax.persistence.Entity;

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
}
