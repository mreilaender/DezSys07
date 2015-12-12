package at.geyerritter.dezsys07.client;

import javax.xml.soap.SOAPMessage;

public class Client {
    public static void main(String args[]) {
        try {
            SOAPMessageCreator messageCreator = new DezSysSOAPMessageCreator("Cantu");
            SOAPConnector connector = new SOAPConnector(messageCreator, "http://127.0.0.1:8080/datarecords/search");

            SOAPMessage message = connector.call();
            System.out.println(ClientUtils.soapMessageToString(message, true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
