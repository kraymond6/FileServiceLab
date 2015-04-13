/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Kallie
 */
public class TxtFileReader {
    private FormatStrategy formatter;
    private String path;
    
    public TxtFileReader(FormatStrategy formatter, String path){
        this.formatter = formatter;
        this.path = path;
    }
    
    public List<LinkedHashMap<String,String>> readRecords() throws IOException{
        List<Map<String,String>> allRecords = new ArrayList<Map<String,String>>();
        String data = "";
        
        File file = new File(path);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while(line != null){
                data += line + "\n";
                line = in.readLine();
            }
        }
        catch(IOException io){
            try{
                 in.close();       
            }
            catch(Exception e){
                throw new IOException();
        }
    }
       return formatter.decodeRecord(data);
}

    public FormatStrategy getFormatter() {
        return formatter;
    }

    public void setFormatter(FormatStrategy formatter) {
        this.formatter = formatter;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
