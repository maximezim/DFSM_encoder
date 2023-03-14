public class TransitionsPile extends Transitions {
    private Character pile;

    public TransitionsPile(String initState, String finState, char symbol, Character pile) {
        super(initState, finState, symbol);
        this.pile = pile;
    }

    public Character getPile () {
        return pile;
    }

    @Override
    public String toString() {
        return super.toString() + " -> " + pile;
    }
} 
