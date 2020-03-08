import java.util.Scanner;

public class Main {
    static int errorCode;

    public static void init(Surface sur , int largeur, int hauteur){
        sur = new Surface(hauteur,largeur);
    }

    public static void brasser(Surface sur){
        sur.brasser();
    }

    public static void renverser(Surface sur){
        sur.renverser();
    }

    public static void dessiner(Surface sur){
        sur.resetCanevas();
        sur.dessiner();
        sur.afficherCanevas();
    }

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

    public static String[] sliceArray(String[] arr, int start, int end) {
        String[] slice = new String[end - start];
        for (int i = 0; i < slice.length; i++) {
            slice[i] = arr[start + i];
        }
        return slice;
    }

    public static boolean isNumber(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAttrAllNum(String[] attr){
        for (int i = 0; i < attr.length; i++) {
            if (!isNumber(attr[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFormeArgsValid(String [] arg){
        boolean valid = false;
        if (arg[0].equals("rectangle") && arg.length == 5){
            return isAttrAllNum(sliceArray(arg,1,arg.length));
        }
        if (arg[0].equals("carre") && arg.length == 4){
            return isAttrAllNum(sliceArray(arg,1,arg.length));
        }
        if (arg[0].equals("cercle") && arg.length == 4){
            System.out.println("cercle cercle");
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

    public static boolean isAjouterInstValid(String [] instructions){
        String listeForme [] = {"rectangle","carre","ligne","cercle","lettre","text"};
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
            System.out.println("on a une forme");
            return isFormeArgsValid(instructions);
        }

    }

    public static boolean isInitInstValid(String [] instructions){
        if (isNumber(instructions[1]) && isNumber(instructions[2])){
            return true;
        }
        else {
            return false;
        }
    }

    public  static  boolean isInstrParamsValid (String []instructions){
        System.out.println(instructions[0]);
        if(instructions[0].equals("init")){
            return isInitInstValid(instructions);
        }
        if(instructions[0].equals("car") && instructions.length  == 2){
            return true;
        }
        if(instructions[0].equals("ajouter")){
            System.out.println("YES ON AJOUTE");
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

    public static boolean isInstructionValid(String [] instructions ){
        String instructionList [] = {"init","car","ajouter","dessiner","brasser","renverser"};
        boolean isInst = false;
        if(instructions.length < 0){
            errorCode = 0;
            return false;
        }

        for (int i = 0; i < instructionList.length; i++) {
            if (instructions[0].equals(instructionList[i])) {
                System.out.println("yay");
                isInst = true;
                break;
            }
        }
        if (!isInst){
            return false;
        }
        else {
            System.out.println("lets go");
            return isInstrParamsValid(instructions);
        }
    }

    public static boolean exec(boolean init, Surface sur,char car, String [] arg){
        boolean sucess = true;
        if (arg[0].equals("init")){
            int largeur = Integer.parseInt(arg[1]);
            int hauteur = Integer.parseInt(arg[2]);
            init(sur,largeur,hauteur);
            init=true;
        }
        if (arg[0].equals("car")){
            car =  arg[1].charAt(0);
        }

        if (arg[0].equals("ajouter")){
            if (car != ' '){
                ajouter(sur, car, sliceArray(arg, 1, arg.length));
                car = ' ';
            }else sucess = false;
        }

        if (arg[0].equals("dessiner")){
            if (init) {
                dessiner(sur);
            }else sucess = false;
        }

        if (arg[0].equals("brasser")){
            if (init ) {
                brasser(sur);
            }else sucess = false;
        }

        if (arg[0].equals("renverser")){
            if (init) {
                renverser(sur);
            }else sucess = false;
        }

        return sucess;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String instruction;
        Boolean init = false;
        char car = ' ';
        Surface sur = null;
        do {
            instruction = scan.nextLine();
            if(instruction.equals("fin")) {
                break;
            }

            String[] instArgs = instruction.split(" ");

            if (isInstructionValid(instArgs)){
                boolean sucess = exec(init,sur,car,instArgs);


                if (!sucess){
                    System.out.println("Erreur dans l'execution");
                }
            }
            else{
                System.out.println("L'instruction n'est pas valide");
            }
        } while (scan.hasNext());









        /* Surface windows = new Surface(10,10);
        Ligne l = new Ligne(1,1,7,5,'#'); */
        /* Rectangle r = new Rectangle(10,10,'.',0,0);
        Rectangle r2 = new Rectangle(4,4,'#',3,3);
        Rectangle r1 = new Rectangle(4,4,'8',1,1); */
        //Texte texte = new Texte("AAAAAAAAA", 0, 0, '#');
        // Lettre k = new Lettre('B', 0, 0,'#');
        //Cercle c = new Cercle(3,'%',2,2);
        // Ligne l1 = new Ligne(15,15,30,20,'1');
        // Ligne l2 = new Ligne(15,15,30,10,'2');
        // Ligne l3  = new Ligne(15,15,0,20,'3');
        // Ligne l4  = new Ligne(15,15,0,10,'4');
        // Ligne l5  = new Ligne(15,15,20,30,'5');
        // Ligne l6  = new Ligne(15,15,10,30,'6');
        // Ligne l7  = new Ligne(15,15,20,0,'7');
        // Ligne l8  = new Ligne(15,15,10,0,'8');
        // Ligne l9  = new Ligne(0,15,30,15,'h');
        // Ligne l10 = new Ligne(15,0,15,30,'v');
        
        /* windows.ajouter(r);
        windows.ajouter(r2);
        windows.ajouter(r1); */

        // windows.ajouter(l1);
        // windows.ajouter(l2);
        // windows.ajouter(l3);
        // windows.ajouter(l4);
        // windows.ajouter(l5);
        // windows.ajouter(l6);
        // windows.ajouter(l7);
        // windows.ajouter(l8);
        // windows.ajouter(l9);
        // windows.ajouter(l10);
        // windows.ajouter(c);
        /* windows.dessiner();
        windows.afficherCanevas();
        windows.resetCanevas();
        System.out.println("------------------------------------------------------------------");
        windows.renverser();
        windows.dessiner();
        windows.afficherCanevas();
        windows.resetCanevas();
        System.out.println("------------------------------------------------------------------");
        windows.renverser();
        windows.dessiner();
        windows.afficherCanevas(); */
    }
}