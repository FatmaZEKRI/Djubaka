package SourceComposite;

import Visitor.MediaVisitor;

public class MediaVideo extends Media {
	 private String titre;
	 private Resolution resolution;
	 public MediaVideo(String titre) {
		 this.titre=titre;
		 
	 }
	 public MediaVideo(int duree, String titre, Resolution resolution) {
		 this.titre=titre;
		 this.setDuree(duree);
		 this.resolution=resolution;
	 }


	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Resolution getResolution() {
		return resolution;
	}

	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}



	@Override
	public void accept(MediaVisitor visitor) {
		visitor.visitFichierVideo(this);
		
	}
	public String toString() {
		return this.titre +" "+this.getDuree()+" "+ this.resolution.toString()+"\n";
	}


}
