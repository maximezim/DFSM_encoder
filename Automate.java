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
    // symbole n’appartenant pas à l’alphabet de l’automate ; absence de transition à partir de l’état courant avec le symbole lu ; fin du mot avant d’atteindre un état fina

    public boolean appartient(String mot) {
        char state = initialState;
        for (int i = 0; i < mot.length(); i++) {
            char symbol = mot.charAt(i);
            if (!isInAlphabet(symbol)) {
                System.out.println("Le symbole " + symbol + " n'appartient pas à l'alphabet de l'automate");
                return false;
            }
            if (!isInTransitions(state, symbol)) {
                System.out.println("Absence de transition depuis l'état " + state + "avec le symbole : " + symbol);
                return false;
            }
            state = nextState(state, symbol);
        }
        if (!isFinalState(state)) {
            System.out.println("Le mot se finit avant d'atteindre un état final");
            return false;
        }
        return true;
    }

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

    public boolean isInAlphabet(char symbol) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == symbol) {
                return true;
            }
        }
        return false;
    }
    public boolean isInTransitions(char state, char symbol) {
        for (int i = 0; i < transitions.length; i++) {
            if (transitions[i].getFinState() == state && transitions[i].getSymbol() == symbol) {
                return true;
            }
        }
        return false;
    }

    public char nextState(char state, char symbol) {
        for (int i = 0; i < transitions.length; i++) {
            if (transitions[i].getFinState() == state && transitions[i].getSymbol() == symbol) {
                return transitions[i].getFinState();
            }
        }
        return ' ';
    }

    public boolean isFinalState(char state) {
        for (int i = 0; i < finalStates.length; i++) {
            if (finalStates[i] == state) {
                return true;
            }
        }
        return false;
    }
}

class test {
    public static void main(String[] args) {
        char[] alphabet = {'a', 'b'};
        char[] finalStates = {'q'};
        Transitions[] transitions = {new Transitions('q0', 'q1', 'a'), new Transitions('q1', 'q2', 'b')};
        Automate automate = new Automate('q0', finalStates, transitions, alphabet);
        System.out.println(automate.appartient("ab"));
    }
}