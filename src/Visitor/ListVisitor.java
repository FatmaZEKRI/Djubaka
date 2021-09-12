package Visitor;

import SourceComposite.MediaAudio;
import SourceComposite.MediaVideo;
import SourceComposite.MediaSource;
import SourceComposite.SousListeMedia;

//visitreu pour lister tous les types de media
public class ListVisitor implements MediaVisitor {

	@Override
	public void visitSousListeMedia(SousListeMedia sl) {
		int i = 0;
		String str =" "+sl.getNom()+" Durée: " +sl.getDuree();
		System.out.println(str);
		for(MediaSource ms : sl.getList()) {
			i+=1;
			System.out.print(ms.identation()+i+" ");ms.accept(this);
			
		}
	}

	@Override
	public void visitFichierAudio(MediaAudio fa) {
		System.out.println(fa.getNom()+" artiste: "+fa.getNomArtiste()+ " Durée: "+ fa.getDuree());
		
	}

	@Override
	public void visitFichierVideo(MediaVideo fv) {
		System.out.println("Titre: "+fv.getTitre()+" "+fv.getResolution()+" Duree: " +fv.getDuree());
		
	}
	

}
