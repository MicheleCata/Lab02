package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary model ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button bntTranslate;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnReset;
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	txtRisultato.clear();
    	String testo = txtParola.getText().toLowerCase();
    	
    	if (testo.length()==0) {
    		txtRisultato.setText("Inserisci almeno una parola ");
    		return;
    	}
    	
    	if ((testo.matches(".*[a-zA-Z?].*")==false)) {
    		txtRisultato.setText("Errore!! caratteri non validi, devi inserire caratteri: a-z, A-Z o un ?");
    		return;
    	}
    	
    	String [] campi = testo.split(" ");
    	String alienWord;
    	String translation;
    	String risultato;
    	if (campi.length==2) {
    		 alienWord = campi[0];
    		 translation= campi[1];

    		 Word w = new Word (alienWord, translation);
    		 model.addWord(alienWord, translation);
    		 txtRisultato.setText(w.toString());
    		 txtParola.setText("");
    	} else if (campi.length==1) {
    		alienWord = campi[0];
    		if ((alienWord.matches("[a-zA-Z?]*") && !alienWord.matches("[a-zA-Z]*")))
    				risultato =(model.translateWordWildCard(alienWord));
    		else 
    			risultato = (model.translateWord(alienWord));
    		if (risultato!=null)
    			txtRisultato.setText(risultato);
    		else {
    			txtRisultato.setText("La parola non è presente nel dizionario. ");
    			txtParola.setText("");
    		}
    	}
    		
    }
    
    public void setModel (AlienDictionary model) {
    	this.model=model;
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtRisultato.clear();
    	model.rimuoviTutto();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert bntTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
