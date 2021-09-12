package Director;

import java.io.File;
import java.util.Dictionary;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Builder.MediaSaveXML;
import SourceComposite.MediaAudio;
import SourceComposite.MediaSource;
import SourceComposite.MediaVideo;
import SourceComposite.SousListeMedia;
import Visitor.MediaVisitor;

public class DirectorXMLSave implements MediaVisitor{
	MediaSaveXML saveXML;
	private Element racineMedia;
	private Document document;
	public DirectorXMLSave() {
		
	}
	public void save(String file, SousListeMedia source) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		File xml = new File(file);
		StreamResult result = new StreamResult(xml);
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		visitSousListeMedia(source);
		document.appendChild(racineMedia);
		 DOMSource domSource = new DOMSource(document);
	        Transformer xformer = TransformerFactory.newInstance().newTransformer();
	        xformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        xformer.transform(domSource, result);
		
	}
	public Element creerElementRacine(SousListeMedia l) {
		Element racine=document.createElement("Liste");
		creerAttribut(racine, "nom", l.getNom());
		for(MediaSource media : l.getList()) {
			media.accept(this);
			racine.appendChild(racineMedia);
		}
		return racine;
	}

	public void creerAttribut(Element element, String nom, String valeur) {
		Attr attribut = document.createAttribute(nom);
    	element.setAttributeNode(attribut);
    	attribut.setValue(valeur);
    	System.out.println(attribut.getNodeName()+" "+attribut.getNodeValue());
    	System.out.println(attribut.getName()+" "+attribut.getValue());
	}
	@Override
	public void visitSousListeMedia(SousListeMedia sl) {
		
		racineMedia=this.creerElementRacine(sl);;
	}
	@Override
	public void visitFichierAudio(MediaAudio fa) {
		racineMedia= document.createElement("Audio");
		creerAttribut(racineMedia,"duree", String.valueOf(fa.getDuree()));
		creerAttribut(racineMedia,"nom", fa.getNom());
		creerAttribut(racineMedia,"artiste", fa.getNomArtiste());
		
	}
	@Override
	public void visitFichierVideo(MediaVideo fv) {
		racineMedia=document.createElement("Video");
		creerAttribut(racineMedia, "duree",String.valueOf(fv.getDuree()));
		creerAttribut(racineMedia, "titre", fv.getTitre());
		Element resolution= document.createElement("Resolution");
		creerAttribut(resolution, "largeur", String.valueOf(fv.getResolution().getLargeur()));
		creerAttribut(resolution, "Hauteur", String.valueOf(fv.getResolution().getHauteur()));
		racineMedia.appendChild(resolution);
		
	}
	
	

}
