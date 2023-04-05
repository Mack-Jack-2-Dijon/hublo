package Projet3.hublo.Controller;

import Projet3.hublo.Entity.Order;
import Projet3.hublo.Entity.User;
import Projet3.hublo.Repository.OrderRepository;
import Projet3.hublo.Repository.UserRepository;
import Projet3.hublo.Tools.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    UserRepository userRepository;

    @PostMapping("/orders")
    public Order saveOrder(@RequestBody SpringDataJaxb.OrderDto orderDto) {
        Order order = new Order();
        order.setTreatmentDate(orderDto.getTreatmentDate());
        order.setOrderDate(orderDto.getOrderDate());
        order.setComment(orderDto.getComment());
        User user = userRepository.findById(orderDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", orderDto.getUserId()));
        order.setUser(user);
        return orderRepository.save(order);
    }
}
