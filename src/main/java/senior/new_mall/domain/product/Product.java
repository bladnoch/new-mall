package senior.new_mall.domain.product;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Product {

// id, name, description, price
public Product(String name, String description, Long price) {
    this.name = name;
    this.description = description;
    this.price = price;
}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Long price;
}
