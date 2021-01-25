package andrei.teplyh.service.impl;

import andrei.teplyh.dto.ProductDTO;
import andrei.teplyh.entity.Product;
import andrei.teplyh.entity.User;
import andrei.teplyh.repository.ProductRepository;
import andrei.teplyh.service.ProductService;
import andrei.teplyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final UserService userService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(
            UserService userService,
            ProductRepository productRepository
    ) {
        this.userService = userService;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> loadProductsByUsername(String username) {
        User user = userService.findUserByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s not found.", username));
        }

        List<Product> products = user.getProducts();

        if (products.size() == 0) {
            throw new NullPointerException(String.format("User %s has no products yet.", username));
        }

        return products.stream()
                .map(
                        product -> new ProductDTO(
                                product.getDescription(),
                                product.getAuthorName(),
                                product.getProductName(),
                                product.getProductId(),
                                product.getPosterPath()
                        )
                ).collect(Collectors.toList());
    }

    @Override
    public int createProduct(ProductDTO productDTO, int userId) {
        int productId = productRepository.createProduct(
                productDTO.getPosterPath(),
                productDTO.getDescription(),
                productDTO.getProductName(),
                productDTO.getAuthorName()
        );

        productRepository.associateProductAndUser(productId, userId);

        return productId;
    }
}
