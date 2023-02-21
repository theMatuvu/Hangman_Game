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

        System.out.println("Voulez vous choisir un mot(1) ou jouer contre l'ordinateur(2)");
        String choix = sc.next();
        String mot = null;
        while (mot == null) {
            if (Objects.equals(choix, "1")) {
                System.out.println("Saisissez votre mot");
                mot = sc.next();
            }
            else if (Objects.equals(choix, "2")){
                mot = FctPendu.MotAléatoire();
            }
            else{
                System.out.println("Voulez vous choisir un mot(1) ou jouer contre l'ordinateur(2)");
                choix = sc.next();
            }
        }

        //mot = Normalizer.normalize(mot, Normalizer.Form.NFD).replaceAll("[\u0300-\u036F]", "");
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
            System.out.println("Bravo");
            String c = (Nbcoup>1)? "coups":"coup";
            String er = (p.Nberreur>1)? "erreurs":"erreur";
            System.out.println("Vous avez trouvé " + p.mot + " en " + Nbcoup +" " + c + " et en " + p.Nberreur +" "+ er);

        }
        else {
            System.out.println("Arggg...");
            System.out.println("Le mot était " + p.mot);
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
