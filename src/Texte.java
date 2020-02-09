public class Texte  extends Forme{
    Lettre liste_lettre [];

    public Texte(char [][] caracteres ,int x , int y){
        this.liste_lettre = new Lettre [caracteres.length];
        this.x = x;
        this.y = y;

    }

    @Override
    public void draw(char[][] matrice) {
        super.draw(matrice);
    }
}
