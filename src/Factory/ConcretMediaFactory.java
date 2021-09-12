package Factory;

import SourceComposite.MediaAudio;
import SourceComposite.MediaVideo;
import SourceComposite.MediaSource;
import SourceComposite.SousListeMedia;

public class ConcretMediaFactory implements MediaFactory {

	@Override
	public SousListeMedia creerSousListeMedia(String name) {

		return new SousListeMedia(name);
	}

	@Override
	public MediaAudio creerFichierAudio(String name) {
		
		return new MediaAudio(name);
	}

	@Override
	public MediaVideo creerFichierVideo(String name) {
		return new MediaVideo(name);
	}


}
