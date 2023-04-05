package Projet3.hublo.Controller;

import Projet3.hublo.Repository.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProductController {
    @Autowired
    UserProductRepository userProductRepository;

}
