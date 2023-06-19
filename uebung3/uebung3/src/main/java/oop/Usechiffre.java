package oop;

/**
 * Diese Methode läuft das Programm , wie der Benutzer will.
 * 
 * @auther wooseok Yang
 */
public class Usechiffre {
  /**
   * Diese Methode läuft das Programm , wie der Benutzer will.
   */
  public void run() {
    int a = UserInterface.in.requestInt("a: ", 0);
    int b = UserInterface.in.requestInt("b: \n", 0);
    int m = UserInterface.in.requestInt("m: \n", 0);
    int key = UserInterface.in.requestInt("key: \n", 0);
    XORChiffre xor = new XORChiffre(a, b, m, key,
        "/Users/Schmatz/Code/OOP/uebung3/uebung3/src/main/java/oop/result/"
            + UserInterface.in.requestString("Was ist der Dateiname von Klartext ?") + ".txt",
        "/Users/Schmatz/Code/OOP/uebung3/uebung3/src/main/java/oop/result/"
            + UserInterface.in.requestString("welcher Name wollen sie fuer neue Datei?")
            + ".txt");
    xor.run();
  }
}
