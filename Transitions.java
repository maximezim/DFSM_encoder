public class Transitions {
    private String initState;
    private String finState;
    private String symbol;

    public Transitions(String initState, String finState, String symbol) {
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

    public String getSymbol() {
        return symbol;
    }

    public void setInitState(String initState) {
        this.initState = initState;
    }

    public void setFinState(String finState) {
        this.finState = finState;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
