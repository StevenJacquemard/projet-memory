package fr.ensma.a3.ia.carnetadressesdao.carnet;

public class Adresse 
{
	private int numRue;
	private String nomRue;
	private String nomVille;
	private int codePostal;
	
	
	@Override
	public String toString() {
		return "Adresse [numRue=" + numRue + ", nomRue=" + nomRue + ", nomVille=" + nomVille + ", codePostal="
				+ codePostal + "]";
	}
	/**
	 * @return the numRue
	 */
	public int getNumRue() {
		return numRue;
	}
	public Adresse() {
		super();
	}
	public Adresse(int numRue, String nomRue, String nomVille, int codePostal) {
		super();
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.nomVille = nomVille;
		this.codePostal = codePostal;
	}
	/**
	 * @param numRue the numRue to set
	 */
	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}
	/**
	 * @return the nomRue
	 */
	public String getNomRue() {
		return nomRue;
	}
	/**
	 * @param nomRue the nomRue to set
	 */
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	/**
	 * @return the nomVille
	 */
	public String getNomVille() {
		return nomVille;
	}
	/**
	 * @param nomVille the nomVille to set
	 */
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	
}
