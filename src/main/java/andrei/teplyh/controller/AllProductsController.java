package andrei.teplyh.controller;

import andrei.teplyh.dto.ProductDTO;
import andrei.teplyh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class AllProductsController {
    private final ProductService productService;

    @Autowired
    public AllProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity getAllProducts(@RequestAttribute(name = "login") String login) {
        try {
            List<ProductDTO> response = productService.loadProductsByUsername(login);

            return ResponseEntity.ok().body(response);
        } catch (NullPointerException | UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping(path = "/create_product")
    public ResponseEntity createProduct(@RequestAttribute(name = "userId") int userId,
                                        @RequestBody ProductDTO productDTO) {
        int productId = productService.createProduct(productDTO, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(productId);
    }
}
