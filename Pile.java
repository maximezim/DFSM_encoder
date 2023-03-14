import java.util.ArrayList;
import java.util.Stack;

public class Pile {
    private Stack<Character> pile;
    private ArrayList<Character> alphabetPile;

    public Pile() {
        this.pile = new Stack<Character>();
        this.alphabetPile = new ArrayList<Character>();
    }

    public Pile(Stack<Character> pile, ArrayList<Character> alphabetPile) {
        this.pile = pile;
        this.alphabetPile = alphabetPile;
    }

    public void push(char symbol) {
        pile.push(symbol);
    }

    public char pop() {
        return pile.pop();
    }

    public char peek() {
        return pile.peek();
    }

    public boolean isEmpty() {
        return pile.isEmpty();
    }

    public Stack<Character> getPile() {
        return pile;
    }

    public void setPile (Stack<Character> pile) {
        this.pile = pile;
    }

    public ArrayList<Character> getAlphabetPile() {
        return alphabetPile;
    }

    public void setAlphabetPile(ArrayList<Character> alphabetPile) {
        this.alphabetPile = alphabetPile;
    }

    public boolean isInAlphabetPile(char symbol) {
        for (int i = 0; i < alphabetPile.size(); i++) {
            if (alphabetPile.get(i) == symbol) {
                return true;
            }
        }
        return false;
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
