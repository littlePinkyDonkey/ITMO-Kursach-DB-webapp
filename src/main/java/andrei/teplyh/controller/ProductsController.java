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
public class ProductsController {
    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
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
}
