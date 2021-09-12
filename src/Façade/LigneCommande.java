package Façade;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import Builder.MediaBuilderFile;
import Builder.MediaBuilderFileStd;
import Director.DirectorFile;
import Director.DirectorXMLSave;
import Singleton.EditeurListe;
import SourceComposite.MediaSource;
import Visitor.ListVisitor;
import Visitor.MediaVisitor;

public class LigneCommande implements EditeurMode {
	private EditeurListe editeur;
	MediaVisitor visitor= new ListVisitor();
	public LigneCommande() {
		
		
	}
	public void creerList(String name) {
		editeur = EditeurListe.getInstance(name);
	}
	public void cmdLister() {
		if(editeur == null)
			System.out.println("La liste n 'existe pas: commencez par créer la liste !");
		else {editeur.lister(visitor);}
		
	}
	public void cmdImporter(String file) {
		DirectorFile director = new DirectorFile(new MediaBuilderFileStd());
		//System.out.println("cmdImpoter");
		editeur.importer(file, director);
		editeur.lister(visitor);
	}
	public void cmdEntrer(int num) {
		editeur.entrer(num);
		//editeur.listerMedia(m, visitor);
		
	}
	public void cmdRemonter() {
		editeur.remonter();
	}
	public void cmdSave(String name) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		DirectorXMLSave directorXML= new DirectorXMLSave();
		editeur.save(name, directorXML);
	}
	public EditeurListe getEditeur() {
		return editeur;
	}
	public void cmdHelep() {
		String Help = "*************************HELP********************************************";
		String creer = "****creer NomListe : pour creer une liste*****************************";
		String impfi = "****import NomFichier: pour importer un fichier media**********************";
		String impdos = "****import Nomdossier: pour importer une sousliste***********************";
		String entrer="****entrer NumSousListe: pour entrer dans la sous liste********************";
		String remonter="****remonter : pour remonter dans la liste parent************************";
		String list="****list : pour lister la liste actuelle*************************************";
		String save ="****save toto.xpl: pour sauvegarder la liste sous format XML****************";
		String charger="****load toto.xpl: pour charger une liste à partir d'un fichier XML*******";
		String ch="****help : pour avoir de l'aide *******";
		System.out.println();
		System.out.println(Help);
		System.out.println(creer);
		System.out.println(impfi);
		System.out.println(entrer);
		System.out.println(remonter);
		System.out.println(list);
		System.out.println(save);
		System.out.println(charger);
		System.out.println(ch);
		System.out.println("**********************************************************************");
		
	}
	

}
