import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import Factory.ConcretMediaFactory;
import Factory.MediaFactory;
import Façade.EditeurMode;
import Façade.LigneCommande;
import SourceComposite.Media;
import SourceComposite.MediaAudio;
import SourceComposite.MediaSource;
import SourceComposite.SousListeMedia;
import Visitor.ListVisitor;
import Visitor.MediaVisitor;

public class EditeurMain {

	public static void main(String[] args) {
		LigneCommande commande= new LigneCommande();;
		if(args.length == 0) {
		commande.cmdHelep();
		}
		if(args.length >= 1 ) {
			commande.creerList(args[0]);
			commande.cmdLister();
		}
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String cmd= sc.nextLine();
			String[]arg = cmd.split(" ");
			if(arg.length == 1){
				if(arg[0].equals("help"))
					commande.cmdHelep();
				if( arg[0].equals("list")) 
					commande.cmdLister();

				if(arg[0].equals("remonter")) 
					commande.cmdRemonter();
			}
			else {
				if(arg[0].equals("import")) {
					commande.cmdImporter(arg[1]);
				}
				else if(arg[0].equals("creer")) {
					commande.creerList(arg[1]);
				}
				else if(arg[0].equals("entrer")){
					commande.cmdEntrer(Integer.parseInt (arg[1]));

				}
				else if(arg[0].equals("save")) {
					try {
						commande.cmdSave(arg[1]);
					} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerFactoryConfigurationError e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}


			}

		}
	}



}


