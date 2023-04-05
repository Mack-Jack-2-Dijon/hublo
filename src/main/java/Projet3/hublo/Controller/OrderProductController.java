package Projet3.hublo.Controller;

import Projet3.hublo.Repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderProductController {
    @Autowired
    OrderProductRepository orderProductRepository;

}
