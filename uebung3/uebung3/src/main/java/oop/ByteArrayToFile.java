package oop;

/**
 * die Klasse, die den Byte Array in die Datei schreibt.
 * 
 * @author wooseok Yang
 */
public class ByteArrayToFile {
  String writeTo;

  /**
   * 
   * @param writeTo das ist der Pfad, wo die Datei geschrieben wird.
   */
  ByteArrayToFile(String writeTo) {
    this.writeTo = writeTo;
  }

  /**
   * 
   * @param bytes das ist der Byte Array, der in die Datei geschrieben wird.
   *              Diese Methode schreibt den Byte Array in die Datei.
   */

  public void createFile(byte[] bytes) {
    try {
      java.io.FileOutputStream stream = new java.io.FileOutputStream(writeTo);
      stream.write(bytes);
      stream.close();
    } catch (java.io.IOException e) {
      e.printStackTrace();
    }
  }
}
