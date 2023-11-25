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
    private final List<String> printed = new ArrayList<>();

    @Override
    public void print(String input) {
        System.out.println(input);
        printed.add(input);
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

    public void printNextString() {

    }

    public List<String> printHistory() {

        return null;
    }

}
