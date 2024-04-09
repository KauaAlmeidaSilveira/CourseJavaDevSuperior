package com.devsuperior.DSCommerce.services;

import com.devsuperior.DSCommerce.DTO.OrderDTO;
import com.devsuperior.DSCommerce.DTO.OrderItemDTO;
import com.devsuperior.DSCommerce.entities.Order;
import com.devsuperior.DSCommerce.entities.OrderItem;
import com.devsuperior.DSCommerce.entities.Product;
import com.devsuperior.DSCommerce.entities.User;
import com.devsuperior.DSCommerce.entities.enums.OrderStatus;
import com.devsuperior.DSCommerce.repositories.OrderItemRepository;
import com.devsuperior.DSCommerce.repositories.OrderRepository;
import com.devsuperior.DSCommerce.repositories.ProductRepository;
import com.devsuperior.DSCommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado !!"));

        authService.validateSelfOrAdmin(order.getClient().getId());
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO orderDTO) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.autheticated();

        order.setClient(user);

        for (OrderItemDTO itemDto : orderDTO.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            OrderItem orderItem = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
            order.getOrderItem().add(orderItem);
        }

        orderRepository.save(order);
        orderItemRepository.saveAll(order.getOrderItem());

        return new OrderDTO(order);
    }


}
