package SourceComposite;

import java.util.ArrayList;
import java.util.List;

import Visitor.MediaVisitor;

public class SousListeMedia extends MediaSource {
	private String nom;
	private List<MediaSource>list;
	private MediaSource parent;
	
	public SousListeMedia(String nom) {
		this.setNom(nom);
		this.setList(new ArrayList<MediaSource>());
	}
	public void ajouter(MediaSource ms) {
		if(!this.list.contains(ms) && (! this.equals(ms))) {
			int niveau = this.getNiveau()+1;
			ms.setNiveau(niveau);
			ms.setParent(this);
			this.list.add(ms);
		}
		
	}
	public void supprimer(MediaSource ms) {
		this.list.remove(ms);	
	}
	public String getNom() {
		return nom;
	}
	public MediaSource entrer(int num) {
		MediaSource ms = this.list.get(num);
		
		return ms;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<MediaSource> getList() {
		return list;
	}
	public void setList(List<MediaSource> list) {
		this.list = list;
	}
	public MediaSource getParent() {
		return parent;
	}
	public void setParent(MediaSource parent) {
		this.parent = parent;
	}
	@Override
	public int getDuree() {
		int duree = 0;
		for(MediaSource s : this.list) {
			duree= duree+ s.getDuree();
		}
		return  duree;
	}

	@Override
	public void accept(MediaVisitor visitor) {
		visitor.visitSousListeMedia(this);
		
	}
	public String toString() {
		String list=null ;
		for(MediaSource media : this.list) {
			list= list+" "+media.toString();			
		}
		return list;
	}



}
