public class Carre extends Rectangle {

    public Carre(int cote, char caractere, int x, int y) {
        super(cote, cote , caractere, x, y);
    }


    public void dessiner(Surface sur) {


        for (int i = this.x ; i < this.largeur ; i++){

            if (i >=0 && i < sur.ligne){
            }


        }


        for (int i = this.x ; i < this.largeur ; i++){
            for (int j = this.y ; j < this.hauteur ; j++){
                //if i and j are within the surface
                if (i >=0 && j >=0 && i <sur.ligne && j < sur.colonne){
                }
            }


        }


        System.out.println("im technically rectangle");
    }
}
