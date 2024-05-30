package senior.new_mall.controller.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import senior.new_mall.dto.product.ProductCreateRequest;
import senior.new_mall.dto.product.ProductCreateResponse;
import senior.new_mall.service.product.ProductService;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/api/products")
    public ProductCreateResponse registerProduct(@RequestBody ProductCreateRequest request) {
        return productService.registerProduct(request);
    }
}
