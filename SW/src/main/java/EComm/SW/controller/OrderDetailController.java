package EComm.SW.controller;

import EComm.SW.entity.OrderDetail;
import EComm.SW.entity.OrderInput;
import EComm.SW.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/all")
    public ResponseEntity<List<OrderDetail>> getAllOrders() {
        List<OrderDetail> orders = orderDetailService.getAllOrderDetails();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderDetail>> getOrdersForUser(@PathVariable String userId) {
        List<OrderDetail> orders = orderDetailService.getOrderDetailsForUser(userId);
        if (orders != null) {
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/place/{userId}")
    public ResponseEntity<String> placeOrder(@RequestBody OrderInput orderInput,
                                             @RequestParam(required = false) boolean isSingleProductCheckout,
                                             @PathVariable String userId) {
        orderDetailService.placeOrder(orderInput, isSingleProductCheckout, userId);
        return new ResponseEntity<>("Order placed successfully", HttpStatus.CREATED);
    }
}
