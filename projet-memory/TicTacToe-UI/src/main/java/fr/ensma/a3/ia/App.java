package fr.ensma.a3.ia;

import fr.ensma.a3.ia.plateau.CasePresentation;
import fr.ensma.a3.ia.plateau.CaseVue;
import fr.ensma.a3.ia.plateau.ICaseObserver;
import fr.ensma.a3.ia.plateau.automate.IEtatAction;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application implements ICaseObserver
{
	CasePresentation p;
	private FlowPane root;
    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        
		root = new FlowPane(Orientation.HORIZONTAL,10, 10);
		root.setMinWidth(600);
		root.setAlignment(Pos.TOP_CENTER);
		
        
        CasePresentation p = new CasePresentation();
        CaseVue v = new CaseVue(p.getMediateur(), p);
        p.getMediateur().setVue(v);
        p.addActionHandler(this);
 
        root.getChildren().add(v);
        
        var scene = new Scene(root, 640, 480);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) 
    {
        launch();
    }

	@Override
	public void fonction(IEtatAction e) 
	{
		p.getMediateur().getVue().changementImage(e);
	}

}