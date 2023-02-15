import java.io.*;
import java.util.ArrayList;

public class Automate {
    private String initialState; 
    private ArrayList<String> finalStates;
    private ArrayList<Transitions> transitions;
    private ArrayList<Character> alphabet;

    public Automate() {
        this.finalStates = new ArrayList<>();
        this.transitions = new ArrayList<>();
        this.alphabet = new ArrayList<>();
    }

    public Automate(String initialState, ArrayList<String> finalStates, ArrayList<Transitions> transitions, ArrayList<Character> alphabet) {
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.transitions = transitions;
        this.alphabet = alphabet;
    }

    
    public boolean appartient(String mot){
        String etat = initialState;
        // return true if the word is accepted by the automaton
        //return false otherwise
        // si c'est faux, donner la raison:
        // symbole n’appartenant pas à l’alphabet de l’automate ; absence de transition à partir de l’état courant avec le symbole lu ; fin du mot avant d’atteindre un état final
        boolean appartient = false;
        boolean fin = false;
        int i = 0;
        while(!fin){
            if(i == mot.length()){
                fin = true;
                System.out.println(etat);
                // System.out.println(isInFinalStates(etat));
                if(isInFinalStates(etat)) appartient = true;
                else System.out.println("fin du mot avant d’atteindre un état final");
            }
            else{
                char val = mot.charAt(i);
                System.out.println("val :"+val);
                if(isInAlphabet(val)){
                    System.out.println("etat courant:" + etat + " symbole lu: " + val);
                    if(isInTransitions(etat, val)){
                        etat = getFinState(etat, val);
                        // System.out.println("nouvel etat: " + etat + "\n");
                        // sysout de la transition
                        // System.out.println("transition: " + etat + " -> " + mot.charAt(i) + " -> " + getFinState(etat, mot.charAt(i)) + "\n");
                        // si ce n'est pas l'état final, on enlève le dernier caractère de l'état
                        // etat = etat.substring(0, etat.length() - 1);
                        i++;
                    }
                    else{
                        fin = true;
                        System.out.println("absence de transition à partir de l’état courant avec le symbole lu");
                    }
                }
                else{
                    fin = true;
                    System.out.println("symbole n’appartenant pas à l’alphabet de l’automate");
                }
            }
        }
        return appartient;
    }

    public boolean isInAlphabet(char c) {
        for (int i = 0; i < alphabet.size(); i++) {
            if (alphabet.get(i) == c) return true;
        }
        return false;
    }

    public boolean isInTransitions(String s, char c) {
        for (int i = 0; i < transitions.size(); i++) {
            if (transitions.get(i).getInitState().equals(s) && transitions.get(i).getSymbol() == c) return true;
        }
        return false;
    }

    public boolean isInFinalStates(String s) {
        for (String elem : finalStates) {
            if (elem.equals(s)) return true;
        }
        return false;
    }

    public String getFinState(String s, char c) {
        for (int i = 0; i < transitions.size(); i++) {
            if (transitions.get(i).getInitState().equals(s) && transitions.get(i).getSymbol() == c) return transitions.get(i).getFinState();
        }
        return null;
    }

    public Automate(String nomDeFichier) throws IOException {
        finalStates = new ArrayList<String>();
        transitions = new ArrayList<Transitions>();
        alphabet = new ArrayList<Character>();        
        
        File doc = new File(nomDeFichier);
        doc.createNewFile();
        FileReader freader = new FileReader(doc);
        char [] i = new char[(int) doc.length()];
        freader.read(i);
        freader.close();

        String fichierString = new String(i);

        String[] lines = fichierString.split("\n");
        int cpt = 0;

        for (String line : lines) {
            if(line.contains("#")) cpt++;
            else {
                switch(cpt) {
                    case 1:
                        alphabet.add(line.charAt(0));
                        break;   

                    case 3:
                        initialState = line.substring(0, line.length() - 1);
                        break;

                    case 4:
                        finalStates.add(line.substring(0, line.length() - 1));
                        break;

                    case 5:
                        int cpt1 = 1;
                        String etatInit = new String();
                        String etatFin = new String();
                        char symbol = ' ';

                        for (char j : line.toCharArray()) {
                            
                            if (j == ' ' || j == '\r') cpt1++;
                            else {
                                switch(cpt1) {
                                    case 1:
                                        etatInit += j;
                                        break;

                                    case 2:
                                        symbol = j;
                                        break;

                                    case 3:
                                        etatFin += j;
                                        break;

                                    default:
                                        break;
                                }
                            }
                        }
                        transitions.add(new Transitions(etatInit, etatFin, symbol));
                        break;

                    default:
                        break;
                }  
            }
        }
    }

    // getters and setters
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


    public static void main(String[] args) throws IOException {
        Automate a = new Automate("automate1.txt");
        System.out.println("Etat initial: " + a.getInitialState());
        ArrayList<String> finalStates = a.getFinalStates();
        for (String s : finalStates) {
            System.out.println("Etat final: " + s);
        }

        System.out.println(a.appartient("ab"));
    }
} 
