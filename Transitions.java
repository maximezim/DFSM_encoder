public class Transitions {
    private char initState;
    private char finState;
    private char symbol;

    public Transitions(char initState, char finState, char symbol) {
        this.initState = initState;
        this.finState = finState;
        this.symbol = symbol;
    }

    public Transitions() {
    }

    // getters and setters

    public char getInitState() {
        return initState;
    }

    public void setInitState(char initState) {
        this.initState = initState;
    }

    public char getFinState() {
        return finState;
    }

    public void setFinState(char finState) {
        this.finState = finState;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

}
