/**
* Classe principale du TP1
* @author Fahirah Diarra, p1104084
* @author Hamdi Ghannem,  p1225567
*/
import java.util.Scanner;

public class Tp1 {

    
    /** Initialise la surface
     * @param largeur
     * @param hauteur
     * @return Surface
     */
    public static Surface init(int largeur, int hauteur){
        return new Surface(hauteur,largeur);
    }

    
    /** Brasse le contenu de la surface
     * @param sur
     */
    public static void brasser(Surface sur){
        sur.brasser();
    }

    
    /** Renverse le contenu de la surface
     * @param sur
     */
    public static void renverser(Surface sur){
        sur.renverser();
    }

    
    /** Dessine sur la surface et affiche le contenu
     * @param sur
     */
    public static void dessiner(Surface sur){
        sur.resetCanevas();
        sur.dessiner();
        sur.afficherCanevas();
    }

    
    /** Ajoute sur la surface la forme voulu
     * @param sur
     * @param car
     * @param arg
     */
    public static void ajouter(Surface sur , char car ,String [] arg){
        int x = Integer.parseInt(arg[1]);
        int y = Integer.parseInt(arg[2]);

        if (arg[0].equals("rectangle")){
            int largeur = Integer.parseInt(arg[3]);
            int hauteur = Integer.parseInt(arg[4]);
            Rectangle r = new Rectangle(car,x,y,largeur,hauteur);
            sur.ajouter(r);
        }
        if (arg[0].equals("carre")){
            int cote = Integer.parseInt(arg[3]);
            Carre c = new Carre(car,x,y,cote);
            sur.ajouter(c);
        }
        if (arg[0].equals("cercle")){
            int rayon = Integer.parseInt(arg[3]);
            Cercle c = new Cercle(car,x,y,rayon);
            sur.ajouter(c);
        }
        if (arg[0].equals("lettre")){
            char lettre = arg[3].charAt(0);
            Lettre c = new Lettre(car,x,y,lettre);
            sur.ajouter(c);
        }
        if (arg[0].equals("texte")){
            String chaine = arg[3];
            Texte c = new Texte(car,x,y,chaine);
            sur.ajouter(c);
        }
        if (arg[0].equals("ligne")){
            int y1 = Integer.parseInt(arg[3]);
            int y2 = Integer.parseInt(arg[4]);
            Ligne l = new Ligne(car,x,y,y1,y2);
            sur.ajouter(l);
        }
    }

    
    /** Cree un sous tableau a partir d'un tableau original
     * @param array
     * @param start
     * @param end
     * @return String[]
     */
    public static String[] sliceArray(String[] array, int start, int end) {
        String[] slice = new String[end - start];
        for (int i = 0; i < slice.length; i++) {
            slice[i] = array[start + i];
        }
        return slice;
    }

    
    /** Verifie si le nombre contenue dans le string est un nombre
     * @param str
     * @return boolean
     */
    public static boolean isNumber(String str) {
        if ( str.length() == 0 ||  str == null) {
            return false;
        }
        for(int i =0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    
    /** Verifie si les attributs sont tous des chiffres
     * @param attr
     * @return boolean
     */
    public static boolean isAttrAllNum(String[] attr){
        for (int i = 0; i < attr.length; i++) {
            if (!isNumber(attr[i])) {
                return false;
            }
        }
        return true;
    }

    
    /** Verifie si les attributs de la forme a cree sont conforme
     * @param arg
     * @return boolean
     */
    public static boolean isFormeArgsValid(String [] arg){
        boolean valid = false;
        if (arg[0].equals("rectangle") && arg.length == 5){
            return isAttrAllNum(sliceArray(arg,1,arg.length));
        }
        if (arg[0].equals("carre") && arg.length == 4){
            return isAttrAllNum(sliceArray(arg,1,arg.length));
        }
        if (arg[0].equals("cercle") && arg.length == 4){
            return isAttrAllNum(sliceArray(arg,1,arg.length));
        }
        if (arg[0].equals("lettre") && arg.length == 4){
            if (isNumber(arg[1]) && isNumber(arg[2]) && !isNumber(arg[3]) & arg[3].length() == 1){
                valid = true;
            }
        }
        if (arg[0].equals("texte") && arg.length == 4){
            if (isNumber(arg[1]) && isNumber(arg[2]) && !isNumber(arg[3])){
                valid = true;
            }
        }
        if (arg[0].equals("ligne") && arg.length == 5){
            return isAttrAllNum(sliceArray(arg,1,arg.length));
        }
        return valid;
    }

    
    /** Verifie si la commande ajouter est valide
     * @param instructions
     * @return boolean
     */
    public static boolean isAjouterInstValid(String [] instructions){
        String listeForme [] = {"rectangle","carre","ligne","cercle","lettre","texte"};
        boolean ajouterArgValid = false;
        for (int i = 0; i < listeForme.length; i++) {
            if (instructions[0].equals(listeForme[i])) {
                ajouterArgValid = true;
                break;
            }
        }
        if (!ajouterArgValid){
            return false;
        }
        else {
            return isFormeArgsValid(instructions);
        }
    }

    
    /** Verifie si la commande init est valide
     * @param instructions
     * @return boolean
     */
    public static boolean isInitInstValid(String [] instructions){
        if (isNumber(instructions[1]) && isNumber(instructions[2])){
            return true;
        }
        else {
            return false;
        }
    }

    
    /** Verifie selon la commande si les parametres sont valide et conforme
     * @param instructions
     * @return boolean
     */
    public  static  boolean isInstrParamsValid (String []instructions){
        //System.out.println(instructions[0]);
        if(instructions[0].equals("init") && instructions.length  == 3){
            return isInitInstValid(instructions);
        }
        if(instructions[0].equals("car") && instructions.length  == 2){
            return true;
        }
        if(instructions[0].equals("ajouter") &&  instructions.length > 1){
            return isAjouterInstValid(sliceArray(instructions,1 , instructions.length));
        }
        if(instructions[0].equals("dessiner") && instructions.length  == 1){
            return true;
        }
        if(instructions[0].equals("renverser") && instructions.length  == 1){
            return true;
        }
        if(instructions[0].equals("brasser") && instructions.length  == 1){
            return true;
        }
        else {
            return false;
        }
    }

    
    /** Verifie la commande est valide
     * @param instructions
     * @return boolean
     */
    public static boolean isInstructionValid(String [] instructions ){
        String instructionList [] = {"init","car","ajouter","dessiner","brasser","renverser"};
        boolean isInst = false;
        if(instructions.length < 0){
            return false;
        }
        for (int i = 0; i < instructionList.length; i++) {
            if (instructions[0].equals(instructionList[i])) {
                isInst = true;
                break;
            }
        }
        if (!isInst){
            return false;
        }
        else {
            return isInstrParamsValid(instructions);
        }
    }

    
    /** Execution des commandes ajouter, dessiner, brasser et renverser
     * @param sur
     * @param car
     * @param arg
     */
    public static void exec(Surface sur,char car, String [] arg){
        if (arg[0].equals("ajouter")){
            ajouter(sur, car, sliceArray(arg, 1, arg.length));
        }
        if (arg[0].equals("dessiner")){
                dessiner(sur);
        }

        if (arg[0].equals("brasser")){
                brasser(sur);
        }
        if (arg[0].equals("renverser")){
                renverser(sur);
        }
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String instruction;
        Boolean init = false;
        char car = '#';
        Surface sur = null;
        while (scan.hasNext()){
            instruction = scan.nextLine();
            if(instruction.equals("fin")) {
                break;
            }
            String[] instArgs = instruction.split(" ");
            if (isInstructionValid(instArgs)){
                if (instArgs[0].equals("init")){
                    int largeur = Integer.parseInt(instArgs[1]);
                    int hauteur = Integer.parseInt(instArgs[2]);
                    sur = init(largeur,hauteur);
                    init = true;
                }

                if (init){
                    if (instArgs[0].equals("car") && instArgs.length == 2){
                        car =  instArgs[1].charAt(0);
                    }
                    else {
                         exec(sur,car,instArgs);
//                        int success =
//                        if (success < 0){
//                            System.out.println("l'instruction car doit être executé avant de crée une forme");
//                            //System.out.println("character is: " + car +" <--");
//                        }
                    }
                }
                else{
                    System.out.println("ERREUR: Aucune surface définie");
                }
            }
            else{
                System.out.println("L'instruction n'est pas valide ou conforme");
            }
        }

    }
}