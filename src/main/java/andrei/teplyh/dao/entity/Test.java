package andrei.teplyh.dao.entity;

import javax.persistence.*;

@Table(name = "test")
public class Test {
    @Id
    private long id;

    @Column(name = "name")
    private String name;

    public Test() {

    }
    public  Test(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("name = %s", name);
    }
}
