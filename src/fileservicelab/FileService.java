/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Kallie
 */
public class FileService {
    private ReaderStrategy fileReader;
    private WriterStrategy fileWriter;
    private String readPath;
    private String writePath;
    private FormatStrategy readFormat;
    private FormatStrategy writeFormat;
    
    public FileService(ReaderStrategy fileReader, WriterStrategy fileWriter){
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.writePath = fileWriter.getPath();
        this.readPath = fileReader.getPath();
        this.readFormat = fileReader.getFormatter();
        this.writeFormat = fileWriter.getFormatter();
        
    }
    
    public List<LinkedHashMap<String,String>> getRecords() throws IOException{
        return fileReader.readRecords();
    }
    
    public void overwriteRecords(List<LinkedHashMap<String,String>> newData) throws IOException{
        fileWriter.update(newData);
    }
    
    public void addRecords(List<LinkedHashMap<String,String>> newData) throws IOException{
        fileWriter.addRecords(newData);
    }
}
