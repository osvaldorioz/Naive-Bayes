
package uc.unidad.cuatro.nb.dataobjects;

import java.util.HashMap;
import java.util.Map;

/**
 * The Document Object represents the texts that we use for training or 
 * prediction as a bag of words.
 * 
 */
public class Document {
    
    private Map<String, Integer> tokens = new HashMap<>();   
    private String category;

    public Map<String, Integer> getTokens() {
        return tokens;
    }

    public void setTokens(Map<String, Integer> tokens) {
        this.tokens = tokens;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
   
}
