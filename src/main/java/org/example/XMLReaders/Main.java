package org.example.XMLReaders;

public class Main {
    public static void main(String[] args){
        System.out.println("------Método DOM-----\n");
        DOMReader domReader = new DOMReader();
        domReader.Read();

        System.out.println("\n\n------Método SAX-----\n");

        SAXReader saxReader = new SAXReader();
        saxReader.Read();
    }
}
