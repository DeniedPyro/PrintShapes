import static java.lang.Math.round;
public class Ligne extends Forme {
    private int x2;
    private int y2;
    public Ligne(int x1, int y1, int x2, int y2, char caractere) {
        this.x  = x1;
        this.x2 = x2;
        this.y  = y1;
        this.y2 = y2;
        this.caractere = caractere;
    }
    public void dessiner(Surface sur) {
        int deltaX =(x2 - x);
        int deltaY =(y2 - y);
        if (deltaX > deltaY) {
            for(int i = x; i < x2 ; i++) {
                double calcul = Math.round((deltaY/deltaX)*(i - x) + y);
                int j = (int) calcul;
                sur.setCanevasPoint(caractere,i,j);
            }
        }
        else if (deltaX < deltaY) {
            for(int i = y; i < y2 ; i++) {
                double calcul = Math.round((deltaX/deltaY)*(i - y) + x);
                int j = (int)(calcul);
                sur.setCanevasPoint(caractere,j,i);
            }
        }
        else {
            for(int i = x; i < x2; i++){
            sur.setCanevasPoint(caractere,i,i);
        }
        }
    }
}
