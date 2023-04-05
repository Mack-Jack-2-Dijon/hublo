package Projet3.hublo.Repository;

import Projet3.hublo.Entity.Favorit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritRepository extends JpaRepository<Favorit, Long> {
}
