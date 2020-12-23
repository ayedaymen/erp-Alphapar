package fr.alphapar.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.alphapar.entities.Facture;

public interface IFactureService {

	public Facture ajouterOuModiferFacture(Facture f,long userId);
	public int supprimerById( long factureId);
	public List<?> afficherFactures();
	public Facture ajouterOuModiferFacture(Facture f);
	public List<Facture> afficherFacturesByUser(long userId);
	
}
