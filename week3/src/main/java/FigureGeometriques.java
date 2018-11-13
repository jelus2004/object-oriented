class FiguresGeometriques {
    public static void main(String[] args) {
        // A COMPLETER
        RectangleColore r = new RectangleColore(1.2,3.4,12.3,43.2,4);
        r.affiche();
        Cercle c = new Cercle (2.3, 4.5, 12.2);
        c.affiche();
    }
}

class Figure {
    private double x;
    private double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void affiche() {
        System.out.printf("Les coordonnées du centre de la figure sont : %s(x), %s(y).\n", x, y);
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setCentre(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle extends Figure{
    private double largeur;
    private double longueur;

    public Rectangle(double largeur, double longueur, double x, double y) {
        super(x, y);
        this.largeur = largeur;
        this.longueur = longueur;
    }
    public void affiche () {
        super.affiche();
        System.out.printf("La largeur du rectangle est : %s\n", largeur);
        System.out.printf("La longueur du rectangle est : %s\n", longueur);
    }
    public double surface() {
        return largeur * longueur;
    }
    public double getLongueur() {
        return longueur;
    }
    public double getLargeur() {
        return largeur;
    }
    public void setLargeur(double l) {
        largeur = l;
    }
    public void setLongueur(double l) {
        longueur = l;
    }
}

class Cercle extends Figure{
    private double rayon;

    public Cercle(double x, double y, double r) {
        super(x, y);
        rayon = r;
    }
    public void affiche() {
        super.affiche();
        System.out.printf("Le rayon du cercle est : %s\n", rayon);
    }
    public double surface() {
        return Math.PI * rayon * rayon;
    }
    public boolean estInterieur(double x, double y) {
        return (((x - super.getX()) * (x - super.getX()) + (y - super.getY()) * (y - super.getY()))
                <= rayon * rayon);
    }
    public double getRayon() {
        return rayon;
    }
    public void setRayon(double r) {
        if (r < 0.0) r = 0.0;
        rayon = r;
    }
}
class RectangleColore extends Rectangle {
    private int couleur;

    public RectangleColore( double x, double y, double larg, double longueur, int c){
        super(larg, longueur, x, y);
        couleur = c;
    }
    public void affiche() {
        super.affiche();
        System.out.printf("La couleur du rectangle est : %s\n", couleur);
    }
}
