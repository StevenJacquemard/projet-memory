package fr.ensma.a3.ia.plateau.automate;

import fr.ensma.a3.ia.plateau.CasePresentation;

public abstract class AbstractEtat implements IEtatAction {

	protected CasePresentation autom;
	protected String imageName;
	
	public AbstractEtat(final CasePresentation pr, String n) {
		autom = pr;
		imageName = n;
	}
	
	@Override
	public void toVide() throws TransitionActionException {
		throw new TransitionActionException();	
	}

	@Override
	public void toCroix() throws TransitionActionException {
		throw new TransitionActionException();
		
	}
	
	@Override
	public void toRond() throws TransitionActionException {
		throw new TransitionActionException();
		
	}
	public String getImageName()
	{
		return imageName;
	}

}
