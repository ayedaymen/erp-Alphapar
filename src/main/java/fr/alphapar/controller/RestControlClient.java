package fr.alphapar.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.alphapar.entities.Items;
import fr.alphapar.entities.User;
import fr.alphapar.services.IUserService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/crud")
public class RestControlClient {
	@Autowired
	IUserService iUserService;

	//http://localhost:8082/api/crud/ajouterclient 
		/*{"username": "nicolas1a236689","email":" nicolas1356689.ayed6@viacesi.fr","prenom":"aymen",
		 *"nom":"ayed","tele":"0632281125","address":"laxou"}*/
	@PostMapping("/ajouterclient")
	@ResponseBody
	@PreAuthorize("hasRole('ADMINISTRATEUR')")
	public User ajouterClient(@RequestBody User u)
	{
		iUserService.createOrUpdateClient(u);
		return u;
	}

	@PutMapping("/updateclient")
	@ResponseBody
	@PreAuthorize("hasRole('ADMINISTRATEUR')")
	public User ajouterupdateClient(@RequestBody User u)
	{
		iUserService.createOrUpdateClient(u);
		return u;
	}
	
	@PostMapping("/ajouteremployee")
	@PreAuthorize("hasRole('ADMINISTRATEUR')")
	@ResponseBody
	public User ajouterEmploye(@RequestBody User u)
	{
		iUserService.creatOrUpdateEmploye(u);
		return u;
	}
	@PostMapping("/afficherclient")
	public List <User> afficherClient(){
	
		return iUserService.getAllCustomer();	
	}
	
	@PostMapping("/afficherclient1")
	public Items afficherClient1(@RequestBody String obj) throws Exception{
	 
		/*JSONObject tasse = new JSONObject(maTasse);
		System.out.println(tasse.getString(couleur));
		JsonObject objet = new JsonParser().parse(maTasse).getAsJsonObject();
		System.out.println(objet.get(couleur).getAsString()); */
		 Items i =new Items();
	  JSONObject tasse;
		
	
			tasse = new JSONObject(obj);

			
			  System.out.println("aaaaaaaaaaaaaaa"+tasse.getString("filter"));
			  i.setItems(iUserService.getAllCustomerbyname(tasse.getString("filter")));
			  i.setTotalsCount(iUserService.getAllCustomer().size());
	
		

		return  i;
	}
	
	
	/*@PostMapping("/afficherclient1")
	public Items afficherClient1(){
	
  Items i =new Items();
  i.setItems(iUserService.getAllCustomer());
  i.setTotalsCount(iUserService.getAllCustomer().size());
		return  i;
	}*/
	@DeleteMapping("/effacerclient/{userId}")
	@PreAuthorize("hasRole('ADMINISTRATEUR')")
		public int effeacerClient(@PathVariable("userId") Long userId){
		return iUserService.deleteCustomerById(userId);
	}
}
