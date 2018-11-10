class Fleur {
    private String typeFleur;
    private String couleurFleur;
    public Fleur(String typeFleur, String couleurFleur) {
        this.typeFleur = typeFleur;
        this.couleurFleur = couleurFleur;
        System.out.println(typeFleur + " fraichement cueillie");
    }
    public Fleur(Fleur autre) {
        couleurFleur = autre.couleurFleur;
        System.out.print("Fragile corolle taillée ");
    }
    public void eclore() {
        System.out.println("veiné de " + couleurFleur);
    }
    public String toString() {
        return "qu'un simple souffle" ;
    }
}

class Poeme
{
    public static void main(String[] args)
    {
        Fleur f1 = new Fleur("Violette", "bleu");
        Fleur f2 = new Fleur(f1);
        System.out.print("dans un cristal ");
        f2.eclore();
        System.out.print("ne laissant plus ");
        System.out.println(f1);
        System.out.println(f2);
    }

}