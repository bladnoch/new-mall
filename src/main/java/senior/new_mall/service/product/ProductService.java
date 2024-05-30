package senior.new_mall.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import senior.new_mall.domain.product.Product;
import senior.new_mall.domain.product.ProductRepository;
import senior.new_mall.dto.product.ProductCreateRequest;
import senior.new_mall.dto.product.ProductCreateResponse;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductCreateResponse registerProduct(ProductCreateRequest request) {
        // id, name, description, price
        if ((request.getName().isEmpty()) || request.getPrice()==null) {
            throw new IllegalArgumentException("이름과 가격을 입력해주세요");
        }

        productRepository.save(new Product(request.getName(), request.getDescription(), request.getPrice()));
        Product currentProduct= productRepository.findByNameAndDescriptionAndPrice(request.getName(), request.getDescription(), request.getPrice())
                .orElseThrow(IllegalArgumentException::new);
        return new ProductCreateResponse(currentProduct.getId(), request.getName(), request.getDescription(), request.getPrice());
    }

}
