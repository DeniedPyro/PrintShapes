import java.util.ArrayList;
import static java.lang.Math.random;
public class Surface {
    int ligne;
    int colonne;
    ArrayList<Forme> listeForme;
    char [][] canevas ;


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
    public void dessin(){
        for (int i = 0; i < listeForme.size(); i++) {
            listeForme.get(i).dessiner(this);
        }
    }
    public void resetCanevas(){
        for(int i = 0; i < this.ligne; i++) {
            for(int j = 0; j < this.colonne; j++) {
                this.canevas[i][j] = ' ';
            }
        }
    }

    public void setCanevasPoint(char car, int i ,int j) {
        this.canevas[i][j] = car;
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

    }
    public void afficherCanevas(){
        for (int i = 0; i < canevas.length; i++) {
            String resultat = "";
            for (int j = 0; j < canevas[i].length; j++) {
                resultat += this.canevas[i][j];
            }
            System.out.println(resultat);
        }
    }
}
