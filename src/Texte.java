import java.util.ArrayList;
public class Texte extends Forme{
    private ArrayList<Lettre> tabLettres;

    public Texte(char caractere, int x, int y, String chaine){
        this.caractere = caractere;
        this.x = x;
        this.y = y;
        this.tabLettres = new ArrayList<Lettre>();
        for(int i = 0; i < chaine.length(); i++){
            Lettre lettre = new Lettre(caractere, 8*i + x, y, chaine.charAt(i));
            this.tabLettres.add(lettre);
        }        
    }
    
    /** 
     * @param x
     * @param y
     */
    public void coorSet(int x, int y){
        for(int i = 0; i < this.tabLettres.size(); i++) {
            Lettre l = this.tabLettres.get(i);
            l.setX(l.getX() + x);
            l.setY(l.getY() + y);
        }
    }

    
    /** 
     * @return int
     */
    public int getSize(){
        return this.tabLettres.size();
    }

    
    /** 
     * @param sur
     */
    public void dessiner(Surface sur) {
        for (int i = 0; i < this.tabLettres.size(); i++){
            Lettre lettreAct = this.tabLettres.get(i);
            lettreAct.dessiner(sur);
        }
    }

    
    /** 
     * @param sur
     */
    public void renverser(Surface sur) {
        for(int i = 0; i < this.tabLettres.size(); i++) {
            Lettre l = this.tabLettres.get(i);
            l.renverser(sur);
        }
    }
}