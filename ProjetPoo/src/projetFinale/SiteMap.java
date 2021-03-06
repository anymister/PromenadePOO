package projetFinale;



import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class SiteMap {
   public String s;
	 
	/**
	 * Constructeur
	 * @param b chemin du r�pertoire
	 * @param v analyse des sous dossiers
	 * @param stt le chemin ou se trouve sitemap.xml creer deja precedement
	 */
	   
	    public SiteMap(String b,String v,String stt) {
	    	
	       this.s=stt;
	    	
	        File f=new File(b);
	        
	     	 String c=getFormatedDate(f);
	     
	     	 CreationDuFichier(c,v);
	       }
		
	   /**
	    * 
	    * @return le chemin ou se trouve sitemap.xml
	    */

public String getS() {
		return s;
	}


/**
 * initialiser ou modifier le chemin ou se trouve sitemap.xml
 * @param s le nouveau chemin
 */
	public void setS(String s) {
		this.s = s;
	}



/**
 * extraire la date de derniere modification du fichier
 * @param f fichier quand veux lui soustraire la date de derniere modif
 * @return sdf.format(d) la date derniere modification du fichier entrer
 */
	    public String getFormatedDate(File f) {
			
		        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // 
		        Date d = new Date(f.lastModified());
		       
		        return sdf.format(d);
		}
	   
	    /**
	     *   le texte � ecrire sur le fichier XML
	     * @param v la date derniere modif
	     
	     * @param a le nom du fichier
	     */
	public void CreationDuFichier(String v,String a) {
			
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(getS(), true));
				
			
					
					writer.write(	"   <url>\r\n" + 
							"\r\n" + 
							"<loc>");
					writer.write("http://www.promenade.com/");
					writer.write(a);
				
					writer.write("</loc>\r\n" + 
							"\r\n" + 
							" <lastmod>");
					
					
					writer.write(v);
					
					writer.write("</lastmod>\r\n" + 
							 
							"\r\n" + 
							"<frequence> Monthly </frequence>"+
							"      <priority> 0.5 </priority>\r\n" + 
							
							"\r\n" + 
							"   </url>\r\n");
					
					writer.close();
					
					}
					catch (IOException e)
					{
				
				e.printStackTrace();
					}
		}
		
	}         





	

