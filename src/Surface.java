import java.util.ArrayList;
import static java.lang.Math.random;
public class Surface {
    private int ligne;
    private int colonne;
    private ArrayList<Forme> listeForme;
    private char [][] canevas ;

    public Surface(int ligne, int colonne){
        this.ligne = ligne;
        this.colonne = colonne;
        this.canevas = new char[ligne][colonne];
        this.listeForme = new ArrayList<Forme>();
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                this.canevas[i][j] = ' ';
            }
        }
    }

    public int getColonne() {
        return this.colonne;
    }

    public int getLigne() {
        return this.ligne;
    }

    public void resetCanevas(){
        for(int i = 0; i < this.ligne; i++) {
            for(int j = 0; j < this.colonne; j++) {
                this.canevas[i][j] = ' ';
            }
        }
    }

    public void dessiner(){
        for (int i = 0; i < listeForme.size(); i++) {
            listeForme.get(i).dessiner(this);
        }
    }


    public void setCanevasPoint(char car, int i ,int j) {
        if (j>=0 && j < this.getColonne() && i >=0 && i < this.getLigne()){
            this.canevas[i][j] = car;
        }
    }

    public char[][] getCanevas(){
        return this.canevas;
    }

    public void ajouter (Forme enforme){
        listeForme.add(enforme);
    }

    public void brasser(){
        for(int i = 0; i < listeForme.size(); i++) {
            Forme forme = listeForme.get(i);
            int randX = (int)(Math.random()*3 - 1);
            int randY = (int)(Math.random()*3 - 1);                
            if (forme instanceof Ligne){
                Ligne formeL = (Ligne) forme;
                formeL.setX(formeL.getX() + randX);
                formeL.setX2(formeL.getX2() + randX);
                formeL.setY(formeL.getY() + randY);
                formeL.setY2(formeL.getY2() + randY);
            }
            else {
                forme.setX(forme.getX() + randX);
                forme.setY(forme.getY() + randY);
            }
        }
    }

    public void renverser(){
        for(int col = 0; col < this.colonne; col++){
            for( int lin = 0; lin < this.ligne/2; col++){
                char tempCar =this.canevas[col][ligne] ;
                this.canevas[lin][col] = this.canevas[this.ligne-1-lin][col];
                this.canevas[this.ligne-1-lin][col] = tempCar;
            }
        }
    }

    public void afficherCanevas(){
        for(int i = 0; i < canevas.length; i++) {
            String resultat = "";
            for (int j = 0; j < canevas[i].length; j++) {
                resultat += this.canevas[i][j];
            }
            System.out.println(resultat);
        }
    }
}
