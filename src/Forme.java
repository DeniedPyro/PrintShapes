abstract class Forme {
    int x;
    int y;
    char caractere = '#'; // # par default

    
    /** 
     * @param car
     */
    public abstract void dessiner(Surface sur);

    
    /** 
     * @param car
     */
    public void setCaractere(char car){
        this.caractere = car;
    }
    
    /** 
     * @param x
     */
    public void setX(int x){
        this.x = x;
    }
    
    /** 
     * @param y
     */
    public void setY(int y){
        this.y = y;
    }
    
    /** 
     * @return int
     */
    public int getX(){
        return this.x;
    }
    
    /** 
     * @return int
     */
    public int getY(){
        return this.y;
    }

    public abstract void renverser(Surface surface);
}