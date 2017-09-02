
package uc.unidad.cuatro.nb.dataobjects;

import java.util.HashMap;
import java.util.Map;

/**
 * The NaiveBayesKnowledgeBase Object stores all the fields that the classifier
 * learns during training.
 * 
 */
public class NaiveBayesKnowledgeBase {
    /**
     * log priors for log( P(c) )
     */
    private Map<String, Double> logPriors;
    
    /**
     * log likelihood for log( P(x|c) ) 
     */
    private Map<String, Map<String, Double>> logLikelihoods;
    
    public NaiveBayesKnowledgeBase(){
        logPriors = new HashMap<>();
        logLikelihoods = new HashMap<>();
    }
    /**
     * number of training observations
     */
    public int n=0;
    
    /**
     * number of categories
     */
    public int c=0;
    
    /**
     * number of features
     */
    public int d=0;   
    
    

    public Map<String, Double> getLogPriors() {
        return logPriors;
    }

    public void setLogPriors(Map<String, Double> logPriors) {
        this.logPriors = logPriors;
    }

    public Map<String, Map<String, Double>> getLogLikelihoods() {
        return logLikelihoods;
    }

    public void setLogLikelihoods(Map<String, Map<String, Double>> logLikelihoods) {
        this.logLikelihoods = logLikelihoods;
    }
}
