package uebung2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Diese Klasse repraesentiert eine Tankstelle. Sie enthaelt mehrere Liste von
 * Zapfsaeulen und eine Liste von Autos, die an der Tankstelle tanken wollen.
 * Die Klasse simuliert die Tankstelle und gibt die Ergebnisse aus.
 * 
 * <p>
 * Beispiel:
 * <p>
 * <code>
 * Tankstelle tankstelle = new Tankstelle(3, 5, 2, 5, 1, 3, 1, 5, 10, 5);
 * tankstelle.simulation();
 * </code>
 * <p>
 * Ausgabe:
 * <p>
 * <code>
 * t | S-1 | S-2 | S-3 | Kasse
 * -----------------------------
 * 0 | 0 | 0 | 0 | 0
 * </code>
 * 
 * @author wooseok yang
 * @since 2020-05-15
 * @version 1.0
 */
public class Tankstelle {

  private int zapfsaeulenAnzahl = 0;
  public int averageAutosZeitabstand = 0;
  public int minTankenZeit = 0;
  public int maxTankenZeit = 0;
  public int minZahlenZeit = 0;
  public int maxZahlenZeit = 0;
  public int minWegZeit = 0;
  public int maxWegZeit = 0;
  private int simulationsZeit = 0;
  private int protokollabstand = 0;

  /**
   * KasseSchlange ist eine Queue fuer Kasse.
   */
  Queue<AutoFahrer> kasseSchlange = new LinkedList<>();
  Kasse kasse = new Kasse(kasseSchlange, false);

  /**
   * zapfsaeuleListe ist eine Liste fuer Zapfsaeulen.
   */
  public ArrayList<Zapfsaeule> zapfsaeuleListe = new ArrayList<>();
  /**
   * AutoFahrerListe ist eine Queue fuer AutoFahrer.
   */
  public Queue<AutoFahrer> AutoFahrerListe = new LinkedList<>();
  /**
   * averageWarteZeitVorZapfsaeulen
   * maxWarteZeitVorZapfsaeulen
   * averageWarteZeitVorKasse
   * maxWarteZeitVorKasse
   * sind fuer die Aufgaben.
   */
  public int averageWarteZeitVorZapfsaeulen = 0;
  public int maxWarteZeitVorZapfsaeulen = 0;
  public int averageWarteZeitVorKasse = 0;
  public int maxWarteZeitVorKasse = 0;

