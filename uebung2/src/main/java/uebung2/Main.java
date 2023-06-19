package uebung2;

/**
 * App
 * Die Klasse von Main
 */
public final class Main {
    private Main() {
    }

    /**
     * Das Main Programm. Es erstellt ein Objekt von Tankstelle und ruft die
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        /**
         * Das Objekt von Tankstelle
         **/

        Tankstelle myTankstelle = new Tankstelle(3, 4, 2000, 3000, 20, 50, 300, 700, 1, 5);
        myTankstelle.simulation();
    }
}
