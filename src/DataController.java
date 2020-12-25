import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.DocFlavor.STRING;


public class DataController {
	static HashMap<String, String> slangMap;
	
	public DataController() {
		slangMap = new HashMap<String, String>();
		GetSlangMap("data.txt");
		
	}
	
	public boolean CheckAcccount(String acc, String pass) {
		if(!slangMap.containsKey(acc)) return false;
		else if (!slangMap.get(acc).equals(pass)) return false;
		return true;
	}
	
	public static void GetSlangMap(String url) {
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
            
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
	
	public static void Append_to_file(String s, String url) {
        try {
            File file = new File(url);
            FileWriter fr = new FileWriter(file, true);

            try {
                fr.write(s);
            } catch (Exception e) {
                System.out.println("cant write file");
            }finally{
                fr.close();
            }
        }catch(Exception e){
            System.out.println("cant open file");
        }
    }
	
    public static int Add_slang_word(String slang_key, String def_value) {
	    if(slangMap.containsKey(slang_key)){
	        return 1;
	    }else{
	        slangMap.put(slang_key, def_value);
	        Append_to_file(slang_key + "`" + def_value + "\n", "data.txt");
	        System.out.println("!!! Add new slangword successfully !!!");
	        return 0;
	    }
    }	
}

