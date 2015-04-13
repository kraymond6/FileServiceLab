/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;


/**
 *
 * @author Kallie
 */
public class TxtFileWriter {
    private FormatStrategy formatter;
    private String path;
    
    public TxtFileWriter(FormatStrategy formatter, String path){
    this.formatter = formatter;
    this.path = path;
    
    }
    public void update(List<LinkedHashMap<String,String>> updatedContent) throws IOException{
        File file = new File(path);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));
        
        String data = formatter.encodeRecord(updatedContent);
        out.print(data);
        out.close();
    }
    
    public void addRecords(List<LinkedHashMap<String,String>> data) throws IOException{
        File file = new File(path);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        
        String newData = formatter.encodeRecord(data);
        out.print(newData);
        out.close();
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
