class ToStringEq
{
    public static void main(String[] args)
    {
        System.out.println("Test 1 :");
        Rectangle rect = new Rectangle(12.5, 4.0);
        System.out.println(rect);
        System.out.println();
        System.out.println("Test 2: ");
// le type de rect1 est RectangleColore
// l'objet contenu dans rect1 est de type RectangleColore
        RectangleColore rect1 = new RectangleColore(12.5, 4.0, "rouge");
        System.out.println(rect1);
        System.out.println();
        System.out.println("Test 3 :");
// le type de rect2 est Rectangle
// l'objet contenu dans rect2 est de type RectangleColore
        Rectangle rect2 = new RectangleColore(25.0/2, 8.0/2, new String("rouge"));
        System.out.println(rect2);
        System.out.println (rect1.equals(rect2)); // 1.
        System.out.println (rect2.equals(rect1)); // 2.
        System.out.println(rect1.equals(null)); // 3.
        System.out.println (rect.equals(rect1)); // 4.
        System.out.println (rect1.equals(rect)); // 5.
    }
}
class Rectangle {
    private double largeur;
    private double longueur;

    public Rectangle(double largeur, double longueur) {
        this.largeur = largeur;
        this.longueur = longueur;
    }
    public String toString() {
        return String.format("La largeur du rectangle est : %s\nLa longueur du rectangle est : %s", largeur, longueur);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else {
            if (obj.getClass() != getClass()) {
                return false;
            } else {
                Rectangle rectangle = (Rectangle)obj;
                return (largeur == rectangle.largeur && longueur == rectangle.longueur);
            }
        }
    }
}

class RectangleColore extends Rectangle {
    private String couleur;

    public RectangleColore(double larg, double longueur, String couleur){
        super(larg, longueur);
        this.couleur = couleur;
    }
    @Override
    public String toString() {
        return super.toString() + String.format("\nLa couleur du rectangle est : %s", couleur);
    }
}