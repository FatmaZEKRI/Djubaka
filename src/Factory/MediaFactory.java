package Factory;

import SourceComposite.MediaAudio;
import SourceComposite.MediaVideo;
import SourceComposite.MediaSource;
import SourceComposite.SousListeMedia;

public interface MediaFactory {
	public SousListeMedia creerSousListeMedia(String name);
	public MediaAudio creerFichierAudio(String name);
	public MediaVideo creerFichierVideo(String name);
}
