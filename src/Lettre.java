public class Lettre extends Forme{
    private char lettre;
    public Lettre (char lettre,int x, int y, char caractere){
        this.caractere = caractere;
        this.lettre = lettre;
        this.x = x;
        this.y = y;
    }

    public void dessiner(Surface sur) {
        byte[] table = Police8x12.getImage(lettre);
        for(int j = 0; j < 12; j++) {
            int yActuel = j + this.y;
            byte encodage = table[j];
            for(int i = this.x + 7; i >= this.x; i--) {
                if ((encodage & 1) == 1) {
                    sur.setCanevasPoint(caractere, yActuel, i);
                }
                encodage >>= 1;
            }
        }
    }
}