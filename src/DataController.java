import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.DocFlavor.STRING;


public class DataController {
	static HashMap<String, String> slangMap;
	
	public DataController() {
		slangMap = GetSlangMap("data.txt");
		
	}
	
	public boolean CheckAcccount(String acc, String pass) {
		if(!slangMap.containsKey(acc)) return false;
		else if (!slangMap.get(acc).equals(pass)) return false;
		return true;
	}
	
	public static HashMap<String, String> GetSlangMap(String url) {
        HashMap<String, String> slangMap = new HashMap<String, String>();
		try{
            File file = new File(url);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            
            String tmp = "error";
            String[] strSplit;
            
            try {
                tmp = reader.readLine();
                while (tmp != null) {
                    strSplit = tmp.split("`");
                    slangMap.put(strSplit[0], strSplit[1]);
                    tmp = reader.readLine();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DataController.class.getName())
                                .log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DataController.class.getName())
                                .log(Level.SEVERE, null, ex);
            } finally {
                try {
                    reader.close();
                    // file.close();
                } catch (IOException ex) {
                    Logger.getLogger(DataController.class.getName())
                                    .log(Level.SEVERE, null, ex);
                }
            }

            return slangMap;
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
		
        return slangMap;
    }
}

