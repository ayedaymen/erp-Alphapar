package fr.alphapar.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import fr.alphapar.entities.Facture;
import fr.alphapar.entities.Items;
import fr.alphapar.entities.User;
import fr.alphapar.services.IFactureService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/factures")
public class RestContorlFacture {
	@Autowired
	IFactureService iFactureService;
	
	@PostMapping("/ajouterFacture/{userId}")
	@ResponseBody
	public Facture ajouterFacture(@RequestBody Facture f,
							 @PathVariable("userId") long userId )
	{
		iFactureService.ajouterOuModiferFacture(f, userId);
		return f;
	}
	
	@PostMapping("/ajouterFacture")
	@ResponseBody
	public Facture ajouterFacture(@RequestBody Facture f )
	{
		iFactureService.ajouterOuModiferFacture(f);
		return f;
	}
	

	@GetMapping("/afficherFactures")
	public List<?> afficherFactures(){
	
		return iFactureService.afficherFactures();	
	}

	@GetMapping("/afficherFactures1")
	public Items afficherClient1() throws Exception{
	 
		/*JSONObject tasse = new JSONObject(maTasse);
		System.out.println(tasse.getString(couleur));
		JsonObject objet = new JsonParser().parse(maTasse).getAsJsonObject();
		System.out.println(objet.get(couleur).getAsString()); */
		 Items i =new Items();

			  i.setItems(iFactureService. afficherFactures());
					  i.setTotalsCount(iFactureService.afficherFactures().size());
	
		

		return  i;
	}
	
		@GetMapping("/afficherFacture/{userId}")
	public List<Facture> afficherClient(@PathVariable("userId") Long userId){
	
		return iFactureService.afficherFacturesByUser(userId);	
	}
		
	
	
	@DeleteMapping("/effacerFacture/{factureId}")
		public int effeacerFacture(@PathVariable("factureId") Long factureId){
		return iFactureService.supprimerById(factureId);
		
	}
}


