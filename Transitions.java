public class Transitions {
    private String initState;
    private String finState;
    private char symbol;

    public Transitions(String initState, String finState, char symbol) {
        this.initState = initState;
        this.finState = finState;
        this.symbol = symbol;
    }

    public Transitions() {
    }

    public String getInitState() {
        return initState;
    }

    public String getFinState() {
        return finState;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setInitState(String initState) {
        this.initState = initState;
    }

    public void setFinState(String finState) {
        this.finState = finState;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return initState + " -> " + symbol + " -> " + finState;
    }
}
