import java.util.ArrayList;
public class Texte  extends Forme{
    private ArrayList<Lettre> tabLettres;

    public Texte(String chaine , int x , int y, char caractere){
        this.caractere = caractere;
        this.x = x;
        this.y = y;
        tabLettres = new ArrayList<Lettre>();
        for(int i = 0; i < chaine.length(); i++){
            Lettre lettre = new Lettre(chaine.charAt(i), 8*i + x, y, caractere);
            tabLettres.add(lettre);
        }        
    }
    public void dessiner(Surface sur) {
        for (int i = 0; i < tabLettres.size(); i++){
            Lettre lettreAct = tabLettres.get(i);
            lettreAct.dessiner(sur);
        }
    }
}