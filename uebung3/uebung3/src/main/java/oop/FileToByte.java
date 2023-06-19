/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * Die klassse, die die Datei in Byte Array konvertiert.
 * 
 * @author Lucas Matthes
 */
public class FileToByte {
    private byte[] myByteArray;
    private int position = 0;

    /**
     * Konstruktor
     * ruft convert
     * 
     * @param path Pfad der zulesenden Datei
     * 
     */
    FileToByte(String path) {
        convert(path);
    }

    /**
     * Konvertiert Datei in ByteArray
     * 
     * @param path Pfad der zulesenden Datei
     */
    private void convert(String path) {
        File file = new File(path);
        myByteArray = new byte[(int) file.length()];
        FileInputStream reader;

        try {
            reader = new FileInputStream(file);
            reader.read(myByteArray);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException ioEx) {
            ioEx.printStackTrace(System.err);
        }
    }

    /**
     * Getter fuer ByteArray
     * 
     * @return myByteArray als byte[]
     */
    public byte[] getArray() {
        return myByteArray;
    }

    /**
     * Getter fuer Laenge
     * 
     * @return Laenge als Int
     */
    public int getLength() {
        return myByteArray.length;
    }

    /**
     * Setter fuer position
     * 
     * @param newPos neue position
     */
    public void setPosition(int newPos) {
        position = newPos;
    }

    /**
     * Gibt das naechste Byte aus
     * 
     * @return Naechstes Byte der Datei
     */
    public Byte getNextByte() {
        if (position < getLength()) {
            return myByteArray[position++];
        } else {
            return null;
        }
    }

}
