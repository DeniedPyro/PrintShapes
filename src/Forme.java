abstract class Forme {

    int x;
    int y;
    char caractere;
    
    /** 
     * @param sur
     */
    public abstract void dessiner(Surface sur);

    
    /** Setter de Caractere
     * @param car
     */
    public void setCaractere(char car){
        this.caractere = car;
    }
    

    /** Setter de X
     * @param x
     */
    public void setX(int x){
        this.x = x;
    }
    

    /** Setter de Y
     * @param y
     */
    public void setY(int y){
        this.y = y;
    }
    

    /** Getter de X
     * @return int
     */
    public int getX(){
        return this.x;
    }
    

    /** Getter de Y
     * @return int
     */
    public int getY(){
        return this.y;
    }


    /**
     * @param sur
     */
    public abstract void renverser(Surface sur);
}