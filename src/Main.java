

public class Main {

    public static void main(String[] args) {
        Surface windows = new Surface(10 ,10);
        Rectangle r = new Rectangle(6,8,'%',4,4);
        Cercle c = new Cercle(3,'%',4,4);
        Ligne l = new Ligne(1,1,7,5,'L');

        //windows.ajouter(l);

        windows.ajouter(r);
        //windows.ajouter(c);

        windows.dessiner();
        windows.afficherCanevas();

    }


}
