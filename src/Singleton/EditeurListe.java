package Singleton;

import java.io.File;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import Builder.MediaBuilderFile;
import Director.DirectorFile;
import Director.DirectorXMLSave;
import Factory.ConcretMediaFactory;
import Factory.MediaFactory;
import SourceComposite.Media;
import SourceComposite.MediaSource;
import SourceComposite.SousListeMedia;
import Visitor.MediaVisitor;

public class EditeurListe {
	private static EditeurListe instance;
	private SousListeMedia list=null;
	private MediaFactory mediaFactory;
	private EditeurListe(String name) {
		this.mediaFactory= new ConcretMediaFactory();
		this.createList(name);
	
	}
	public static EditeurListe getInstance(String name) {
		if(instance == null) {
			instance= new EditeurListe(name);
		}
		return instance;
	}
	public void createList(String name) {
		this.list= mediaFactory.creerSousListeMedia(name);
	}
	public void lister(MediaVisitor visitor) {
		if(this.list == null)
			{System.out.println("La liste est vide ");}
			
		else{this.list.accept(visitor);}
		
	}
	public void listerMedia(MediaSource media, MediaVisitor visitor) {
		media.accept(visitor);
	}
	public void importer(String file, DirectorFile director) {
		//System.out.println("EditeurList importer");
		director.importer(file, list);		
	}
	public void entrer(int num){
		this.list=(SousListeMedia) this.list.entrer(num);
		System.out.println("Entrer dans : "+ this.list.getNom());
		
	}
	public void remonter() {
		this.list= (SousListeMedia) this.list.getParent();
		System.out.println("Remonter dans : "+ this.list.getNom());
		
	}
	public void save(String name, DirectorXMLSave director) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		director.save(name, this.list);
		
	}
	public SousListeMedia getList() {
		return list;
	}
	public void setList(SousListeMedia list) {
		this.list = list;
	}
	
	
}
