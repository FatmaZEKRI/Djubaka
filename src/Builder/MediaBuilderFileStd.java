package Builder;



import SourceComposite.MediaAudio;
import SourceComposite.MediaVideo;
import SourceComposite.Resolution;
import SourceComposite.SousListeMedia;

public class MediaBuilderFileStd implements MediaBuilderFile {
	public MediaBuilderFileStd() {
		
	}


	@Override
	public MediaVideo buildVideo(String[] contenu) {
		String[] inf = contenu[2].split("x");
		Resolution r = new Resolution(Integer.parseInt(inf[0]), Integer.parseInt(inf[0]));
		
		return new MediaVideo(Integer.parseInt(contenu[0]), contenu[1],r);
	}

	@Override
	public MediaAudio buildAudio(String[] contenu ) {
		//System.out.println("Builder: buildeAudio");
		MediaAudio m =new MediaAudio(Integer.parseInt(contenu[0]), contenu[1],contenu[2]);
		
		return m;
	}

	@Override
	public SousListeMedia buildSousList(String filepath) {
		
		return new SousListeMedia(filepath);
	}

}
