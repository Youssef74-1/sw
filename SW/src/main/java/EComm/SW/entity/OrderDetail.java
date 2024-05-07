package EComm.SW.entity;

import jakarta.persistence.*;

@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    private String orderFullName;
    private String orderFullOrder;
    private String orderContactNumber;
    private String orderAlternateContactNumber;
    private String orderStatus;
    private Double orderAmount;

    @OneToOne
    private Product product;

    @OneToOne
    private User user;

    public OrderDetail() {
        super();
        // TODO Auto-generated constructor stub
    }



    public OrderDetail(String orderFullName, String orderFullOrder, String orderContactNumber,
                       String orderAlternateContactNumber, String orderStatus, Double orderAmount, Product product, User user) {
        super();
        this.orderFullName = orderFullName;
        this.orderFullOrder = orderFullOrder;
        this.orderContactNumber = orderContactNumber;
        this.orderAlternateContactNumber = orderAlternateContactNumber;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
        this.product = product;
        this.user = user;
    }



    public Product getProduct() {
        return product;
    }



    public void setProduct(Product product) {
        this.product = product;
    }



    public User getUser() {
        return user;
    }
    }

