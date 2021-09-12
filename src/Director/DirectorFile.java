package Director;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Builder.MediaBuilderFile;
import SourceComposite.MediaSource;
import SourceComposite.SousListeMedia;

public class DirectorFile {
	MediaBuilderFile builder;
	public DirectorFile(MediaBuilderFile builder) {
		this.builder = builder;
	}
	
	public void importer(String name,SousListeMedia list) {
		File file = new File(name);
		if (file.isFile()) {
			MediaSource media=null;
			String contenu[] = this.lireFile(file);
			/*System.out.println("testt contenu 0"+contenu[0]);
			System.out.println(contenu[1]);
			System.out.println(contenu[2]);
			System.out.println("extension file "+getExtension(file).equals("mta"));*/
			if(getExtension(file).equals("mta")) {
				//System.out.println("extension mta");
				media= this.builder.buildAudio(contenu);	
			}
			else if(getExtension(file).equals("mtv")){
				media=builder.buildVideo(contenu);
			}
			list.ajouter(media);		
		}
		if(file.isDirectory()) {
			SousListeMedia sousliste = builder.buildSousList(file.getName());
			list.ajouter(sousliste);
			for(File f :file.listFiles()) {
				//System.out.println("repertoire file "+f.getName());
			importer(f.getPath(), sousliste);
			}
			
		}
		
	}
	  private String getExtension(File f) {
		    String filename = f.getName();
		    int i = filename.lastIndexOf('.');
		    if (i>0 && i<filename.length()-1) 
		    	return filename.substring(i+1).toLowerCase();
		    return null;
	   }
	  public String[] lireFile(File f){
			String contenu[]= new String[5] ;
			try {
				BufferedReader in = new BufferedReader(new FileReader(f));
				String line;
				int i = 0;
				try {
					while ((line = in.readLine()) != null)
					{
						// recupérer le contenu du fichier
						contenu[i]= line;
						i+=1;
						
					}
					in.close();
			
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} 
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return contenu;
		}


}
