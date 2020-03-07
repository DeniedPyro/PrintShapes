public class Cercle extends Forme {

    int rayon;

    public Cercle(char caractere, int x , int y , int rayon){
        this.rayon = rayon;
        this.caractere = caractere;
        this.x = x;
        this.y = y;
    }

    public void ajouterPixel(Surface sur , int x , int y){
        if(x >=0 && x < sur.getColonne() && y >= 0 && y < sur.getLigne()){
            sur.setPixel(this.caractere,y,x);
        }
    }

    public void dessiner(Surface sur) {
        int x = 0;
        int y = this.rayon;
        int m = 5 - 4 * this.rayon;

        while (x <= y){
            ajouterPixel(sur,x+this.x, y+this.y );
            ajouterPixel(sur,y+this.x, x+this.y );
            ajouterPixel(sur, -x+this.x, y+this.y );
            ajouterPixel(sur,-y+this.x, x+this.y );
            ajouterPixel(sur, x+this.x, -y+this.y );
            ajouterPixel(sur,y+this.x, -x+this.y );
            ajouterPixel(sur,-x+this.x, -y+this.y );
            ajouterPixel(sur,-y+this.x, -x+this.y );
            if (m > 0){
                y = y-1 ;
                m = m - (8*y);
            }
            x = x + 1 ;
            m = m + 8*x + 4 ;
        }
    }

    public void renverser(Surface sur){
        this.y = sur.getLigne()-(this.rayon/2)-this.y;
    }
}
