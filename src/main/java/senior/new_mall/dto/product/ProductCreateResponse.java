package senior.new_mall.dto.product;

import lombok.Getter;

@Getter
public class ProductCreateResponse {

    private Long id;
    private String name;
    private String description;
    private Long price;

    public ProductCreateResponse(Long id, String name, String description, Long price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
