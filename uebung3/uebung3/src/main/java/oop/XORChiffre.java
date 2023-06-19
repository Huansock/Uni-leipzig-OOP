package oop;

/**
 * Die Hauptklasse, die chiffriert und entschlüsselt mit XORChiffre.
 * 
 * @auther wooseok Yang
 */
public class XORChiffre {
  private ByteArrayToFile Writer;
  private FileToByte Plaintext;
  private KeyByte Keys;
  byte[] myByteArray;

  /**
   * Diese Methode läuft das Xor Programm.
   */
  public void run() {
    for (int i = 0; i < Plaintext.getLength(); i++) {
      myByteArray[i] = encodeNext();
    }
    writeToFile();
  }

  /**
   * 
   * @param a        a fuer die Formel( a*x + b mod m)
   * @param b        b fuer die Formel (a*x + b mod m)
   * @param m        m fuer die Formel (a*x + b mod m)
   * @param key      key fuer die Formel (a*x + b mod m)
   * @param readFrom readFrom ist der Pfad, wo die Datei gelesen wird.
   * @param writeTo  writeTo ist der Pfad, wo die Datei geschrieben wird.
   */
  public XORChiffre(int a, int b, int m, int key, String readFrom, String writeTo) {
    Writer = new ByteArrayToFile(writeTo);
    Plaintext = new FileToByte(readFrom);
    Keys = new KeyByte(a, b, m, (byte) key);
    myByteArray = new byte[Plaintext.getLength()];
  }

  /**
   * 
   * @return Byte
   *         Diese Methode gibt das Byte, das chiffriert wird.
   */
  private Byte encodeNext() {
    Byte resultByte = (byte) (Plaintext.getNextByte() ^ Keys.getNextByte());
    return resultByte;
  }

  /**
   * Diese Methode schreibt den Byte Array in die Datei.
   */
  private void writeToFile() {
    Writer.createFile(myByteArray);
  }
}
