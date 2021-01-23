package andrei.teplyh.service;

import andrei.teplyh.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> loadProductsByUsername(String username);
}
