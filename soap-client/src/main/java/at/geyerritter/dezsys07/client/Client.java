package at.geyerritter.dezsys07.client;

import org.apache.commons.cli.ParseException;

import javax.xml.soap.SOAPMessage;
import java.io.*;

public class Client {

    public static String NAME;

    public static String HOST = "localhost";

    public static String PORT = "8080";

    public static String DUMP_PATH = "";

    public static void main(String args[]) {
        CLIProcessor processor = new CLIProcessor();

        try {
            processor.parseArguments(args);
            SOAPMessageCreator messageCreator = new DezSysSOAPMessageCreator(NAME);
            SOAPConnector connector = new SOAPConnector(messageCreator, "http://" + HOST + ":" + PORT + "/datarecords/search");

            SOAPMessage message = connector.call();
            String messageString = ClientUtils.soapMessageToString(message, true);

            if (DUMP_PATH.isEmpty()) {
                System.out.println(messageString);
            } else {
                System.out.println("Dumping response to file: " + DUMP_PATH);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DUMP_PATH)));
                writer.write(messageString);
                writer.flush();
                writer.close();
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            processor.printHelp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
