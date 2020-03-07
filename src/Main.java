public class Main {
    public static void main(String[] args) {
        Surface windows = new Surface(13 ,64);
        Ligne l = new Ligne(1,1,7,5,'#');
        Rectangle r = new Rectangle(12,64,'.',0,0);
        Texte texte = new Texte("AAAAAAAAA", 0, 0, '#');
        // Lettre k = new Lettre('B', 0, 0,'#');
        //Cercle c = new Cercle(3,'%',4,4);
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
        
        windows.ajouter(texte);

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
        windows.renverser();
        windows.dessiner();
        windows.afficherCanevas();
    }
}