package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * @return a list of all Strings that have been printed using print()
     */
    public List<String> getHistory();

    public void printCurrentString();

    /**
     * Sets the nextString to be printed
     * @param nextString 
     */
    public void setNextString(String nextString);
    
    public String getNextString();
}
