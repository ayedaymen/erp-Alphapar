package fr.alphapar.services;

import java.util.List;

import fr.alphapar.entities.User;


public interface IUserService {
	public List<User> getAllCustomer();
	public User createOrUpdateClient(User u);
	public User creatOrUpdateEmploye(User u);
public int deleteCustomerById(Long userId);
List<User> getAllCustomerbyname(String name);

}
