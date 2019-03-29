package com.mycompany.odtcompar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.odf.OpenDocumentParser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

public class OpenDocumentParse {

   
   public  String MetadataParse(String rutaOdt1, String rutaOdt2)throws IOException,SAXException, TikaException 
   {   
      // Documento plantilla
      BodyContentHandler handler1 = new BodyContentHandler();
      Metadata metadata1 = new Metadata();
      FileInputStream inputstream1 = new FileInputStream(new File(rutaOdt1));
      ParseContext pcontext1 = new ParseContext();
      
      //Open Document Parser
      OpenDocumentParser openofficeparser1 = new OpenDocumentParser (); 
      openofficeparser1.parse(inputstream1, handler1, metadata1,pcontext1); 
                 
       
      //Documento a comparar 
      BodyContentHandler handler2 = new BodyContentHandler();
      Metadata metadata2 = new Metadata();
      FileInputStream inputstream2 = new FileInputStream(new File(rutaOdt2));
      ParseContext pcontext2 = new ParseContext();
      
      //Open Document Parser
      OpenDocumentParser openofficeparser2 = new OpenDocumentParser (); 
      openofficeparser1.parse(inputstream2, handler2, metadata2,pcontext2); 
       
       String Result;
       
       Result="\nArchivo  :   "+rutaOdt1+"    \nFecha de creación:  "+metadata1.get("meta:creation-date");
       Result+="\n\nArchivo  :   "+rutaOdt2+"   \nFecha de creación:  "+metadata2.get("meta:creation-date");
       
       
       if (metadata1.get("meta:creation-date").equals(metadata2.get("meta:creation-date")))
           Result+="\n\nMisma fecha de creación";
       else
            Result+="\n\nArchivos odt distintos";  
       return Result;
}
   
   
}