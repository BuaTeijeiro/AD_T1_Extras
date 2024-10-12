package org.example.XMLReaders;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

public class SAXReader {

    private static String REPERIDORES_XML = "src/main/resources/alumnos/alumnos_repetidores.xml";

    private String xmlURL;

    public SAXReader(String XML_URL) {
        this.xmlURL = XML_URL;
    }

    public SAXReader(){
        this.xmlURL = REPERIDORES_XML;
    }

    public String getXmlURL(){
        return xmlURL;
    }

    public void Read(){
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean bAlumno = false;
                boolean bDni = false;
                boolean bNombre = false;
                boolean bEdad = false;
                boolean bMedia = false;
                boolean bRepetidor = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if(qName.equalsIgnoreCase("alumno")){
                        bAlumno = true;
                    }
                    if (qName.equalsIgnoreCase("dni")) {
                        bDni = true;
                    }
                    if (qName.equalsIgnoreCase("nombre")) {
                        bNombre = true;
                    }
                    if (qName.equalsIgnoreCase("edad")) {
                        bEdad = true;
                    }
                    if (qName.equalsIgnoreCase("media")) {
                        bMedia = true;
                    }
                    if (qName.equalsIgnoreCase("repetidor")) {
                        bRepetidor = true;
                    }

                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if(bAlumno){
                        System.out.println("Alumno:");
                        bAlumno = false;
                    }

                    if (bNombre) {
                        System.out.println("\tnombre: " + new String(ch, start, length));
                        bNombre = false;
                    }
                    if (bDni) {
                        System.out.println("\tdni: " + new String(ch, start, length));
                        bDni = false;
                    }
                    if (bEdad) {
                        System.out.println("\tedad: " + new String(ch, start, length));
                        bEdad = false;
                    }
                    if (bMedia) {
                        System.out.println("\tmedia: " + new String(ch, start, length));
                        bMedia = false;
                    }
                    if (bRepetidor) {
                        System.out.println("\trepeditor: " + new String(ch, start, length));
                        bRepetidor = false;
                    }
                }
            };

            InputStream inputStream = new FileInputStream(getXmlURL());
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");
            saxParser.parse(is, handler);

        } catch (ParserConfigurationException | SAXException e){
            System.out.println("Error al parsear el archivo");
        } catch (FileNotFoundException |UnsupportedEncodingException e){
            System.out.println("Error al abrir el archivo");
        } catch (IOException e){
            System.out.println("Error al tratar el archivo");
        }
    }
}
