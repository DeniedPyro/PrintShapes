abstract class Forme {

    int x;
    int y;
    char caractere;
    
    /** Dessine la forme
     * @param sur
     */
    public abstract void dessiner(Surface sur);

    
    /** Setter de caractere
     * @param car
     */
    public void setCaractere(char car){
        this.caractere = car;
    }
    

    /** Setter de x
     * @param x
     */
    public void setX(int x){
        this.x = x;
    }
    

    /** Setter de y
     * @param y
     */
    public void setY(int y){
        this.y = y;
    }
    

    /** Getter de x
     * @return int
     */
    public int getX(){
        return this.x;
    }
    

    /** Getter de y
     * @return int
     */
    public int getY(){
        return this.y;
    }


    /** Renverse la forme
     * @param sur
     */
    public abstract void renverser(Surface sur);
}