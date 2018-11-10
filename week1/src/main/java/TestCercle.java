class Cercle {
    private double rayon;
    private double x;
    private double y;

    public void setCentre(double xSet, double ySet) {
        x = xSet;
        y = ySet;
    }

    public void setRayon(double r) {
        if (r < 0.0) r = 0.0;
        rayon = r;
    }

    public double surface() {
        return Math.PI * rayon * rayon;
    }

    public boolean estInterieur(double xSet, double ySet) {
        return (((xSet - x) * (ySet - x) +
                (xSet - y) * (ySet - y))
                <= rayon * rayon);
    }
}

public class TestCercle {
    public static void main(String[] args) {
        Cercle c1 = new Cercle();
        Cercle c2 = new Cercle();
        Cercle c3 = new Cercle();

        c1.setCentre(3.0, 4.0);
        c1.setRayon(3.0);

        c2.setCentre(-7.0, 5.0);
        c2.setRayon(4.0);

        c3.setCentre(5.0, -2.0);
        c3.setRayon(7.0);

        afficheSurface("c1", c1);
        afficheSurface("c2", c2);
        afficheSurface("c3", c3);

        affichePos("c1", c1, 7.0, 12.0);
        affichePos("c2", c2, 4.0, -5.0);
        affichePos("c3", c3, -8.0, -3.0);
    }

   static void afficheSurface(String nomCercle, Cercle c) {
       System.out.println("Surface du cercle " + nomCercle + " : " + c.surface() + " cm².");
   }

    static void affichePos(String nomCercle, Cercle c, double x, double y) {
        System.out.print("Le point situé en '" + x + ", " + y + "' est ");
        if (c.estInterieur(x, y)) {
            System.out.print("à l'intérieur ");
        } else {
            System.out.print("à l'extérieur ");
        }
        System.out.println("du cercle " + nomCercle + ".");
    }
}
