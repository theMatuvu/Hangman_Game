import java.io.*;
import java.util.Scanner;

public class FctPendu {
    public static Pendu init(String mot) {
        assert(mot.length()>0);
        Pendu p = new Pendu();
        p.mot = mot;
        p.Nberreur = 0;
        p.trouvées = new boolean[mot.length()];
        for(int i = 0;i<mot.length();++i){
            p.trouvées[i]= false;
        }
        // Arrays.fill(p.trouvées, false);

        return p;
    }
    public static void jouer(Pendu p, char l){
        assert (!estFini(p));
        boolean erreur = false;
        for (int i = 0;i< p.mot.length();++i){
            if (p.mot.charAt(i) == l){
                p.trouvées[i]=true;
                erreur = true;
            }
        }
        if (!erreur)
            ++p.Nberreur;

    }

    public static boolean estFini(Pendu p){

        if (p.Nberreur == Pendu.ErMax)
            return true;

        for(int i =0;i<p.mot.length();++i){
            if (!p.trouvées[i])
                return false;
        }

        return true;
    }
    public static boolean estGagne(Pendu p){
        assert (estFini(p));
        return p.Nberreur != Pendu.ErMax;
    }
    public static String toString(Pendu p){
        StringBuilder phrase = new StringBuilder(">>");

        for(int i = 0;i<p.mot.length();++i){
            if (p.trouvées[i])
                phrase.append(p.mot.charAt(i));
            else
                phrase.append("_");
        }

        phrase.append("   >>");
        phrase.append(p.Nberreur);
        if (p.Nberreur>1)
            phrase.append(" erreurs\n");
        else
            phrase.append(" erreur\n");

        switch(p.Nberreur){

            case 1:
                phrase.append("  \n" +
                        " \n" +
                        " \n" +
                        " \n" +
                        " \n" +
                        " \n" +
                        " \n" +
                        " \n" +
                        " ============\n");
                break;

            case 2:
                phrase.append(" \n" +
                        " ||  \n" +
                        " || \n" +
                        " ||\n" +
                        " ||\n" +
                        " ||\n" +
                        " ||\n" +
                        " ||\n" +
                        " ============\n");
                break;
            case 3:
                phrase.append("  ======Y======\n" +
                        " || \n" +
                        " || \n" +
                        " || \n" +
                        " || \n" +
                        " || \n" +
                        " || \n" +
                        " ||\n" +
                        " ============\n");
                break;
            case 4:
                phrase.append("  ======Y======\n" +
                        " ||  / \n" +
                        " || /  \n" +
                        " ||/   \n" +
                        " ||   \n" +
                        " ||    \n" +
                        " ||   \n" +
                        " ||\n" +
                        " ============\n");
                break;
            case 5:
                phrase.append("  ======Y======\n" +
                        " ||  / |\n" +
                        " || /  |\n" +
                        " ||/   \n" +
                        " ||   \n" +
                        " ||   \n" +
                        " ||   \n" +
                        " ||\n" +
                        " ============\n");
                break;
            case 6:
                phrase.append("  ======Y======\n" +
                        " ||  / |\n" +
                        " || /  |\n" +
                        " ||/   O\n" +
                        " ||   \n" +
                        " ||   \n" +
                        " ||   \n" +
                        " ||\n" +
                        " ============\n");
                break;
            case 7:
                phrase.append("  ======Y======\n" +
                        " ||  / |\n" +
                        " || /  |\n" +
                        " ||/   O\n" +
                        " ||   /|\\\n" +
                        " ||    \n" +
                        " ||   \n" +
                        " ||\n" +
                        " ============\n");
                break;
            case 8:
                phrase.append("  ======Y======\n" +
                        " ||  / |\n" +
                        " || /  |\n" +
                        " ||/   O\n" +
                        " ||   /|\\\n" +
                        " ||    |\n" +
                        " ||   / \\\n" +
                        " ||\n" +
                        " ============\n");
                break;

        }

        return phrase.toString();
    }
    public static int NumRdm(){
        return Robot.MIN + (int)(Math.random() * ((Robot.Max - Robot.MIN) + 1));
    }
    public static String MotAléatoire() {
    String mot ="error";
     try
    {
        // Le fichier d'entrée
        FileInputStream file = new FileInputStream("pli07.txt");
        Scanner scanner = new Scanner(file);

        //renvoie true s'il y a une autre ligne à lire
        int Num = NumRdm();
        System.out.println(Num);

        for(int i=0;i<Num;++i)
            mot = scanner.nextLine();

        scanner.close();
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }


        return mot;
}
}
