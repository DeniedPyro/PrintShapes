import java.util.ArrayList;
public class Texte extends Forme{
    private ArrayList<Lettre> tabLettres;

    public Texte(String chaine , int x , int y, char caractere){
        this.caractere = caractere;
        this.x = x;
        this.y = y;
        this.tabLettres = new ArrayList<Lettre>();
        for(int i = 0; i < chaine.length(); i++){
            Lettre lettre = new Lettre(chaine.charAt(i), 8*i + x, y, caractere);
            this.tabLettres.add(lettre);
        }        
    }
    public void coorSet(int x, int y){
        for(int i = 0; i < this.tabLettres.size(); i++) {
            Lettre l = this.tabLettres.get(i);
            l.setX(l.getX() + x);
            l.setY(l.getY() + y);
        }
    }

    public int getSize(){
        return this.tabLettres.size();
    }

    public void dessiner(Surface sur) {
        for (int i = 0; i < this.tabLettres.size(); i++){
            Lettre lettreAct = this.tabLettres.get(i);
            lettreAct.dessiner(sur);
        }
    }

    public void renverser(Surface surface) {
        for(int i = 0; i < this.tabLettres.size(); i++) {
            Lettre l = this.tabLettres.get(i);
            l.renverser(surface);
        }
    }
}