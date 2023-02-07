public class Test {
    public static void main(String[] args) {
        // test automate
        String[] finalStates = {"q2"};
        char[] alphabet = {'a', 'b'};

        Transitions[] transitions = {new Transitions("q0", "q1", 'a'), new Transitions("q1", "q2", 'b'), new Transitions("q2", "q2", 'b')};
        Automate automate = new Automate("q0", finalStates, transitions, alphabet);
        System.out.println(automate.appartient("abb"));
    }
}
