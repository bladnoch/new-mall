package senior.new_mall.dto.product;

import lombok.Getter;

@Getter
public class ProductCreateRequest {
    private String name;
    private String description;
    private Long price;

    public ProductCreateRequest(String name, String description, Long price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
