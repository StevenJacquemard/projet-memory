package fr.ensma.a3.ia.plateau.automate;

import java.util.List;

import fr.ensma.a3.ia.plateau.ICaseObserver;

public interface IEtatAction 
{
	void toVide() throws TransitionActionException;
	void toCroix() throws TransitionActionException;
	void toRond() throws TransitionActionException;
	void next(List<ICaseObserver> mesAbo) throws TransitionActionException;
	String getImageName();
	
}
