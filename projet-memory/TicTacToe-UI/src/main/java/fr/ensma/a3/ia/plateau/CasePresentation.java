package fr.ensma.a3.ia.plateau;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.plateau.automate.EtatCroix;
import fr.ensma.a3.ia.plateau.automate.EtatRond;
import fr.ensma.a3.ia.plateau.automate.EtatVide;
import fr.ensma.a3.ia.plateau.automate.IEtatAction;
import fr.ensma.a3.ia.plateau.automate.TransitionActionException;

public class CasePresentation {

	//Mediateur
	ICaseMediateur mediatAction;
	//Automate
	private IEtatAction etatCourant;
	private IEtatAction EtatVide = new EtatVide(this);
	private IEtatAction EtatCroix = new EtatCroix(this);
	private IEtatAction EtatRond = new EtatRond(this);
	//Observer
	private List<ICaseObserver> mesAbo;
	
	public CasePresentation() {
		mediatAction = new CaseMediateur(this);
		mesAbo = new ArrayList<ICaseObserver>();
		etatCourant = EtatVide;
	}
	
	public ICaseMediateur getMediateur() {
		return mediatAction;
	}
	
	//Automate
	public IEtatAction getVide() 
	{
		return EtatVide;
	}
	
	public IEtatAction getCroix() 
	{
		return EtatCroix;
	}
	
	public IEtatAction getRond() 
	{
		return EtatRond;
	}
	
	public void setEtatCourant(final IEtatAction etat) {
		etatCourant = etat;
	}
	//Observer
	public void addActionHandler(ICaseObserver obs) {
		mesAbo.add(obs);
	}

	//
	public void next() {
		try {
			etatCourant.next(mesAbo);
		} catch (TransitionActionException e) {
			
		}
	}
	
}
