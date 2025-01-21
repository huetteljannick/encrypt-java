import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Encrypt {

    public static void main(String[] args) {
        //Eingabe (Initialisierung)
        System.out.printf("Hallo. Bitte geben sie ihre Datei ein (Dateiname und Endung):\n");
        Scanner s = new Scanner(System.in);
        String filepath = s.nextLine();
        s.close();
        File datei = new File(filepath);

        //Verarbeitung

        //Einlesen der Datei
        
        byte[] inhaltUnverschlüsselt = ReadFile(datei, filepath);
        System.out.println(inhaltUnverschlüsselt);
        
        //Verschlüsseln der Datei
        byte[] inhaltVerschlüsselt = Invert(inhaltUnverschlüsselt);
        
        //(Über-) Schreiben der Datei
        WriteFile(inhaltVerschlüsselt, filepath, datei);
                
    }
            
            
    public static byte[] ReadFile(File datei, String filepath){
        try{
            byte[] inhaltUnverschlüsselt = Files.readAllBytes(datei.toPath());
            System.out.println("Datei erfolgreich eingelesen.");
            return inhaltUnverschlüsselt;
        }
        catch(IOException e){
            System.out.printf("Die Datei %s koonte nicht eingelesen werden. Bitte überprüfen sie ihre Eingabe.\nBeachten sie, dass sie den kompletten absoluten oder relativen Pfad eingeben müssen.", filepath);
            return null;
        }
    }

    public static byte[] Invert(byte[] inhaltUnverschlüsselt) {
        byte[] inhaltVerschlüsselt = new byte[inhaltUnverschlüsselt.length];
        for (int i = 0;i < inhaltUnverschlüsselt.length;i++ ){
            inhaltVerschlüsselt[i] = (byte) (inhaltUnverschlüsselt[i]^ 0xff);
        }
        System.out.println("Datei erfogreich verschlüsselt.");
        System.out.println(inhaltVerschlüsselt);
        return inhaltVerschlüsselt;
    }

    public static void WriteFile(byte[] inhaltUnverschlüsselt, String filepath, File Ursprungsdatei){
        try{
            Files.write(Ursprungsdatei.toPath(),inhaltUnverschlüsselt);
            System.out.println("Datei erfolgreich überschrieben.");
        }
        catch(IOException e) {
            System.out.printf("Die Datei %s konnte nicht überschrieben werden.", filepath);
        }
    }


}