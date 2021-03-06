class FiguresGeometriques2 {
    public static void main(String[] args) {
        Figure[] f = new Figure[3];
        f[0] = new RectangleColore(1.2, 3.4, 12.3, 43.2, 4);
        f[1] = new Cercle(2.3, 4.5, 12.2);
        f[2] = new Rectangle(1.3, 3.6, 2.3, 56.2);
        for (Figure figure : f){
            figure.affiche();
            System.out.println("La surface de cette forme est :" + figure.surface());
        }
    }
}

abstract class Figure {
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
    public abstract double surface();
}

class Rectangle extends Figure{
    private double largeur;
    private double longueur;

    public Rectangle(double largeur, double longueur, double x, double y) {
        super(x, y);
        this.largeur = largeur;
        this.longueur = longueur;
    }
    @Override
    public void affiche () {
        super.affiche();
        System.out.printf("La largeur du rectangle est : %s\n", largeur);
        System.out.printf("La longueur du rectangle est : %s\n", longueur);
    }
    @Override
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
    @Override
    public void affiche() {
        super.affiche();
        System.out.printf("Le rayon du cercle est : %s\n", rayon);
    }
    @Override
    public double surface() {
        return Math.PI * rayon * rayon;
    }
    public boolean estInterieur(double x, double y) {
        return (((x - super.getX()) * (x - super.getX()) + (y - super.getY()) * (y - super.getY())) <= rayon * rayon);
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
    @Override
    public void affiche() {
        super.affiche();
        System.out.printf("La couleur du rectangle est : %s\n", couleur);
    }
}