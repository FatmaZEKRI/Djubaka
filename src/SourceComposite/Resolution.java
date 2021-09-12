package SourceComposite;

public class Resolution {
	private int hauteur;
	private int largeur;
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public Resolution(int hauteur, int largeur) {
		super();
		this.hauteur = hauteur;
		this.largeur = largeur;
	}
	@Override
	public String toString() {
		return "Resolution [" + hauteur + "x"+ largeur + "]";
	}
	

}
