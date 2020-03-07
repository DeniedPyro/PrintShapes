public class Rectangle extends Forme {
    int hauteur;
    int largeur;

    public Rectangle(int hauteur, int largeur,char caractere, int x ,int y){
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.caractere = caractere;
        this.x = x;
        this.y = y;
    }

    public void dessiner(Surface sur) {
        for (int col = this.x ; col < this.largeur + this.x ; col++){
            for (int lin = this.y ; lin < this.hauteur + this.y ; lin++){
                sur.setCanevasPoint(this.caractere,lin,col);
            }
        }
    }
}