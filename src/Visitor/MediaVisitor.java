package Visitor;

import SourceComposite.MediaAudio;
import SourceComposite.MediaVideo;
import SourceComposite.SousListeMedia;

public interface MediaVisitor {
	public void visitSousListeMedia(SousListeMedia sl);
	public void visitFichierAudio(MediaAudio fa);
	public void visitFichierVideo(MediaVideo fv);

}
