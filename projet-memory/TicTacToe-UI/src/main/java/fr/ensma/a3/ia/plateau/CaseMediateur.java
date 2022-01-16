package fr.ensma.a3.ia.plateau;

public class CaseMediateur implements ICaseMediateur{

	private CasePresentation presentation;
	private CaseVue vue;
	
	
	public CaseMediateur(CasePresentation pr) {
		presentation = pr;
		vue = new CaseVue(this, pr);
	}



	@Override
	public void setVue(CaseVue v) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void next() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public CaseVue getVue() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
