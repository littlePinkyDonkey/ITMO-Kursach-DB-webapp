package andrei.teplyh.service.impl;

import andrei.teplyh.dto.ProductDTO;
import andrei.teplyh.entity.Product;
import andrei.teplyh.entity.User;
import andrei.teplyh.service.ProductService;
import andrei.teplyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final UserService userService;

    @Autowired
    public ProductServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<ProductDTO> loadProductsByUsername(String username) {
        User user = userService.findUserByLogin(username);
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
                                product.getProductId()
                        )
                ).collect(Collectors.toList());
    }
}
