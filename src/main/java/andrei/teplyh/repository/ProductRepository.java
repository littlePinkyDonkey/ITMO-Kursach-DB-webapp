package andrei.teplyh.repository;

import andrei.teplyh.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Procedure("create_product")
    int createProduct(String posterPath, String description, String productName, String authorName);

    @Procedure("associate_product_and_user")
    boolean associateProductAndUser(int productId, int userId);

    void  deleteProductByProductName(String productName);

    void deleteProductByProductId(int productId);
}
