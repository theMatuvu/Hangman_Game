public class Pendu {
    private String mot;
    private int Nberreur;
    boolean[] trouvées;
    private static final int MAX = 6;
    private static final int ErMax = 8;

    public int getMax(){
        return Pendu.MAX;
    }
    public int getErMax(){
        return Pendu.ErMax;
    }
    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public int getNberreur() {
        return Nberreur;
    }

    public void setNberreur(int nberreur) {
        Nberreur = nberreur;
    }

    public boolean[] getTrouvées() {
        return trouvées;
    }

    public void setTrouvées(boolean[] trouvées) {
        this.trouvées = trouvées;
    }

    public void ajtTrouvées(int i, boolean b) {
        this.trouvées[i] = b;
    }
}

