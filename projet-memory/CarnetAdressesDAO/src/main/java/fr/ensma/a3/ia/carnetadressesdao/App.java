package fr.ensma.a3.ia.carnetadressesdao;

import java.util.List;
import java.util.Optional;

import fr.ensma.a3.ia.carnetadressesdao.carnet.Adresse;
import fr.ensma.a3.ia.carnetadressesdao.carnet.Carnet;
import fr.ensma.a3.ia.carnetadressesdao.carnet.Personne;
import fr.ensma.a3.ia.carnetadressesdao.dao.AdressePoiDAO;
import fr.ensma.a3.ia.carnetadressesdao.dao.IDao;
import fr.ensma.a3.ia.carnetadressesdao.dao.PersonnePoiDAO;
import fr.ensma.a3.ia.carnetadressesdao.dao.entity.AdresseEntity;
import fr.ensma.a3.ia.carnetadressesdao.dao.entity.PersonneEntity;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Carnet ca = new Carnet();
    	
    	ca.nouveauContact("Elie", "Tricoire", new Adresse(3, "rue de la biere","Chassou",85677));
    	
    	ca.supprimerContact(ca.contactParNom("Trie"));
    	
    	
    	
    	for(Personne pers : ca.toutLesContacts()) {
    		System.out.println(pers.toString());
    	}
    }
}



/*
 System.out.println("-------------------------------");
    	System.out.println("Elements dans la base adresse :");
    	IDao<AdresseEntity> adrdao = new AdressePoiDAO();
    	List<AdresseEntity> alladr = adrdao.getAll();
    	for(AdresseEntity ad : alladr) {
    		System.out.println(ad);
    	}
    	AdresseEntity adcherche = new AdresseEntity();
    	adcherche.setNumRue(12);
    	adcherche.setNomRue("rue toulent");
    	adcherche.setCodePostal(91000);
    	adcherche.setNomVille("JavaLand");
    	System.out.println("Recherche par valeur de l'élément : " + adcherche);
    	Optional<AdresseEntity> res = adrdao.getByValue(adcherche); 
    	if(res.isPresent()) {
    		System.out.println(res.get());
    	}
    	res = adrdao.getById(1);
    	System.out.println("Recherche par id de l'élément : id=1 ");
    	if(res.isPresent()) {
    		System.out.println(res.get());
    	}
    	AdresseEntity adrajout = new AdresseEntity();
    	adrajout.setNumRue(10);
    	adrajout.setNomRue("toumoche");
    	adrajout.setCodePostal(97000);
    	adrajout.setNomVille("PitonVille");
    	System.out.println("Création de l'element : " + adrajout);
    	adrdao.create(adrajout);
    	adrajout.setNomVille("PythonVille");
    	System.out.println("Update du nom de la ville");
    	adrdao.update(adrajout);
    	System.out.println("Elements dans la base adresse :");
    	alladr = adrdao.getAll();
    	for(AdresseEntity ad : alladr) {
    		System.out.println(ad);
    	}
    	System.out.println("Suppression de l'éméent id = 3");
    	adrdao.delete(adrdao.getById(3).get());
    	System.out.println("Elements dans la base adresse :");
    	alladr = adrdao.getAll();
    	for(AdresseEntity ad : alladr) {
    		System.out.println(ad);
    	}
    	
    	
    	System.out.println("-------------------------------");
    	System.out.println("Elements dans la base personne :");
    	IDao<PersonneEntity> persdao = new PersonnePoiDAO();
    	List<PersonneEntity> allpers = persdao.getAll();
    	for(PersonneEntity pers : allpers) {
    		System.out.println(pers);
    	}
    	PersonneEntity perscherche = new PersonneEntity();
    	
    	adcherche = new AdresseEntity();
    	adcherche.setNumRue(12);
    	adcherche.setNomRue("rue toulent");
    	adcherche.setCodePostal(91000);
    	adcherche.setNomVille("JavaLand");
    	
    	perscherche.setNom("BARON");
    	perscherche.setPrenom("Keulkeul");
    	Optional<AdresseEntity> adrOptional = Optional.of(adcherche);
    	perscherche.setAdr(adrOptional);
    	System.out.println("Recherche par valeur de l'élément : " + perscherche);
    	Optional<PersonneEntity> resPers = persdao.getByValue(perscherche); 
    	if(resPers.isPresent()) {
    		System.out.println(resPers.get());
    	}
    	
    	resPers = persdao.getById(1);
    	System.out.println("Recherche par id de l'élément : id=1 ");
    	if(resPers.isPresent()) {
    		System.out.println(resPers.get());
    	}
    	
    	PersonneEntity persajout = new PersonneEntity();
    	adrajout = new AdresseEntity();
    	adrajout.setNumRue(12);
    	adrajout.setNomRue("rue ensma");
    	adrajout.setCodePostal(86360);
    	adrajout.setNomVille("Chassou");
   
    	persajout.setNom("Tricoire");
    	persajout.setPrenom("Elie");
    	persajout.setAdr(Optional.of(adrajout));
    	System.out.println("Création de l'element : " + persajout);
    	persdao.create(persajout);
    	persajout.setNom("Jacquemard");
    	System.out.println("Update du nom de la personne");
    	persdao.update(persajout);
    	System.out.println("Elements dans la base personne :");
    	allpers = persdao.getAll();
    	for(PersonneEntity pers : allpers) {
    		System.out.println(pers);
    	}
    	System.out.println("Suppression de l'éméent id = 3");
    	persdao.delete(persdao.getById(3).get());
    	System.out.println("Elements dans la base personnes :");
    	allpers = persdao.getAll();
    	for(PersonneEntity pers : allpers) {
    		System.out.println(pers);
    	}
*/
