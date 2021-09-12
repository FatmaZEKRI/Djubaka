package Builder;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;

import SourceComposite.MediaAudio;
import SourceComposite.MediaVideo;
import SourceComposite.SousListeMedia;

public interface MediaSaveXML {
	public Element creerVideoElement(MediaVideo video);
	public Element creerAudioElement(MediaAudio audio);
	public Element creerListElement(SousListeMedia list);
	public Attr creerAttribut(Element element, String nom, String valeur);

}
