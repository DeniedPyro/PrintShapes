public class Lettre extends Forme{

    char lettre;
    int x ;
    int y;

    public Lettre (char lettre,int x, int y){
        this.lettre = lettre;
        this.x = x;
        this.y = y;
    }

    public void dessiner(char[][] matrice) {
        System.out.println("im the letter " + this.lettre);
    }
}
