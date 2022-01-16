package fr.ensma.a3.ia.carnetadressesdao.carnet;

import java.util.ArrayList;

import fr.ensma.a3.ia.carnetadressesdao.api.Mediateur;

public class Carnet 
{
	static Mediateur api =new Mediateur();

	public Carnet() 
	{
	}
	
	public void nouveauContact(String n, String p, Adresse ad)
	{
		api.addNewPersonne(new Personne(n, p, ad));
	}
	
	public ArrayList<Personne> toutLesContacts()
	{
		return api.getAllPersonnes();
	}
	
	public Personne contactParNom(String n)
	{
		return api.getContactByName(n);
	}
	
	public void supprimerContact(Personne p)
	{
		api.removePersonne(p);
	}
	
	
}
