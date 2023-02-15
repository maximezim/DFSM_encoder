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

    public Automate(String nomDeFichier) throws IOException {
        finalStates = new ArrayList<String>();
        transitions = new ArrayList<Transitions>();
        alphabet = new ArrayList<Character>();        
        
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

    // initial state
    public String getInitialState() {
        return initialState;
    }

    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }


    // final states
    public ArrayList<String> getFinalStates() {
        return finalStates;
    }

    public void setFinalStates(ArrayList<String> finalStates) {
        this.finalStates = finalStates;
    }


    // transitions
    public ArrayList<Transitions> getTransitions() {
        return transitions;
    }

    public void setTransitions(ArrayList<Transitions> transitions) {
        this.transitions = transitions;
    }


    // alphabet
    public ArrayList<Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(ArrayList<Character> alphabet) {
        this.alphabet = alphabet;
    }

    //--------------------------------------------------------------

    // methods

    // vérifie si les caractères sont dans l'alphabet
    public boolean isInAlphabet(char c) {
        for (int i = 0; i < alphabet.size(); i++) {
            if (alphabet.get(i) == c) return true;
        }
        return false;
    }

    // vérifie si la transition est dans la liste des transitions
    public boolean isInTransitions(String s, char c) {
        for (int i = 0; i < transitions.size(); i++) {
            if (transitions.get(i).getInitState().equals(s) && transitions.get(i).getSymbol() == c) return true;
        }
        return false;
    }

    // vérifie si l'état est dans la liste des états finaux
    public boolean isInFinalStates(String s) {
        for (String elem : finalStates) {
            if (elem.equals(s)) return true;
        }
        return false;
    }

    // retourne l'état final de la transition
    public String getFinState(String s, char c) {
        for (int i = 0; i < transitions.size(); i++) {
            if (transitions.get(i).getInitState().equals(s) && transitions.get(i).getSymbol() == c) return transitions.get(i).getFinState();
        }
        return null;
    }

    // vérifie si le mot est accepté par l'automate. Si non, donne la raison :
    //   - symbole n’appartenant pas à l’alphabet de l’automate
    //   - absence de transition à partir de l’état courant avec le symbole lu
    //   - fin du mot avant d’atteindre un état final
    public boolean appartient(String mot){
        String etat = initialState;
        boolean appartient = false;
        boolean fin = false;
        int i = 0;
        while(!fin){
            if(i == mot.length()){
                fin = true;
                // System.out.println("Etat à la fin du mot : " + etat);
                if(isInFinalStates(etat)) appartient = true;
                else System.err.println("fin du mot avant d'atteindre un état final");
            }
            else{
                char val = mot.charAt(i);
                if(isInAlphabet(val)){
                    // System.out.println("etat courant : " + etat + "\nsymbole lu : " + val + "\n");
                    if(isInTransitions(etat, val)){
                        etat = getFinState(etat, val);
                        i++;
                    }
                    else{
                        fin = true;
                        System.err.println("absence de transition à partir de l'état courant avec le symbole lu");
                    }
                }
                else{
                    fin = true;
                    System.err.println("symbole n'appartenant pas à l'alphabet de l'automate");
                }
            }
        }
        return appartient;
    }

    // affiche l'automate
    public void affiche(){
        System.out.print("alphabet : {" + alphabet.get(0));
        for (int i = 1; i < alphabet.size(); i++) {
            System.out.print(", " + alphabet.get(i));
        }
        System.out.print("}\n");
        System.out.println("\nétat initial : " + initialState);
        System.out.println("\nétats finaux : " + finalStates.get(0));
        for (int i = 1; i < finalStates.size(); i++) {
            System.out.print(", " + finalStates.get(i));
        }
        System.out.println("\ntransitions : ");
        for (int i = 0; i < transitions.size(); i++) {
            System.out.println(transitions.get(i));
        }
        System.out.print("\n");
    }

    public static void main(String[] args) throws IOException {
        Automate a = new Automate("automate1.txt");
        a.affiche();
        System.out.println(a.appartient("ab"));
    }
} 
