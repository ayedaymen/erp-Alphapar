package fr.alphapar.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.alphapar.entities.ERole;
import fr.alphapar.entities.Role;
import fr.alphapar.entities.User;
import fr.alphapar.repository.RoleRepository;
import fr.alphapar.repository.UserRepository;

@Service
public class userServiceImpl implements IUserService{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	@Override
	public List<User> getAllCustomer() {
		
	List<Long>a=userRepository.listepOfCustomer();
	List<User>users=new ArrayList<>();
	for(Long b:a){
	User user=userRepository.findById(b).get();
	users.add(user);
	}
	return users;
	}

	@Override
	public User createOrUpdateClient(User u) {
		Set<Role> roles = new HashSet<>();
		u.getRoles();
		Role client= roleRepository.findByName(ERole.ROLE_CLIENT)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(client);
		u.setRoles(roles);
		userRepository.save(u);
		return	u;

	}
	@Override
	public User creatOrUpdateEmploye(User u) {
		Set<Role> roles = new HashSet<>();
		u.getRoles();
		Role client= roleRepository.findByName(ERole.ROLE_CHEF_DEPARTMENT)
		.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(client);
		u.setRoles(roles);
		userRepository.save(u);
		return	u;
	}

	@Override
	public int deleteCustomerById(Long userId) {
		User u =userRepository.findById(userId).get();
		 userRepository.delete(u);
		 return 0;
		
	}
	
	public List<User> getAllCustomerbyname(String name) {
		
		return userRepository.findUserbyName(name);
	
}
}
