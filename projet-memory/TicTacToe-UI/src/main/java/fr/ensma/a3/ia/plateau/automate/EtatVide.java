package fr.ensma.a3.ia.plateau.automate;

import java.util.List;

import fr.ensma.a3.ia.plateau.CasePresentation;
import fr.ensma.a3.ia.plateau.ICaseObserver;

public class EtatVide extends AbstractEtat
{

		public EtatVide(CasePresentation pr) {
		super(pr,"/vide.png");
	}
	
	@Override
	public void toRond() throws TransitionActionException {
		autom.setEtatCourant(autom.getRond());
	}

	@Override
	public void next(List<ICaseObserver> mesAbo) throws TransitionActionException {
		autom.setEtatCourant(autom.getRond());
		
		for (ICaseObserver obs : mesAbo) 
		{
			obs.fonction(this);
		}
		
	}
}
