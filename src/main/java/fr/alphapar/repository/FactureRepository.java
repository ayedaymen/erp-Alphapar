package fr.alphapar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.alphapar.entities.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

	@Query(value = "SELECT * FROM Facture", nativeQuery = true)
	public List<Facture> listofFacture();
	@Query(value = "SELECT * FROM Facture where id_user=?1", nativeQuery = true)
	public List<Facture> listofFactureByUserId(long userId);
}
