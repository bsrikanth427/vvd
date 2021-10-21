package com.ae.visuavid.web.rest;

import com.ae.visuavid.constants.OrderStatus;
import com.ae.visuavid.service.OrderService;
import com.ae.visuavid.service.RazorPayService;
import com.ae.visuavid.service.dto.OrderDTO;
import com.ae.visuavid.service.dto.OrderRequestDTO;
import com.ae.visuavid.service.dto.PaymentOrderDTO;
import com.ae.visuavid.service.dto.RazorPayResponseDTO;
import com.ae.visuavid.web.rest.errors.ApiRuntimeException;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderResource {
    private static final Logger log = LoggerFactory.getLogger(OrderResource.class);

    @Autowired
    protected OrderService orderService;

    @Autowired
    protected RazorPayService razorPayService;

    @PostMapping("/order")
    public ResponseEntity<PaymentOrderDTO> create(@Valid @RequestBody OrderRequestDTO orderRequest) {
        List<OrderDTO> orders = orderService.create(orderRequest);
        PaymentOrderDTO paymentOrder = razorPayService.createPaymentOrder(orders);
        orderService.updatePaymentOrder(orders, paymentOrder, orderRequest.getUserId());
        return new ResponseEntity<>(paymentOrder, HttpStatus.CREATED);
    }

    @PutMapping("/order")
    public ResponseEntity<OrderDTO> update(@Valid @RequestBody OrderDTO orderDTO) {
        if (orderDTO.getId() != null) {
            return new ResponseEntity<>(orderService.create(orderDTO), HttpStatus.ACCEPTED);
        } else {
            throw new ApiRuntimeException("cannot update order without Id");
        }
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDTO> findOrderById(@PathVariable("id") String id) {
        OrderDTO orderDTO = orderService.findOrderById(UUID.fromString(id));
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @GetMapping("/orders/{userId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByUserId(@PathVariable("userId") String userId) {
        List<OrderDTO> ordersDTO = orderService.getOrdersByUserId(UUID.fromString(userId));
        return new ResponseEntity<>(ordersDTO, HttpStatus.OK);
    }

    @GetMapping("/order/{id}/customerupload")
    public ResponseEntity<OrderDTO> findOrderByIdForCustomerUpload(@PathVariable("id") String id) {
        OrderDTO orderDTO = orderService.findOrderById(UUID.fromString(id));
        if (OrderStatus.PAYMENT_COMPLETED.name().equalsIgnoreCase(orderDTO.getOrderStatus())) {
            return new ResponseEntity<>(orderDTO, HttpStatus.OK);
        }
        throw new ApiRuntimeException("Payment is not completed for the order: " + id);
    }

    @PutMapping("/order/{id}/customerupload")
    public ResponseEntity<OrderDTO> saveCustomerUpload(@PathVariable("id") String id, @RequestBody OrderDTO orderDTO) {
        orderDTO = orderService.saveCustomerUpload(orderDTO);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @GetMapping("/orders/{pageNumber}/{pageSize}")
    public ResponseEntity<List<OrderDTO>> findOrders(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize) {
        Pageable pagingSort = PageRequest.of(pageNumber, pageSize);
        List<OrderDTO> orders = orderService.findAll(pagingSort);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/order/updaterazorpaytransaction")
    public List<OrderDTO> updateRazorPayTransaction(@Valid @RequestBody RazorPayResponseDTO razorPayResponse) {
        orderService.updateRazorPayTransaction(razorPayResponse);
        return orderService.getOrdersByRazorPayOrderId(razorPayResponse.getRazorpayOrderId());
    }

    @PutMapping("/order/{orderid}/employee/{employeeid}/assign")
    public ResponseEntity<Void> assignOrderToEmployee(
        @PathVariable("orderid") String orderId,
        @PathVariable("employeeid") String employeeId
    ) {
        return null;
    }
}
