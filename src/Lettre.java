public class Lettre extends Forme{
    private char lettre;
    private byte[] carImage;
    public Lettre (int x, int y, char caractere){
        this.caractere = caractere;
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
                    sur.setPixel(this.caractere, yActuel, i);
                }
                encodage >>= 1;
            }
        }
    }

    public void renverser(Surface sur) {
        for(int i = 0; i < this.carImage.length/2; i++){
            byte tempCar = this.carImage[i];
            this.carImage[i] = this.carImage[this.carImage.length-1-i];
            this.carImage[this.carImage.length-1-i] = tempCar;
        }

        this.y = sur.getLigne()-this.y-12;
    }
}