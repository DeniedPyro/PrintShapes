public class Lettre extends Forme{

    private byte[] lettreEncode;

    public Lettre (char caractere,int x, int y, char lettre){
        this.caractere = caractere;
        this.x = x;
        this.y = y;
        this.lettreEncode = Police8x12.getImage(lettre);
    }

    
    /** Permet de parcourir l'encodage d'une lettre
     * puis d'utiliser l'opérateur & pour voir
     * si le bit le moins significatif est égal à 1
     * puis bitshifter à droite.
     * @param sur
     */
    public void dessiner(Surface sur) {
        byte[] table = this.lettreEncode;
        for(int j = 0; j < 12; j++) {
            int yActuel = j + this.y;
            byte encodage = table[j];
            for(int i = this.x + 7; i >= this.x; i--) {
                if ((encodage & 1) == 1) {
                    sur.setPixel(this.caractere, yActuel, i);
                }
                encodage >>= 1;
            }
        }
    }

    
    /** Inverse le tableau de byte pour renverser lettre
     * @param sur
     */
    public void renverser(Surface sur) {
        for(int i = 0; i < this.lettreEncode.length/2; i++){
            byte tempCar = this.lettreEncode[i];
            this.lettreEncode[i] = this.lettreEncode[this.lettreEncode.length - 1 - i];
            this.lettreEncode[this.lettreEncode.length - 1 - i] = tempCar;
        }
        this.y = sur.getLigne() - this.y - 12;
    }
}