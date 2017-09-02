
package uc.unidad.cuatro.nb.main;

import uc.unidad.cuatro.nb.classifiers.NaiveBayes;
import uc.unidad.cuatro.nb.dataobjects.NaiveBayesKnowledgeBase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaiveBayesExample {

    /**
     * Reads the all lines from a file and places it a String array. In each 
     * record in the String array we store a training example text.
     * 
     * @param url
     * @return
     * @throws IOException 
     */
    public static String[] readLines(URL url) throws IOException {

        Reader fileReader = new InputStreamReader(url.openStream(), Charset.forName("UTF-8"));
        List<String> lines;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines.toArray(new String[lines.size()]);
    }
    
    /**
     * Main method
     * 
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public void __main__(String[] args) throws IOException {
        
        Map<String, URL> trainingFiles = new HashMap<>();
        trainingFiles.put("Русский язык", NaiveBayesExample.class.getResource("/diccionarios/ruso"));
        trainingFiles.put("English", NaiveBayesExample.class.getResource("/diccionarios/english"));
        trainingFiles.put("French", NaiveBayesExample.class.getResource("/diccionarios/french"));
        trainingFiles.put("German", NaiveBayesExample.class.getResource("/diccionarios/deutch"));
        trainingFiles.put("Español", NaiveBayesExample.class.getResource("/diccionarios/español"));
        
        //loading examples in memory
        Map<String, String[]> trainingExamples = new HashMap<>();
        for(Map.Entry<String, URL> entry : trainingFiles.entrySet()) {
            trainingExamples.put(entry.getKey(), readLines(entry.getValue()));
        }
        
        //train classifier
        NaiveBayes nb = new NaiveBayes();
        nb.setChiCuadradaCriticalValue(6.63); //0.01 pvalue
        nb.train(trainingExamples);
        
        //get trained classifier knowledgeBase
        NaiveBayesKnowledgeBase knowledgeBase = nb.getKnowledgeBase();        
        
        //Use classifier
        nb = new NaiveBayes(knowledgeBase);
        String exampleEn = "this all right";
        String outputEn = nb.predict(exampleEn);
        System.out.format("La oración \"%s\" está escrita en \"%s\".%n", exampleEn, outputEn);
        
        String exampleFr = "Je suis Français";
        String outputFr = nb.predict(exampleFr);
        System.out.format("La oración \"%s\" está escrita en \"%s\".%n", exampleFr, outputFr);
        
        String exampleDe = "Ich bin Deutsch";
        String outputDe = nb.predict(exampleDe);
        System.out.format("La oración \"%s\" está escrita en \"%s\".%n", exampleDe, outputDe);
        
        String exampleEs = "El bienestar social";
        String outputEs = nb.predict(exampleEs);
        System.out.format("La oración \"%s\" está escrita en \"%s\".%n", exampleEs, outputEs);
        
        String exampleRs = "Техническое и профессиональное";
        String outputRs = nb.predict(exampleRs);
        System.out.format("La oración \"%s\" está escrita en \"%s\".%n", exampleRs, outputRs);
       
    }
    
}
