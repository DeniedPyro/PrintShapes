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
    public void setX2(int x2){
        this.x2 = x2;
    }
    public void setY2(int y2){
        this.y2 = y2;
    }
    public int getX2(){
        return this.x2;
    }
    public int getY2(){
        return this.y2;
    }
    public void dessiner(Surface sur) {
        int deltaX =(this.x2 - this.x);
        int deltaY =(this.y2 - this.y);
        if (deltaX > deltaY) {
            for(int i = this.x; i <= this.x2 ; i++) {
                double calcul = ((double)deltaY/deltaX)*(i - this.x) + this.y;
                int j = (int) Math.round(calcul);
                sur.setCanevasPoint(caractere,j,i);
            }
        }
        else if (deltaX < deltaY) {
            for(int j = this.y; j <= this.y2 ; j++) {
                double calcul = ((double)deltaX/deltaY)*(j - this.y) + this.x;
                int i = (int)Math.round(calcul);
                sur.setCanevasPoint(caractere,j,i);
            }
        }
        if(deltaX<0) {
            for(int i = this.x; i >= this.x2 ; i--) {
                double calcul = ((double)deltaY/deltaX)*(i - this.x) + this.y;
                int j = (int) Math.round(calcul);
                sur.setCanevasPoint(caractere,j,i);
            }
        }
        if(deltaY<0) {
            for(int j = this.y; j >= this.y2 ; j--) {
                double calcul = ((double)deltaX/deltaY)*(j - this.y) + this.x;
                int i = (int)Math.round(calcul);
                sur.setCanevasPoint(caractere,j,i);
            }
        }
        if(deltaY==deltaX){
            if(deltaX < 0){
                for(int i = x; i >= x2; i--){
                    sur.setCanevasPoint(caractere,i,i);
                }
            }
            else {
                for(int i = this.x; i <= this.x2 ; i++) {
                    sur.setCanevasPoint(caractere,i,i);
                }    
            }            
        }
        
    }

    @Override
    public void renverser(Surface sur) {
        this.y = sur.getLigne()-1-this.y;
        this.y2 = sur.getLigne()-1-this.y2;
    }
}