import java.util.ArrayList;
import java.util.Random;

public class Surface {

    private int ligne;
    private int colonne;
    private ArrayList<Forme> listeForme;
    private char[][] canevas;

    public Surface(int ligne, int colonne) {
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


    /**
     * Getter de colonne
     *
     * @return int
     */
    public int getColonne() {
        return this.colonne;
    }


    /**
     * Getter de ligne
     *
     * @return int
     */
    public int getLigne() {
        return this.ligne;
    }


    /**
     * Permer de rendre la canevas vide.
     */
    public void resetCanevas() {
        for (int i = 0; i < this.ligne; i++) {
            for (int j = 0; j < this.colonne; j++) {
                this.canevas[i][j] = ' ';
            }
        }
    }


    /**
     * Permet de dessiner chaque forme se trouvant
     * dans notre liste de forme sur la surface
     */
    public void dessiner() {
        for (int i = 0; i < listeForme.size(); i++) {
            listeForme.get(i).dessiner(this);
        }
    }


    /**
     * Permet de renverser chaque forme se trouvant
     * dans la liste de forme
     */
    public void renverser() {
        for (int i = 0; i < listeForme.size(); i++) {
            listeForme.get(i).renverser(this);
        }
    }


    /**
     * Permet de voir si les coordonnées ne dépassent
     * pas la taille de la surface puis de
     * setter chaque pixel par un caractère
     *
     * @param car
     * @param i
     * @param j
     */
    public void setPixel(char car, int i, int j) {
        if (j >= 0 && j < this.getColonne() && i >= 0 && i < this.getLigne()) {
            this.canevas[i][j] = car;
        }
    }


    /**
     * Getter du canevas.
     *
     * @return char[][]
     */
    public char[][] getCanevas() {
        return this.canevas;
    }


    /**
     * Ajouter une forme à l'attribut listeForme.
     *
     * @param enforme
     */
    public void ajouter(Forme enforme) {
        listeForme.add(enforme);
    }


    /**
     * Crée 2 objets de classe Random puis
     * utiliser la methode nextInt de la classe
     * Random pour avoir une valeur entre 0 inclusivement
     * et 3 exclusivement puis de faire -1 pour avoir
     * une valeur entre -1 et 1 inclusivements
     * puis ajouter ces 2 valeurs aux coordonées X et Y
     * indépendamment
     */
    public void brasser() {
        for (int i = 0; i < listeForme.size(); i++) {
            Forme forme = listeForme.get(i);
            Random ran1 = new Random();
            Random ran2 = new Random();

            int randX = ran1.nextInt(3) - 1;
            int randY = ran2.nextInt(3) - 1;
            if (forme instanceof Ligne) {
                Ligne formeL = (Ligne) forme;
                formeL.setX(formeL.getX() + randX);
                formeL.setX2(formeL.getX2() + randX);
                formeL.setY(formeL.getY() + randY);
                formeL.setY2(formeL.getY2() + randY);
            } else if (forme instanceof Texte) {
                Texte formeT = (Texte) forme;
                formeT.coorSet(randX, randY);
            } else {
                forme.setX(forme.getX() + randX);
                forme.setY(forme.getY() + randY);
            }
        }
    }


    /**
     * Permet de printer chaque pixel du canevas.
     */
    public void afficherCanevas() {
        for (int i = 0; i < canevas.length; i++) {
            String resultat = "";
            for (int j = 0; j < canevas[i].length; j++) {
                resultat += this.canevas[i][j];
            }
            System.out.println(resultat);
        }
    }
}