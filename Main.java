import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Automate a1 = new Automate("automate1.txt");
        Automate a2 = new Automate("automate2.txt");
        Automate a3 = new Automate("automate3.txt");


        System.out.println("Automate 1 : \n  - mot : aa");
        System.out.println(a1.appartient("aa"));
        System.out.println("\n  - mot : ab");
        System.out.println(a1.appartient("ab"));

        System.out.println("\n-----\nAutomate 2 : \n  - mot : baaaaaaab");
        System.out.println(a2.appartient("baaaaaaab"));
        System.out.println("\n  - mot : ba");
        System.out.println(a2.appartient("ba"));

        System.out.println("\n-----\nAutomate 3 : \n  - mot : caaa");
        System.out.println(a3.appartient("caaa"));
        System.out.println("\n  - mot : baaaaaaab");
        System.out.println(a3.appartient("baaaaaaab"));
        System.out.println("\n  - mot : cdaaaab");
        System.out.println(a3.appartient("cdaaaab"));
    }
}