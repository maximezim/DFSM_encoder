import java.util.ArrayList;

public class Pile {
    // Représente une pile de caractères pour l'automate à pile
    private ArrayList<Character> pile;

    public Pile() {
        this.pile = new ArrayList<Character>();
    }

    public Pile(ArrayList<Character> pile) {
        this.pile = pile;
    }

    public void push(char symbol) {
        pile.add(symbol);
    }

    public char pop() {
        char symbol = pile.get(pile.size() - 1);
        pile.remove(pile.size() - 1);
        return symbol;
    }

    public char peek() {
        return pile.get(pile.size() - 1);
    }

    public boolean isEmpty() {
        return pile.isEmpty();
    }

    public ArrayList<Character> getPile() {
        return pile;
    }

    public void setPile(ArrayList<Character> pile) {
        this.pile = pile;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < pile.size(); i++) {
            s += pile.get(i);
        }
        return s;
    }
}
