package EComm.SW.entity;

import lombok.Getter;
import lombok.Setter;

public class OrderProductQuantity {
    @Getter
    @Setter

    private Long productId;
    private Integer quantity;

    public OrderProductQuantity() {
        super();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
