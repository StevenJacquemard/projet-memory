package fr.ensma.a3.ia.carnetadressesdao.api;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.carnetadressesdao.carnet.Adresse;
import fr.ensma.a3.ia.carnetadressesdao.carnet.Personne;
import fr.ensma.a3.ia.carnetadressesdao.dao.AdressePoiDAO;
import fr.ensma.a3.ia.carnetadressesdao.dao.IDao;
import fr.ensma.a3.ia.carnetadressesdao.dao.PersonnePoiDAO;
import fr.ensma.a3.ia.carnetadressesdao.dao.entity.AdresseEntity;
import fr.ensma.a3.ia.carnetadressesdao.dao.entity.PersonneEntity;

public class Mediateur 
{
	IDao<AdresseEntity> adrdao = new AdressePoiDAO();
	IDao<PersonneEntity> persdao = new PersonnePoiDAO();
	
	public Mediateur()
	{
		
	}
	
	public ArrayList<Personne> getAllPersonnes() 
	{
		ArrayList<Personne> personnages = new ArrayList<Personne>();
		
		List<PersonneEntity> allpers = persdao.getAll();
    	List<AdresseEntity> alladr = adrdao.getAll();
    	
    	
    	for(PersonneEntity pers : allpers) 
    	{
    		for(AdresseEntity adr : alladr)
    		{
  			
    			if (pers.getIdAdr()== adr.getIdAdr())
    			{
    		    	Personne p = new Personne();
    		    	Adresse a = new Adresse();
    				
    				a.setNumRue(adr.getNumRue());
    				a.setNomRue(adr.getNomRue());
    				a.setNomVille(adr.getNomVille());
    				a.setCodePostal(adr.getCodePostal());
    				
    				p.setPrenom(pers.getPrenom());
    				p.setNom(pers.getNom());
    				p.setAdr(a);
    				
    				personnages.add(p);
    				
    			}
    		}
    	}
		return personnages;
	}

	public void addNewPersonne(Personne p) 
	{
			PersonneEntity pers	= new PersonneEntity();
	    	AdresseEntity adr = new AdresseEntity();
	    	
	    	adr.setNumRue(p.getAdr().getNumRue());
	    	adr.setNomRue(p.getAdr().getNomRue());
	    	adr.setCodePostal(p.getAdr().getCodePostal());
	    	adr.setNomVille(p.getAdr().getNomVille());
	    	
	    	adrdao.create(adr);
	    		
			pers.setNom(p.getNom());
	    	pers.setPrenom(p.getPrenom());
	    	pers.setAdr(adrdao.getByValue(adr).get().getIdAdr());
	    	
	    	persdao.create(pers);
	}


	public Personne getContactByName(String n) 
	{
		//Fonctionne pas encore
		for(Personne pers : this.getAllPersonnes())
			{
			System.out.println(pers.getNom().equals(n));
				if (pers.getNom().equals(n))
				{
					pers.toString();
					return pers;
				}
			};
			return null;
	}

}










