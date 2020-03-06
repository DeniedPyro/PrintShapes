

public class Main {

    public static void main(String[] args) {
        Surface windows = new Surface(1 ,2);
        Rectangle r = new Rectangle(1,2,'%',1,1);
        Cercle c = new Cercle(1,'%',1,1);

        windows.ajouter(r);
        windows.ajouter(c);

        windows.dessiner();
        windows.afficherCanevas();

    }


}
