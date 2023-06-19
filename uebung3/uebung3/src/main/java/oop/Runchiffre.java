package oop;

/**
 * Diese Klase läuft das Programm.
 * 
 * @author wooseok Yang
 */
public class Runchiffre {
  public UserInterface UI = new UserInterface();
  int result = UI.requestChoice("wollen Sie textPrgramm laufen?", "ja", "nein");

  /**
   * Diese Methode läuft das Programm. Der Benutzer kann wählen, ob er das
   * Programm mit Preset laufen will.
   */
  public void run() {
    if (result == 0) {
      Testchiffre test = new Testchiffre();
      test.run();
    } else {
      Usechiffre use = new Usechiffre();
      use.run();
    }
  }
}
