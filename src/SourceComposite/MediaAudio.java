package SourceComposite;

import Visitor.MediaVisitor;

public class MediaAudio extends Media{
	private String nom;
	private String nomArtiste;
	public MediaAudio(String nom){
		this.nom = nom;
		
	}
	public MediaAudio(int duree, String nom, String artiste) {
		this.setDuree(duree);
		this.nom=nom;
		this.nomArtiste = artiste;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomArtiste() {
		return nomArtiste;
	}

	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}

	@Override
	public void accept(MediaVisitor visitor) {
		visitor.visitFichierAudio(this);
		
	}
	public String toString() {
		return this.nom +" "+this.getDuree()+" "+ this.nomArtiste+"\n";
	}

}
