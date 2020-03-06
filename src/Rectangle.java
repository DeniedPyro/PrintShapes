public class Rectangle extends Forme {
    int hauteur;
    int largeur;

    public Rectangle(int hauteur, int largeur,char caractere, int x ,int y){
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.caractere = caractere;
        this.x= x;
        this.y = y;
    }

    public void dessiner(Surface sur) {
        
        for (int col = this.x ; col < this.largeur + this.x ; col++){

            if (col >=0 && col < sur.colonne){
                sur.setCanevasPoint(this.caractere,col,this.y);
                sur.setCanevasPoint(this.caractere,col ,(this.hauteur-1)+this.y);
            }
        }

        for (int lin = this.y ; lin < this.hauteur + this.y ; lin++){

            if (lin >=0 && lin < sur.ligne){
                sur.setCanevasPoint(this.caractere,this.x,lin);
                sur.setCanevasPoint(this.caractere,(this.largeur-1) + this.x , lin);
            }
        }
    }
}
