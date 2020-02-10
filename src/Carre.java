public class Carre extends Rectangle {
    int hauteur;
    int largeur;

    public Carre(int hauteur, int largeur, char caractere, int x, int y) {
        super(hauteur, largeur, caractere, x, y);
    }


    public void dessiner(char[][] matrice) {
        System.out.println("im technically rectangle");
    }
}
