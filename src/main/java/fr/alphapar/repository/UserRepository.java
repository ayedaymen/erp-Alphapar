package fr.alphapar.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.alphapar.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	/* liste des Customer  */
	@Query(value = "SELECT user_id FROM user_roles WHERE role_id=4", nativeQuery = true)
	public List<Long> listepOfCustomer();

	@Query(value ="SELECT *FROM users u where EXISTS (SELECT * FROM user_roles ur WHERE ur.user_id = u.id AND ur.role_id = 4)"
			+ " and ( u.tele like ?1%  or `nom` like ?1% or `address` like ?1% or `prenom` like ?1% or`username` like ?1% or `email` like ?1%) ",nativeQuery = true)
	public List<User> findUserbyName(String name);

}