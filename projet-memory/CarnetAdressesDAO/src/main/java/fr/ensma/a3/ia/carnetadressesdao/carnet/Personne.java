package fr.ensma.a3.ia.carnetadressesdao.carnet;

import java.util.Optional;

import fr.ensma.a3.ia.carnetadressesdao.dao.entity.AdresseEntity;

public class Personne 
{
	private String nom;
	private String prenom;
	private Adresse adr;
	
	public Personne (String n, String p, Adresse ad)
	{
		nom = n;
		prenom = p;
		adr = ad;
	}
	
	public Personne() 
	{
		
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the adr
	 */
	public Adresse getAdr() {
		return adr;
	}
	/**
	 * @param adr the adr to set
	 */
	public void setAdr(Adresse adr) {
		this.adr = adr;
	}
	
	
}
