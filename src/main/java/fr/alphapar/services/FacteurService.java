package fr.alphapar.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.alphapar.entities.Facture;
import fr.alphapar.entities.User;
import fr.alphapar.repository.FactureRepository;
import fr.alphapar.repository.UserRepository;

@Service
public class FacteurService implements IFactureService{

	 @Autowired
	 FactureRepository factureRepository;
	 @Autowired
	 UserRepository userRepository;
	 
	 
	@Override
	public Facture ajouterOuModiferFacture(Facture f,long userId) {
		User u =userRepository.findById(userId).get();
		LocalDate localDate = LocalDate.now();
		f.setDate(java.sql.Date.valueOf(localDate));
		f.setIdUser(u);	
		factureRepository.save(f);
		return f;
	}
	@Override
	public Facture ajouterOuModiferFacture(Facture f) {
		LocalDate localDate = LocalDate.now();
		f.setDate(java.sql.Date.valueOf(localDate));
		factureRepository.save(f);
		return f;
	}

	@Override
	public int supprimerById(long factureId ) {
	Facture f=factureRepository.findById(factureId).get();
    factureRepository.delete(f);
		return 0;
	}

	@Override
	public List<?> afficherFactures() {
		return factureRepository.listofFacture();
	 
	}

	@Override
	public List<Facture> afficherFacturesByUser(long userId) {
		return factureRepository.listofFactureByUserId(userId);
	}

	
}
