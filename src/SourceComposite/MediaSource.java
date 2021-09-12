package SourceComposite;

import Visitor.MediaVisitor;

public abstract class MediaSource {
	private int niveau;
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau=niveau;
	}

	public abstract int getDuree();
	public abstract void setParent(MediaSource parent);
	public String identation() {
		String str ="";
		for(int i =0; i< this.niveau; i++) {
			str+="\t";
		}
		return str;
	}
	public abstract void accept(MediaVisitor visitor);
	public abstract String toString();
}
