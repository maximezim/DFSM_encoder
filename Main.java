import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Automate a = new Automate("distributeur.txt");
        a.affiche();
        System.out.println(a.appartient("5S5s"));
    }
}