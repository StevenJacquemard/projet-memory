package fr.ensma.a3.ia.plateau.automate;

import java.util.List;

import fr.ensma.a3.ia.plateau.CasePresentation;
import fr.ensma.a3.ia.plateau.ICaseObserver;

public class EtatCroix extends AbstractEtat
{

	public EtatCroix(CasePresentation pr) 
	{
		super(pr,"/croix.png");
	}
	
	@Override
	public void toVide() throws TransitionActionException {
		autom.setEtatCourant(autom.getVide());
	}

	@Override
	public void next(List<ICaseObserver> mesAbo) throws TransitionActionException {
		autom.setEtatCourant(autom.getVide());
		
		for (ICaseObserver obs : mesAbo) 
		{
			obs.fonction(this);
		}
		
	}
	

}
