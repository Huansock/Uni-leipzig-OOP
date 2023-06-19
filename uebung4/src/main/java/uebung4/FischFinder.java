package uebung4;

import java.util.ArrayList;

/**
 * Hauptklasse fuer die Berechnung der besten Komposition
 * 
 * @author lucas
 */

public class FischFinder {
  private ArrayList<Fisch> allFisch;

  /**
   * Standardkonstruktor
   */
  FischFinder() {
  }

  /**
   * Berechnet optimale Komposition
   */
  public void calc() {
    FischLoader mLoader = new FischLoader();
    allFisch = mLoader.load();
    int budget = 170; // UI.getInt
    System.out.println(rekSearch(new Komposition(allFisch), budget));
  }

  /**
   * Rekursive Hilfsmethode
   * 
   * @param komp   derzeitige Komposition
   * @param budget derzeitige Kosten
   * @return beste erweiterte Komposition
   */
  private Komposition rekSearch(Komposition komp, int budget) {
    ArrayList<Komposition> possibilities = new ArrayList<>();
    for (Fisch f : komp.getPossibleAdditions()) {
      if (f.getCost() <= budget) {
        possibilities.add(rekSearch(komp.fuseWith(f), budget - f.getCost()));
      }
    }
    if (possibilities.size() != 0) {
      Komposition max = new Komposition(allFisch);
      for (Komposition k : possibilities) {
        if (k.getSize() > max.getSize()) {
          max = k;
        }
      }
      return max;
    } else {
      return komp;
    }
  }
}
