package Builder;

import org.w3c.dom.Element;

import SourceComposite.MediaAudio;
import SourceComposite.MediaVideo;
import SourceComposite.SousListeMedia;

public interface MediaBuilderXML extends MediaBuilder{
	public MediaVideo buildVideo(Element element);
	public MediaAudio buildAudio(Element element);
	public SousListeMedia buildSousList(Element element);

}
