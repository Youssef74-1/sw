package EComm.SW.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class OrderInput {
    @Getter
    @Setter
    private String fullName;

    @Getter
    @Setter
    private String fullAddress;

    @Getter
    @Setter
    private String contactNumber;

    @Getter
    @Setter
    private String alternateContactNumber;

    @Getter
    @Setter
    private List<OrderProductQuantity> orderProductQuantityList;

    public static class OrderProductQuantity {
        private Long productId;
        private int quantity;

        // Getters and setters
        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
