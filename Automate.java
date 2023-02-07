public class Automate {
    private String initialState; 
    private String[] finalStates;
    private Transitions[] transitions;
    private char[] alphabet;

    public Automate(String initialState, String[] finalStates, Transitions[] transitions, char[] alphabet) {
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.transitions = transitions;
        this.alphabet = alphabet;
    }

    public Automate() {
    }

    public boolean appartient(String mot){
        char[] motChar = mot.toCharArray();
        String etatCourant = initialState;
        boolean appartient = false;
        boolean fin = false;
        int i = 0;

        // tant que le mot n'est pas fini et qu'on a pas trouvé de transition
        while(!fin){
            if(i == motChar.length){
                // on vérifie si l'état courant est un état final
                fin = true;
                for(int j = 0; j < finalStates.length; j++){
                    if(etatCourant.equals(finalStates[j])){
                        appartient = true;
                    }
                }
            }else{
                // on cherche une transition à partir de l'état courant avec le symbole lu
                boolean transitionTrouvee = false;
                int j = 0;
                while(!transitionTrouvee && j < transitions.length){
                    // si on trouve une transition, on change l'état courant
                    if(etatCourant.equals(transitions[j].getInitState()) && motChar[i] == transitions[j].getSymbol()){
                        etatCourant = transitions[j].getFinState();
                        transitionTrouvee = true;
                    }
                    j++;
                }
                if(!transitionTrouvee){
                    // si on ne trouve pas de transition, on arrête la boucle
                    fin = true;
                    System.out.println("absence de transition à partir de l’état courant avec le symbole lu");
                }
                i++;
            }
        }
        return appartient;
    }

    public String getInitialState() {
        return initialState;
    }

    public String[] getFinalStates() {
        return finalStates;
    }

    public Transitions[] getTransitions() {
        return transitions;
    }

    public char[] getAlphabet() {
        return alphabet;
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    public void setFinalStates(String[] finalStates) {
        this.finalStates = finalStates;
    }

    public void setTransitions(Transitions[] transitions) {
        this.transitions = transitions;
    }

    public void setAlphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

}



    
