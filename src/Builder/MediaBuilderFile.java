package Builder;



import SourceComposite.MediaAudio;
import SourceComposite.MediaVideo;
import SourceComposite.SousListeMedia;

public interface MediaBuilderFile{
	public MediaVideo buildVideo(String[] contenu );
	public MediaAudio buildAudio(String[] contenu );
	public SousListeMedia buildSousList(String filepath);
}
