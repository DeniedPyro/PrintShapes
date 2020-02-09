public class Cercle extends Forme {

    int rayon;

    public Cercle(int rayon,char caractere,int x , int y){
        this.rayon = rayon;
        this.caractere = caractere;
        this.x = x;
        this.y = y;

    }

    @Override
    public void draw(char[][] matrice) {
        super.draw(matrice);
        System.out.println("im a circle");
    }
}
