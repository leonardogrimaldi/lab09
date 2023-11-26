package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String nextString = "";
    /**
     * History of printed strings
     */
    private final List<String> history = new ArrayList<>();
    
    @Override
    public String getNextString() {
        return nextString;
    }

    public void setNextString(String nextString) {
        this.nextString = Objects.requireNonNull(nextString);
    }

    public void printCurrentString() {
        if (nextString.equals("")) {
            throw new IllegalStateException("currentString is unset");
        }
        System.out.println(nextString);
        history.add(nextString);
    }

    public List<String> getHistory() {
        return history;
    }
}