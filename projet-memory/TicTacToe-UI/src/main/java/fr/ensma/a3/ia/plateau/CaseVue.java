package fr.ensma.a3.ia.plateau;

import fr.ensma.a3.ia.plateau.automate.IEtatAction;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CaseVue extends Button implements EventHandler<ActionEvent> {

	private CasePresentation presAction;
	
	private Button actConvert;
	private ComboBox<String> choixSens;
	
	public CaseVue(ICaseMediateur med, CasePresentation pre) {
		super("Active Buttton");
	
		Image img = new Image(getClass().getResource("/croix.png").toString());
		ImageView view = new ImageView(img);
		this.setGraphic(view);
		
		addEventHandler(ActionEvent.ACTION, this);
		
		presAction = pre;
	}
	

	@Override
	public void handle(ActionEvent event) 
	{
		presAction.next();
	}
	
	public void changementImage(IEtatAction e)
	{
		Image img = new Image(getClass().getResource(e.getImageName()).toString());
		ImageView view = new ImageView(img);
		this.setGraphic(view);
	}

}
