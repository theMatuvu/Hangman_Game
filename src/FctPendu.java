import java.io.*;
import java.util.Scanner;

public class FctPendu {
    public static Pendu init(String mot) {
        assert(mot.length()>0);
        Pendu p = new Pendu();
        p.setMot(mot);
        p.setNberreur(0);
        p.setTrouvées(new boolean[mot.length()]) ;
        for(int i = 0;i<mot.length();++i){
            p.getTrouvées()[i]= false;
        }
        // Arrays.fill(p.trouvées, false);

        return p;
    }
    public static void jouer(Pendu p, char l){
        assert (!estFini(p));
        boolean erreur = false;
        for (int i = 0;i< p.getMot().length();++i){
            if (p.getMot().charAt(i) == l){

                p.ajtTrouvées(i,true);
                erreur = true;
            }
        }
        if (!erreur)
            p.setNberreur(p.getNberreur()+1);

    }

    public static boolean estFini(Pendu p){

        if (p.getNberreur() == p.getErMax())
            return true;

        for(int i =0;i<p.getMot().length();++i){
            if (!p.getTrouvées()[i])
                return false;
        }

        return true;
    }
    public static boolean estGagne(Pendu p){
        assert (estFini(p));
        return p.getNberreur() != p.getErMax();
    }
    public static String toString(Pendu p){
        StringBuilder phrase = new StringBuilder(">>");

        for(int i = 0;i<p.getMot().length();++i){
            if (p.getTrouvées()[i])
                phrase.append(p.getMot().charAt(i));
            else
                phrase.append("_");
        }

        phrase.append("   >>");
        phrase.append(p.getNberreur());
        if (p.getNberreur()>1)
            phrase.append(" erreurs\n");
        else
            phrase.append(" erreur\n");

        switch(p.getNberreur()){

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
        return Robot.getMIN() + (int)(Math.random() * ((Robot.getMax() - Robot.getMIN()) + 1));
    }
    public static String MotAléatoire() {
    String mot ="error";
     try
    {
        FileInputStream file = new FileInputStream("BDD_Words.txt");
        Scanner scanner = new Scanner(file);

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
