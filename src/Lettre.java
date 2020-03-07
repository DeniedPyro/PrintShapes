public class Lettre extends Forme{
    private char lettre;
    private byte[] carImage;
    public Lettre (char lettre,int x, int y, char caractere){
        this.caractere = caractere;
        this.lettre = lettre;
        this.x = x;
        this.y = y;
        this.carImage = Police8x12.getImage(lettre);
    }
    public void dessiner(Surface sur) {
        byte[] table =this.carImage;
        for(int j = 0; j < 12; j++) {
            int yActuel = j + this.y;
            byte encodage = table[j];
            for(int i = this.x + 7; i >= this.x; i--) {
                if ((encodage & 1) == 1) {
                    sur.setCanevasPoint(this.caractere, yActuel, i);
                }
                encodage >>= 1;
            }
        }
    }

    @Override
    public void renverser(Surface surface) {
        for(int i = 0; i < this.carImage.length/2; i++){
            byte tempCar = this.carImage[i];
            this.carImage[i] = this.carImage[this.carImage.length-1-i];
            this.carImage[this.carImage.length-1-i] = tempCar;
        }
    }
}