  /**
   * Konstruktor fuer die Klasse Tankstelle. Erstellt eine Tankstelle mit
   * 
   * @param zapfsaeulenAnzahl       Anzahl der Zapfsaeulen
   * @param averageAutosZeitabstand durchschnittliche Zeitabstand zwischen zwei
   * @param minTankenZeit           minimale Tankzeit
   * @param maxTankenZeit           maximale Tankzeit
   * @param minZahlenZeit           minimale Zeit zum Bezahlen
   * @param maxZahlenZeit           maximale Zeit zum Bezahlen
   * @param minWegZeit              minimale Zeit zum Wegfahren
   * @param maxWegZeit              maximale Zeit zum Wegfahren
   * @param simulationsZeit         Simulationszeit in Minuten
   * @param protokollabstand        Abstand zwischen zwei Protokollen in Minuten
   */
  public Tankstelle(int zapfsaeulenAnzahl, int averageAutosZeitabstand, int minTankenZeit, int maxTankenZeit,
      int minZahlenZeit, int maxZahlenZeit, int minWegZeit, int maxWegZeit, int simulationsZeit, int protokollabstand) {
    this.zapfsaeulenAnzahl = zapfsaeulenAnzahl;
    this.averageAutosZeitabstand = averageAutosZeitabstand;
    this.minTankenZeit = minTankenZeit;
    this.maxTankenZeit = maxTankenZeit;
    this.minZahlenZeit = minZahlenZeit;
    this.maxZahlenZeit = maxZahlenZeit;
    this.minWegZeit = minWegZeit;
    this.maxWegZeit = maxWegZeit;
    this.simulationsZeit = simulationsZeit;
    this.protokollabstand = protokollabstand;

    // Zapfsaeulen erstellen
    for (int i = 0; i < zapfsaeulenAnzahl; i++) {
      // jede Schlange fuer jede Zapfsaeule erstellen
      Queue<AutoFahrer> schlange = new LinkedList<>();
      Zapfsaeule jedZapfsaeule = new Zapfsaeule(schlange, false, false);
      zapfsaeuleListe.add(jedZapfsaeule);
    }

    // Auto Queue erstellen
    // Variable fuer random AutosZeitabstand
    int OptimalAutosAnzahl = (simulationsZeit * 60) / averageAutosZeitabstand; // beispiel 15 Minuten fuer jede 4
                                                                               // Minuten in eine Stunde.
    Random rand = new Random();

    for (int i = 0; i < OptimalAutosAnzahl; i++) {
      // random AnkommmenZeit

      // erstelle positive standardabweichung
      double positiveGaussian = rand.nextGaussian();
      if (positiveGaussian < 0) {
        positiveGaussian = -positiveGaussian;
      }
      // randAnkommenZeit muss mind. 1 sein. Daher hab ich ceil Funktion benutzt.
      int randAnkommenZeit = (int) Math.ceil(positiveGaussian * averageAutosZeitabstand);

      // erstelle random TankenZeit, ZahlenZeit, WegZeit
      int randomTankenZeit = rand.nextInt(maxTankenZeit - minTankenZeit) + minTankenZeit;
      int randomZahlenZeit = rand.nextInt(maxZahlenZeit - minZahlenZeit) + minZahlenZeit;
      int randomWegZeit = rand.nextInt(maxWegZeit - minWegZeit) + minWegZeit;

      // erstelle jede Autofahrer
      AutoFahrer autoFahrer = new AutoFahrer(randAnkommenZeit * 60, randomTankenZeit, randomZahlenZeit, randomWegZeit,
          false,
          false);
      // push diese Autofahrer in Autofahrer Queue.
      AutoFahrerListe.add(autoFahrer);
    }
    // Falls sie diese durchschnittliche Zeitabstand sehen wollen, bitte diese
    // Kommentare entfernen.
    // --------------------------------------------------------
    // for (AutoFahrer autoFahrer : AutoFahrerListe) {
    // System.out.println(autoFahrer.ankommenZeit / 60);
    // }
  }

