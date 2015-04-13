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
public interface ReaderStrategy {
    public List<LinkedHashMap<String,String>> readRecords() throws IOException;
    public FormatStrategy getFormatter();
    public void setFormatter(FormatStrategy formatter);
    public String getPath();
    public void setPath(String path);
}
