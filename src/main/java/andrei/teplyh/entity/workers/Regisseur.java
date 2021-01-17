package andrei.teplyh.entity.workers;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "regisseurs")
public class Regisseur extends Worker{
    @Column(name = "WORKER_ID")
    private int workerId;

    @Column(name = "MAIN_WORKER_ID")
    private int mainWorkerId;

    @Column(name = "FILMS_NUMBER")
    private int filmsNumber;

    @Column(name = "GENRES")
    private String[] genres;

    public int getWorkerId() {
        return workerId;
    }
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    @Override
    public int getMainWorkerId() {
        return mainWorkerId;
    }
    @Override
    public void setMainWorkerId(int mainWorkerId) {
        this.mainWorkerId = mainWorkerId;
    }

    public int getFilmsNumber() {
        return filmsNumber;
    }
    public void setFilmsNumber(int filmsNumber) {
        this.filmsNumber = filmsNumber;
    }

    public String[] getGenres() {
        return genres;
    }
    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return String.format("%s || workerId = %d || main_worker_id = %d", super.toString(), workerId, mainWorkerId);
    }
}
