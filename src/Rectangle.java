public class Rectangle extends Forme {
    int hauteur;
    int largeur;

    public Rectangle(char caractere, int x ,int y, int largeur, int hauteur){
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.caractere = caractere;
        this.x = x;
        this.y = y;
    }

    
    /** 
     * @param sur
     */
    public void dessiner(Surface sur) {
        for (int col = this.x ; col < this.largeur + this.x ; col++){
            for (int lin = this.y ; lin < this.hauteur + this.y ; lin++){
                sur.setPixel(this.caractere,lin,col);
            }
        }
    }

    
    /** 
     * @param sur
     */
    public void renverser(Surface sur){
        this.y = sur.getLigne()-this.y-this.hauteur;
    }

}