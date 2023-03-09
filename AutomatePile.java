import java.io.*;
import java.util.ArrayList;

public class AutomatePile {
    private String initialState; 
    private ArrayList<String> finalStates;
    private ArrayList<Transitions> transitions;
    private ArrayList<Character> alphabet;
    private ArrayList<Character> alphabetPile;

    public AutomatePile() {
        this.initialState = "";
        this.finalStates = new ArrayList<String>();
        this.transitions = new ArrayList<Transitions>();
        this.alphabet = new ArrayList<Character>();
        this.alphabetPile = new ArrayList<Character>();
    }

    public AutomatePile(String initialState, ArrayList<String> finalStates, ArrayList<Transitions> transitions, ArrayList<Character> alphabet, ArrayList<Character> alphabetPile) {
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.transitions = transitions;
        this.alphabet = alphabet;
        this.alphabetPile = alphabetPile;
    }


    public boolean isInAlphabet(char symbol) {
        for (int i = 0; i < alphabet.size(); i++) {
            if (alphabet.get(i) == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean isInAlphabetPile(char symbol) {
        for (int i = 0; i < alphabetPile.size(); i++) {
            if (alphabetPile.get(i) == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean isInFinalStates(String state) {
        for (int i = 0; i < finalStates.size(); i++) {
            if (finalStates.get(i).equals(state)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInStates(String state) {
        for (int i = 0; i < transitions.size(); i++) {
            if (transitions.get(i).getInitState().equals(state) || transitions.get(i).getFinState().equals(state)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInTransitions(String state, char symbol) {
        for (int i = 0; i < transitions.size(); i++) {
            if (transitions.get(i).getInitState().equals(state) && transitions.get(i).getSymbol() == symbol) {
                return true;
            }
        }
        return false;
    }

    public String getInitialState() {
        return initialState;
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    public ArrayList<String> getFinalStates() {
        return finalStates;
    }

    public void setFinalStates(ArrayList<String> finalStates) {
        this.finalStates = finalStates;
    }

    public ArrayList<Transitions> getTransitions() {
        return transitions;
    }

    public void setTransitions(ArrayList<Transitions> transitions) {
        this.transitions = transitions;
    }

    public ArrayList<Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(ArrayList<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public ArrayList<Character> getAlphabetPile() {
        return alphabetPile;
    }

    public void setAlphabetPile(ArrayList<Character> alphabetPile) {
        this.alphabetPile = alphabetPile;
    }
}
