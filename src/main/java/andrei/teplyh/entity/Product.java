package andrei.teplyh.entity;

import andrei.teplyh.entity.processes.Process;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "products")
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    private int productId;

    @Column(name = "POSTER_PATH")
    private String posterPath;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "AUTHOR_NAME")
    private String authorName;

    @ManyToMany
    @JoinTable(
            name = "users_products",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID")
    )
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<Process> processes = new ArrayList<>();

    public List<Process> getProcesses() {
        return processes;
    }
    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getPosterPath() {
        return posterPath;
    }
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
