package oop;

/**
 * diese Methode läuft das Programm mit Preset.
 * Der Benutzer kann wählen, ob er das Programm mit Preset laufen will.
 * 
 * @auther wooseok Yang
 */
public class Testchiffre {
  /**
   * Diese Methode läuft das Programm mit Preset.
   */
  public void run() {
    String preset = "Es gibt zwei Preset \n Preset1 a = 421 b = 54773 m = 259200 key = 3  \n Preset2 a = 3877 b=29573 m=139968 key=3 \n was wollen Sie? (1 oder 2)";
    int selectedPreset = UserInterface.in.requestChoice(preset, "1", "2");

    if (selectedPreset == 0) {
      XORChiffre xor = new XORChiffre(421, 54773, 259200, 3,
          "/Users/Schmatz/Code/OOP/uebung3/uebung3/src/main/java/oop/result/"
              + UserInterface.in.requestString("Was ist der Dateiname von Klartext ?") + ".txt",
          "/Users/Schmatz/Code/OOP/uebung3/uebung3/src/main/java/oop/result/"
              + UserInterface.in.requestString("welcher Name wollen sie fuer neue Datei?")
              + ".txt");
      xor.run();
    } else {
      XORChiffre xor = new XORChiffre(3877, 29573, 139968, 3,
          "/Users/Schmatz/Code/OOP/uebung3/uebung3/src/main/java/oop/result/"
              + UserInterface.in.requestString("Was ist der Dateiname von Klartext ?") + ".txt",
          "/Users/Schmatz/Code/OOP/uebung3/uebung3/src/main/java/oop/result/"
              + UserInterface.in.requestString("welcher Name wollen sie fuer neue Datei?")
              + ".txt");
      xor.run();
    }
  }
}