  public void simulation() {
    // Eingaben
    // UserInterface UI = new UserInterface();
    // this.zapfsaeulenAnzahl = UI.requestInt("zapsauelenAnzahl : ", 0);
    // this.averageAutosZeitabstand = UI.requestInt("averageAutosZeitabstand :", 0);
    // this.minTankenZeit = UI.requestInt("minTankenZeit :", 0);
    // this.maxTankenZeit = UI.requestInt("maxTankenZeit :", 0);
    // this.minZahlenZeit = UI.requestInt("minZahlenZeit :", 0);
    // this.maxZahlenZeit = UI.requestInt("maxZahlenZeit :", 0);
    // this.minWegZeit = UI.requestInt("minWegZeit :", 0);
    // this.maxWegZeit = UI.requestInt("maxWegZeit :", 0);
    // this.simulationsZeit = UI.requestInt("simulationsZeit :", 0);
    // this.protokollabstand = UI.requestInt("protokollabstand :", 0);

    // Default Zeit ist 1 Sekunde.
    long simulationsSeconds = simulationsZeit * 60 * 60;
    // drucke die Tabellenkopf
    System.out.println("t  | S-1 | S-2 | S-3 | Kasse");
    System.out.println("-----------------------------");

    // Simulation fuer jede Sekunde
    for (long every_s = 0; every_s <= simulationsSeconds; every_s++) {

      // checke 5 minutes fuer loggen
      if (every_s % (protokollabstand * 60) == 0) {
        log((int) every_s);
      }

      // checke ob AutoFahrerListe leer ist.
      if (AutoFahrerListe.isEmpty() == false) {
        AutoFahrer neuAutoFahrer = AutoFahrerListe.peek();
        neuAutoFahrer.ankommenZeit--;

        // checke ob AutoFahrer ankommt.AnkommenZeit == 0 bedeutet, dass AutoFahrer an
        // der Tankstelle ankommt.
        if (neuAutoFahrer.ankommenZeit == 0) {

          // suche nach random Zapfsaeule
          Random rand = new Random();
          int randomZapfIndex = rand.nextInt(zapfsaeulenAnzahl);
          Zapfsaeule selectedZapf = zapfsaeuleListe.get(randomZapfIndex);
          selectedZapf.addInSchlange(neuAutoFahrer);
          selectedZapf.besetzt = true;
          AutoFahrerListe.remove();
        }
      }

      // checke jede Schlange vor Zapfsaeulen.
      for (Zapfsaeule currentZapfsaeule : zapfsaeuleListe) {

        // checke ob Schlange leer ist.
        if (currentZapfsaeule.schlange.isEmpty() == false) {
          AutoFahrer currentAuto = currentZapfsaeule.schlange.peek();

          currentAuto.tankt();
          // checke ob AutoFahrer getankt hat.
          if (currentAuto.getTankenZeit() == 0) {
            // add in Kasse Schlange
            kasse.addInSchlange(currentAuto);
            kasse.besetzt = true;
          }
          if (currentAuto.istGetankt() == true && currentAuto.istBezahlt() == true && currentAuto.istWeg() == false) {
            currentAuto.verlaesst();
          }
          if (currentAuto.istGetankt() == true && currentAuto.istBezahlt() == true && currentAuto.istWeg() == true) {
            currentZapfsaeule.schlange.remove();
          }

        }
      }

      if (kasse.schlange.isEmpty() == false) {
        AutoFahrer currentAutoVorKasse = kasse.schlange.peek();
        if (currentAutoVorKasse.getZahlenZeit() > 0) {
          currentAutoVorKasse.bezahlt();
          ;
        } else if (currentAutoVorKasse.getZahlenZeit() == 0) {
          kasse.schlange.remove();
        }
      }

    }
    for (Zapfsaeule jedeZapf : zapfsaeuleListe) {
      for (AutoFahrer fahrer : jedeZapf.schlange) {
        int wartezeit = 0;
        if (fahrer.istGetankt() == true && fahrer.istBezahlt() == false && fahrer.istWeg() == false) {
          wartezeit = +fahrer.getZahlenZeit() + fahrer.getWegZeit();
        } else if (fahrer.istGetankt() == true && fahrer.istBezahlt() == true && fahrer.istWeg() == false) {
          wartezeit = +fahrer.getWegZeit();
        } else {
          wartezeit = +fahrer.getTankenZeit() + fahrer.getZahlenZeit() + fahrer.getWegZeit();
        }
        if (wartezeit > maxWarteZeitVorZapfsaeulen) {
          maxWarteZeitVorZapfsaeulen = wartezeit;
        }
        averageWarteZeitVorZapfsaeulen = +wartezeit;
      }
    }

    int wartezeitVorKasse = 0;
    if (kasse.schlange.size() > 0) {
      for (AutoFahrer autoFahrer : kasse.schlange) {
        wartezeitVorKasse = +autoFahrer.getZahlenZeit();
      }
    }
    System.out.println("Zeitabstand vor Kasse : " + wartezeitVorKasse + " Sekunden");
    System.out.println("maximale Zeitabstand vor Zapfsaelen : " + maxWarteZeitVorZapfsaeulen + " Sekunden");
    System.out
        .println(
            "durchschnittlichen Wartezeit vor Zapfsaelen : " + averageWarteZeitVorZapfsaeulen / zapfsaeulenAnzahl
                + " Sekunden");

  }

  /**
   * diese Methode ist fuer Logging
   * <p>
   * Beispiel:
   * <p>
   * 1 | 0 | 0 | 0 | 0
   * <p>
   * 
   * @param every_s
   */
  public void log(int every_s) {
    System.out.println(every_s / 60 + " |   " + zapfsaeuleListe.get(0).schlange.size() + " |   "
        + zapfsaeuleListe.get(1).schlange.size() + " |   " + zapfsaeuleListe.get(2).schlange.size() + " |   "
        + kasse.schlange.size());
  }
}
