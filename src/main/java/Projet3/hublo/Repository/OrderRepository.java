package Projet3.hublo.Repository;

import Projet3.hublo.Entity.Order;
import Projet3.hublo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
    // méthode pour récupérer une commande par son id
    Optional<Order> findById(Long id);

    // méthode pour récupérer toutes les commandes
    List<Order> findAll();

    // méthode pour enregistrer une commande
    Order save(Order order);

    // méthode pour supprimer une commande
    void delete(Order order);
}
