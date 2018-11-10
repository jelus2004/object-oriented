class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    private int poids;
    private int age;
    private int esperanceVie;
    private String couleur;
    private boolean clonee = false;

    public Souris(int poids, String couleur, int age, int esperanceVie) {
        this.poids = poids;
        this.couleur = couleur;
        this.age = age;
        this.esperanceVie = esperanceVie;
        System.out.println("Une nouvelle souris !");
    }

    public Souris(int poids, String couleur) {
        this.poids = poids;
        this.couleur = couleur;
        age = 0;
        esperanceVie = ESPERANCE_VIE_DEFAUT;
        System.out.println("Une nouvelle souris !");
    }

    public Souris(int poids, String couleur, int age) {
        this.poids = poids;
        this.couleur = couleur;
        this.age = age;
        esperanceVie = ESPERANCE_VIE_DEFAUT;
        System.out.println("Une nouvelle souris !");
    }

    public Souris(Souris souris) {
        age = souris.getAge();
        poids = souris.getPoids();
        couleur = souris.getCouleur();
        esperanceVie = souris.getEsperanceVie() * 4 / 5;
        clonee = true;
        System.out.println("Clonage d'une souris !");

    }

    public int getEsperanceVie() {
        return esperanceVie;
    }

    public int getAge() {
        return age;
    }

    public int getPoids() {
        return poids;
    }

    public String getCouleur() {
        return couleur;
    }

    public void vieillir() {
        age++;
        if (clonee && age > esperanceVie/2) {
            couleur = "verte";
        }
    }

    public void evolue() {
        for (int i = age; i < esperanceVie; i++) {
            vieillir();
        }
    }

    public String toString() {
        String returnSouris = "Une souris " + couleur;
        if (clonee) {
            returnSouris += ", clonee,";
        }
        returnSouris += " de " + age + " mois et pesant " + poids + " grammes";
        return returnSouris;
    }
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}