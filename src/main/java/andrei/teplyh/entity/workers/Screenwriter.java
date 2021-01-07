package andrei.teplyh.entity.workers;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "screenwriters")
public class Screenwriter extends Worker {
    @Column(name = "WORKER_ID")
    private long workerId;

    @Column(name = "MAIN_WORKER_ID")
    private long mainWorkerId;

    @Column(name = "FILMS_NUMBER")
    private int filmsNumber;

    @Column(name = "GENRES")
    private String[] genres;

    public Screenwriter() {
    }
    public Screenwriter(long workerId, long mainWorkerId, int filmsNumber, String[] genres) {
        this.workerId = workerId;
        this.mainWorkerId = mainWorkerId;
        this.filmsNumber = filmsNumber;
        this.genres = genres;
    }

    @Override
    public String toString() {
        return String.format("%s || workerId = %d || main_worker_id = %d", super.toString(), workerId, mainWorkerId);
    }
}
