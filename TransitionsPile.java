public class TransitionsPile extends Transitions {
    private String pile = "";
    private Character precedent;

    public TransitionsPile(String initState, String finState, char symbol, Character precedent, String pile) {
        super(initState, finState, symbol);
        this.pile = pile;
        this.precedent = precedent;
    }

    public String getPile () {
        return pile;
    }

    public Character getPrecedent () {
        return precedent;
    }

    @Override
    public String toString() {
        return super.toString() + " -> " + precedent + " -> " + pile;
    }
} 
