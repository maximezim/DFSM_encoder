import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
                    if (pile.isEmpty()) {
                        appartient = true;
                    }
                    else {
                        System.out.println("Pile non vide");
                    }
                }else{
                    System.out.println("\nEtat final non atteint");
                }
            }else{
                if(isInTransitions(etat, mot.charAt(i))){
                    for (int j = 0; j < transitionsPile.size(); j++) {
                        if(transitionsPile.get(j).getInitState().equals(etat) && transitionsPile.get(j).getSymbol() == mot.charAt(i)){
                            etat = transitionsPile.get(j).getFinState();
                            if (transitionsPile.get(j).getPrecedent() != 'Z') {
                                if (!pile.isEmpty()){
                                    if (pile.peek() == transitionsPile.get(j).getPrecedent()) {
                                        pile.pop();
                                    }
                                }
                                else {
                                    System.out.println("\nPile non conforme");
                                    fin = true;
                                }
                            }
                            else {
                                for (char c : transitionsPile.get(j).getPile().toCharArray()) {
                                    if (c != 'Z' && c != 'e')
                                    pile.push(c);
                                }
                            }

                        }
                    }
                    i++;
                }else{
                    fin = true;
                    System.out.println("\nTransition non existante");
                }
            }
        }
        return appartient;
    }

    public AutomatePile(String nomDeFichier) throws IOException {
        finalStates = new ArrayList<String>();
        transitionsPile = new ArrayList<TransitionsPile>();
        alphabet = new ArrayList<Character>();    
        ArrayList<Character> alphabetPile = new ArrayList<Character>();
        pile = new Pile();
                      
        File doc = new File(nomDeFichier);
        doc.createNewFile();
        FileReader freader = new FileReader(doc);
        char [] fichierTab = new char[(int) doc.length()];
        freader.read(fichierTab);
        freader.close();
        String fichierString = new String(fichierTab);
        String[] lines = fichierString.split("\n");
        int cpt = 0;

        for (String line : lines) {
            if(line.contains("#")) cpt++;
            else {
                switch(cpt) {
                    case 1:
                        alphabet.add(line.charAt(0));
                        break; 
                        
                    case 2:
                        alphabetPile.add(line.charAt(0));
                        break;

                    case 4:
                        initialState = line.substring(0, line.length() - 1);
                        break;

                    case 5:
                        finalStates.add(line.substring(0, line.length() - 1));
                        break;

                    case 6:
                        pile.push(line.charAt(0));
                        break;

                    case 7:
                        int cpt1 = 1;
                        String etatInit = new String();
                        String etatFin = new String();
                        char symbol = ' ';
                        char pileInit = ' ';
                        String pileFin = new String();

                        for (char caract : line.toCharArray()) {
                            
                            if (caract == ' ' || caract == '\r' || caract == ',') cpt1++;
                            else {
                                switch(cpt1) {
                                    case 1:
                                        etatInit += caract;
                                        break;

                                    case 2:
                                        symbol = caract;
                                        break;

                                    case 3:
                                        pileInit = caract;
                                        break;

                                    case 5:
                                        pileFin += caract;
                                        break;

                                    case 6:
                                        etatFin += caract;
                                        break;

                                    default:
                                        break;
                                }
                            }
                        }
                        pile.setAlphabetPile(alphabetPile);
                        transitionsPile.add(new TransitionsPile(etatInit, etatFin, symbol, pileInit, pileFin));
                        break;

                    default:
                        break;
                }  
            }
        }
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
        transitions.add(new TransitionsPile("q0", "q1", 'a', 'Z', "A"));
        transitions.add(new TransitionsPile("q1", "q1", 'b', 'A', "e"));
        transitions.add(new TransitionsPile("q1", "q1", 'a', 'A', "e"));

        automatePile.setTransitionsPile(transitions);

        System.out.println("ab appartient ? : " + automatePile.appartient("ab"));
        System.out.println("aa appartient ? : " + automatePile.appartient("aa"));
        System.out.println("aba appartient ? : " + automatePile.appartient("aba"));
    }
}