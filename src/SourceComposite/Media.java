package SourceComposite;

public abstract class Media extends MediaSource {
	private int duree;
	private MediaSource parent; 
	
	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}
	public MediaSource getParent() {
		return this.parent;
	}
	public void setParent(MediaSource parent) {
		this.parent=parent;
	}
	
}
