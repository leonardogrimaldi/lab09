package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String currentString = "";
    private String nextString = "";
    /**
     * History of printed strings
     */
    private final List<String> history = new ArrayList<>();

    @Override
    public void print(String input) {
        System.out.println(input);
        history.add(input);
    }

    public String getNextString() {
        return nextString;
    }

    public void setNextString(String nextString) {
        this.nextString = Objects.requireNonNull(nextString);
    }

    public void printCurrentString() {
        if (currentString.equals("")) {
            throw new IllegalStateException("currentString is unset");
        }
        print(currentString);
    }

    public List<String> getHistory() {
        return history;
    }

}
