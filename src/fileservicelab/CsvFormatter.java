/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;
import java.util.*;
/**
 *
 * @author Kallie
 */
public class CsvFormatter implements FormatStrategy{
    private boolean header;
    private String delimiter;
    public CsvFormatter(boolean header, String delimiter){
        this.header = header;
        this. delimiter = delimiter;
    }
    @Override
    public List<LinkedHashMap<String,String>> decodeRecord (String fileData){
        List<LinkedHashMap<String,String>> allRecords =
                new ArrayList<LinkedHashMap<String,String>>();
        String[] lines = fileData.split("\\n");
        if (header){
            String[] header = lines[0].split(delimiter);
            for(int i=1; i < lines.length; i++){
                LinkedHashMap<String,String> singleRecord = new LinkedHashMap<String,String>();
                String[] rowData = lines[i].split(delimiter);
                for(int x=0; x<rowData.length; x++){
                    singleRecord.put(header[x], rowData[x]);
                }
                allRecords.add(singleRecord);
            }
            
        }
        else{
            String[] keys = lines[0].split(delimiter);
            for(Integer y=0; y<keys.length; y++){
                keys[y] = y.toString();
            }
            
            for(int i=1; i < lines.length; i++){
                LinkedHashMap<String,String> singleRecord = new LinkedHashMap<String,String>();
                String[] rowData = lines[i].split(delimiter);
                for(int x=0; x<rowData.length; x++){
                    singleRecord.put(keys[x], rowData[x]);
                }
                allRecords.add(singleRecord);
            }
        }
        return allRecords;
    }
    
    @Override
    public String encodeRecord(List<LinkedHashMap<String,String>> updatedContent){
        StringBuilder data = new StringBuilder();
        LinkedHashMap<String,String> headerRecord = null;
        
            headerRecord = updatedContent.get(0);
            Set<String> keys = headerRecord.keySet();
            
            for(Iterator i = keys.iterator(); i.hasNext(); ){
                data.append("\"").append(i.next()).append("\"").append(delimiter);
            }
            data.replace(data.length()-1, data.length(), "\n");
            
            if(!header){
                data = new StringBuilder();
            }
        
            for(LinkedHashMap<String,String> dataRow : updatedContent){
                for(Iterator i = keys.iterator(); i.hasNext();){
                    data.append("\"").append(dataRow.get(i.next().toString())).append("\n").append(delimiter);
                }
                data.replace(data.length()-1, data.length(), "\n");
            }
        return data.toString();
    }
    
    @Override
    public String encodeSingleRecord(LinkedHashMap<String,String> data){
        StringBuilder encodedData = new StringBuilder();
        Set<String> keys = data.keySet();
        for(Iterator i = keys.iterator(); i.hasNext();){
            encodedData.append("\"").append(data.get(i.next())).append("\"").append(delimiter);
        }
        encodedData.replace(encodedData.length()-1, encodedData.length(), "\n");
        return encodedData.toString();
    }

    public boolean isHeader() {
        return header;
    }

    public void setHeader(boolean header) {
        this.header = header;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
    
}
