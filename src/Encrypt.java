import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
/**
 *
 * @author Jannick
 */
public class Encrypt {

    public static void main(String[] args) {
        //Eingabe (Initialisierung)
        System.out.printf("Hallo. Bitte geben sie ihre Datei ein (Dateiname und Endung):\n");
        Scanner s = new Scanner(System.in);
        String filepath = s.next();
        s.close();
        File datei = new File("src/test.txt");

        //Verarbeitung

        //Einlesen der Datei
        try{
            byte[] inhaltUnverschlüsselt = Read(datei, filepath);
            System.out.println(inhaltUnverschlüsselt);
        }
        catch(IOException e){
            System.out.printf("Die Datei %s koonte nicht eingelesen werden. Bitte überprüfen sie ihre Eingabe.\nBeachten sie, dass sie den kompletten absoluten oder relativen Pfad eingeben müssen.", filepath);
        }

        //Verschlüsseln der Datei
        //Invert();
        
        //(Über-) Schreiben der Datei
                
    }
            
            
            public static byte[] Read(File datei, String filepath) throws IOException{
                byte[] inhaltUnverschlüsselt = Files.readAllBytes(datei.toPath());
                System.out.println("Datei erfolgreich eingelesen.");
                return inhaltUnverschlüsselt;
            }

            /*public static void Invert(byte[] inhaltUnverschlüsselt) {
                for (int i; )
            }*/


}