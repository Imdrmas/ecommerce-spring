package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.dto.OrderProductDto;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.modal.Order;
import com.ecommerce.modal.OrderProduct;
import com.ecommerce.modal.OrderStatus;
import com.ecommerce.service.OrderProductService;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderProductService orderProductService;
	
	@GetMapping("/getAllOrders")
	Iterable<Order> getAllOrders() {
		return orderService.getAllOrders();
	}
	
    @PostMapping
    ResponseEntity<Order> createOrder(@RequestBody OrderForm form) {
    	List<OrderProductDto> formsDtos = form.getProductOrders();
    	vlidteProductExistance(formsDtos);
    	Order order = new Order();
    	order.setStatus(OrderStatus.PAID.name());
    	order = this.orderService.createOrder(order);
    	
    	List<OrderProduct> orderProducts = new ArrayList<>();
    	for(OrderProductDto dto: formsDtos) {
    		orderProducts.add(orderProductService.addOrderProduct(
    				new OrderProduct(order, productService.findProductById(dto
    						.getProduct()
    						.getId()), dto.getQuantity())));
    	}
    	order.setOrderProducts(orderProducts);
    	this.orderService.updateOrder(order);
    	
    	String uri = ServletUriComponentsBuilder
    			.fromCurrentServletMapping()
    			.path("/order/{id}")
    			.buildAndExpand(order.getId())
    			.toString();
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Location", uri);
    	
    	return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }
    private void vlidteProductExistance(List<OrderProductDto> orderProducts) {
		List<OrderProductDto> list = orderProducts
				.stream()
				.filter(op -> Objects.isNull(productService.findProductById(
						op.getProduct()
						.getId())))
				.collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(list)) {
			new ResourceNotFoundException("Product not found");
		}
	}
    
	@PutMapping("/updateOrder")
    void updateOrder(@RequestBody Order order) {
    	orderService.updateOrder(order);
    }
    @DeleteMapping("/deleteOrder/{id}")
    void deleteOrder(@PathVariable long id) {
    	orderService.deleteOrder(id);
    }
    
    public static class OrderForm {

        private List<OrderProductDto> productOrders;

        public List<OrderProductDto> getProductOrders() {
            return productOrders;
        }

        public void setProductOrders(List<OrderProductDto> productOrders) {
            this.productOrders = productOrders;
        }
        
    }
}
