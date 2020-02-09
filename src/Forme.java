abstract class Forme {
    int x;
    int y ;
    char caractere; // # par default

    public void draw(char matrice [][] ) {
    }

    public  void setCaractere(char car){
        this.caractere = car;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
