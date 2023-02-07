public class Automate {
    private char initialState; 
    private char[] finalStates;
    private Transitions[] transitions;
    private char[] alphabet;

    public Automate(char initialState, char[] finalStates, Transitions[] transitions, char[] alphabet) {
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.transitions = transitions;
        this.alphabet = alphabet;
    }

    public Automate() {
    }
    
    // public boolean appartient (String mot); 
    // //returns true if the word is recognized
    // // it must return the reason why the word is not recognized

    // public Automate(String nomDeFichier); //constructor based on a file


    // getters and setters
    public char getInitialState() {
        return initialState;
    }

    public void setInitialState(char initialState) {
        this.initialState = initialState;
    }

    public char[] getFinalStates() {
        return finalStates;
    }

    public void setFinalStates(char[] finalStates) {
        this.finalStates = finalStates;
    }

    public Transitions[] getTransitions() {
        return transitions;
    }

    public void setTransitions(Transitions[] transitions) {
        this.transitions = transitions;
    }

    public char[] getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

}