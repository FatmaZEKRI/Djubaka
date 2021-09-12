package Builder;

import SourceComposite.MediaAudio;
import SourceComposite.MediaVideo;
import SourceComposite.SousListeMedia;

public interface MediaBuilder {
	public MediaVideo buildVideo();
	public MediaAudio buildAudio();
	public SousListeMedia buildSousList();

}
