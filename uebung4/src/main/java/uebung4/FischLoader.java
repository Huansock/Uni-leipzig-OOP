package uebung4;

import java.util.ArrayList;

/**
 * Fischloader Klasse zum laden der Fische
 * 
 * @author wooseok Yang
 */
public class FischLoader {
  /**
   * Standardkonstruktor
   */
  FischLoader() {
  }

  public ArrayList<Fisch> load() {
    ArrayList<Fisch> list = new ArrayList<Fisch>();

    // load Data (Wooseok)
    list.add(new Fisch(0, 70, "Grüne Migräne", new int[] { 3, 6 }));
    list.add(new Fisch(1, 50, "Korallenqualle", new int[] {}));
    list.add(new Fisch(2, 30, "Schuppenschattulle", new int[] { 3, 4 }));
    list.add(new Fisch(3, 40, "Breitmaulmolch", new int[] { 0, 2 }));
    list.add(new Fisch(4, 40, "Prachtpiranha", new int[] { 2, 6 }));
    list.add(new Fisch(5, 30, "Zitterling", new int[] { 6 }));
    list.add(new Fisch(6, 20, "Grottensprotte", new int[] { 0, 4, 5 }));

    return list;
  }
}
