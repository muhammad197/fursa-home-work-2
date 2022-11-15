package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.*;
import java.io.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class TransInfoHtml {

    public static void main(String args[])
    {

        try {
            FileWriter myWriter = new FileWriter("src/main/resources/StoryRss2.xml");
            myWriter.flush();

            URL oracle = new URL("http://www.ynet.co.il/Integration/StoryRss2.xml");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            String inputLine;
            int i=1;
            while ((inputLine = in.readLine()) != null) {
                if((i<4 || i>15)) {
                    myWriter.write(inputLine);
                    myWriter.flush();
                    myWriter.write("\n");
                }
                i++;
            }
            in.close();



            TransformerFactory tFactory=TransformerFactory.newInstance();

            Source xslDoc=new StreamSource("src/main/resources/xmltohtml.XSL");
            Source xmlDoc=new StreamSource("src/main/resources/StoryRss2.xml");

            String outputFileName="outputfile.html";

            OutputStream htmlFile=new FileOutputStream(outputFileName);
            htmlFile.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes());
            htmlFile.write("\n".getBytes());
            Transformer trasform=tFactory.newTransformer(xslDoc);
            trasform.transform(xmlDoc, new StreamResult(htmlFile));

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (TransformerConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (TransformerFactoryConfigurationError e)
        {
            e.printStackTrace();
        }
        catch (TransformerException e)
        {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
