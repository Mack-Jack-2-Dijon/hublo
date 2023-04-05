package Projet3.hublo.Repository;

import Projet3.hublo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // méthode pour récupérer un utilisateur par son id
    Optional<User> findById(Long id);

    // méthode pour récupérer un utilisateur par son email
    Optional<User> findByEmail(String email);

    // méthode pour récupérer tous les utilisateurs
    List<User> findAll();

    // méthode pour enregistrer un utilisateur
    User save(User user);

    // méthode pour supprimer un utilisateur
    void delete(User user);
}
