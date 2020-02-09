import sun.font.SunFontManager;

public class Main {
    
    public static void main(String[] args) {
        Surface windows = new Surface(1 ,2);
        Rectangle r = new Rectangle(1,2,'%');
        Cercle c = new Cercle(1,'%');

        windows.ajouter(r);
        windows.ajouter(c);

    }


}
