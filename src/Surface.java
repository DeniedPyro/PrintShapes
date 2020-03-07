import java.util.ArrayList;
import java.util.Random;

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

    public void renverser(){
        for (int i = 0; i < listeForme.size(); i++) {
            listeForme.get(i).renverser(this);
        }
    }


    public void setPixel(char car, int i ,int j) {
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
            Random ran1 = new Random();
            Random ran2 = new Random();

            int randX = ran1.nextInt(3) - 1;
            int randY = ran2.nextInt(3) - 1;
            if (forme instanceof Ligne){
                Ligne formeL = (Ligne) forme;
                formeL.setX(formeL.getX() + randX);
                formeL.setX2(formeL.getX2() + randX);
                formeL.setY(formeL.getY() + randY);
                formeL.setY2(formeL.getY2() + randY);
            }
            else if (forme instanceof Texte){
                Texte formeT = (Texte) forme;
                formeT.coorSet(randX, randY);
            }
            else {
                forme.setX(forme.getX() + randX);
                forme.setY(forme.getY() + randY);
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
