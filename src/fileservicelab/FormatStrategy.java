/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Kallie
 */
public interface FormatStrategy {
    public List<LinkedHashMap<String,String>> decodeRecord (String fileData);
    public String encodeRecord(List<LinkedHashMap<String,String>> updatedContent);
    public String encodeSingleRecord(LinkedHashMap<String,String> data);
}
