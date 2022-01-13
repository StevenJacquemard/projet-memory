package fr.ensma.a3.ia.carnetadressesdao.dao.entity;

import java.util.Objects;
import java.util.Optional;

/**
 * Entity Personne
 * @author jacquems
 *
 */
public class PersonneEntity {
	
	private int idPers;
	private String nom;
	private String prenom;
	private int idAdr;


	/**
	 * @return the idPers
	 */
	public int getIdPers() {
		return idPers;
	}

	/**
	 * @param idPers the idPers to set
	 */
	public void setIdPers(int idPers) {
		this.idPers = idPers;
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
	public int getIdAdr() {
		return idAdr;
	}

	/**
	 * @param optional the adr to set
	 */
	public void setAdr(int adr) {
		this.idAdr = adr;
	}

	@Override
	public String toString() {
		return "Personne (" + idPers + ") : " + nom + " " + prenom + ", idAdr = " + idAdr;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(idAdr, idPers, nom, prenom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonneEntity pers = (PersonneEntity) obj;
		return ((pers.getNom().equals(nom)) && (pers.getPrenom().equals(prenom)) && (pers.getIdAdr() == idAdr)) ;   
	}

	

}
