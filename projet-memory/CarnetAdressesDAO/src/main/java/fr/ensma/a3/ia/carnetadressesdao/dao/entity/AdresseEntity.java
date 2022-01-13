package fr.ensma.a3.ia.carnetadressesdao.dao.entity;

/**
 * Entity Adresse.
 * @author michaelrichard
 *
 */
public class AdresseEntity {

	private int idAdr;
	private int numRue;
	private String nomRue;
	private String nomVille;
	private int codePostal;

	public final int getIdAdr() {
		return idAdr;
	}

	public final void setIdAdr(final int id) {
		idAdr = id;
	}

	public final int getNumRue() {
		return numRue;
	}

	public final void setNumRue(final int numr) {
		numRue = numr;
	}

	public final String getNomRue() {
		return nomRue;
	}

	public final void setNomRue(final String nomr) {
		nomRue = nomr;
	}

	public final String getNomVille() {
		return nomVille;
	}

	public final void setNomVille(final String nomv) {
		nomVille = nomv;
	}

	public final int getCodePostal() {
		return codePostal;
	}

	public final void setCodePostal(final int codep) {
		codePostal = codep;
	}

	@Override
	public String toString() {
		return idAdr + " : " + numRue + " " + nomRue + " - " + codePostal + " " + nomVille;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof AdresseEntity)) {
			return false;
		} else {
			AdresseEntity ad = (AdresseEntity) obj;
			if ((ad.getNumRue() == numRue) && (ad.getNomRue().compareTo(nomRue) == 0)
					&& (ad.getCodePostal() == codePostal) && (ad.getNomVille().compareTo(nomVille) == 0)) {
				return true;
			} else {
				return false;
			}
		}
	}

}
