import java.util.ArrayList;

public class AutomatePile extends Automate{
    private ArrayList<TransitionsPile> transitionsPile;
    private Pile pile;

    public AutomatePile() {
        super();
        this.transitionsPile = new ArrayList<TransitionsPile>();
        this.pile = new Pile();
    }

    public AutomatePile(String initialState, ArrayList<String> finalStates, ArrayList<Transitions> transitions, ArrayList<Character> alphabet, ArrayList<Character> alphabetPile) {
        super(initialState, finalStates, transitions, alphabet);
        this.pile = new Pile();
        this.transitionsPile = new ArrayList<TransitionsPile>();
    }

    public boolean isInStates(String state) {
        for (int i = 0; i < transitions.size(); i++) {
            if (transitions.get(i).getInitState().equals(state) || transitions.get(i).getFinState().equals(state)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInTransitions(String s, char c) {
        for (int i = 0; i < transitionsPile.size(); i++) {
            if (transitionsPile.get(i).getInitState().equals(s) && transitionsPile.get(i).getSymbol() == c) {
                return true;
            }
        }
        return false;
    }

    public boolean appartient(String mot) {
        this.pile = new Pile();
        String etat = initialState;
        boolean appartient = false;
        boolean fin = false;
        int i = 0;
        while(!fin){
            // System.out.println("Etat : " + etat + " | Pile : " + pile.toString() + " | Mot : " + mot.substring(i));
            if(i == mot.length()){
                fin = true;
                if(isInFinalStates(etat)){
                    appartient = true;
                }
            }else{
                if(isInTransitions(etat, mot.charAt(i))){
                    for (int j = 0; j < transitionsPile.size(); j++) {
                        if(transitionsPile.get(j).getInitState().equals(etat) && transitionsPile.get(j).getSymbol() == mot.charAt(i)){
                            etat = transitionsPile.get(j).getFinState();
                            if(transitionsPile.get(j).getPile() != null){
                                pile.push(transitionsPile.get(j).getPile());
                            }else{
                                pile.pop();
                            }
                        }
                    }
                    i++;
                }else{
                    fin = true;
                }
            }
        }
        return appartient;
    }

    public void setTransitionsPile(ArrayList<TransitionsPile> transitionsPile) {
        this.transitionsPile = transitionsPile;
    }
}



class Essai{
    public static void main(String[] args) {
        AutomatePile automatePile = new AutomatePile();
        automatePile.setInitialState("q0");
        ArrayList<String> finalStates = new ArrayList<String>();
        finalStates.add("q1");
        automatePile.setFinalStates(finalStates);

        ArrayList<TransitionsPile> transitions = new ArrayList<TransitionsPile>();
        transitions.add(new TransitionsPile("q0", "q0", 'a', 'A'));
        transitions.add(new TransitionsPile("q0", "q1", 'b', null));

        automatePile.setTransitionsPile(transitions);

        System.out.println("ab appartient ? : " + automatePile.appartient("ab"));
        System.out.println("aa appartient ? : " + automatePile.appartient("aa"));


    }
}