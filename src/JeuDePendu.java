import java.text.Normalizer;
import java.util.Objects;
import java.util.Scanner;
import java.io.*;

import static java.lang.Character.toUpperCase;


public class JeuDePendu {
    public static void main(String[] args) throws IOException {
        int Nbcoup = 0;
        Scanner sc;
        sc = new Scanner(System.in);

        System.out.println("Choose a word(1) or take a random word(2)");
        String choix = sc.next();
        String mot = null;
        while (mot == null) {
            if (Objects.equals(choix, "1")) {
                System.out.println("Write your word");
                mot = sc.next().toUpperCase();
            }
            else if (Objects.equals(choix, "2")){
                mot = FctPendu.MotAléatoire();
            }
            else{
                System.out.println("Choose a word(1) or take a random word(2)");
                choix = sc.next();
            }
        }

        Pendu p = FctPendu.init(mot);
        while (!FctPendu.estFini(p)){
            String pc = FctPendu.toString(p);
            System.out.println(pc);
            mot = sc.next();
            char c = mot.charAt(0);
            FctPendu.jouer(p,toUpperCase(c));
            Nbcoup++;
        }
        if (FctPendu.estGagne(p)){
            System.out.println("Congratulation");
            String c = (Nbcoup>1)? "moves":"move";
            String er = (p.getNberreur()>1)? "mistakes":"mistake";
            System.out.println("You find " + p.getMot() + " in " + Nbcoup +" " + c + " and " + p.getNberreur() +" "+ er);

        }
        else {
            System.out.println("Arggg...");
            System.out.println("The word was " + p.getMot());
            System.out.println("======Y======\n" +
                    "||  / |\n" +
                    "|| /  |\n" +
                    "||/   O\n" +
                    "||   /|\\\n" +
                    "||    |\n" +
                    "||   / \\\n" +
                    "||\n" +
                    "============");

        }
    }


}
