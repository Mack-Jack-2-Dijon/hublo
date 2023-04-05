package Projet3.hublo.Controller;

import Projet3.hublo.Entity.Category;
import Projet3.hublo.Entity.Favorit;
import Projet3.hublo.Repository.FavoritRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoritController {
    @Autowired
    FavoritRepository favoritRepository;

}
