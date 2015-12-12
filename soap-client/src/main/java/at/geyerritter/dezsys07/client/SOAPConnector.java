package at.geyerritter.dezsys07.client;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class SOAPConnector {

    private String webServiceURL;

    private SOAPMessageCreator messageCreator;

    public SOAPConnector(SOAPMessageCreator messageCreator, String webServiceURL) {
        this.messageCreator = messageCreator;
        this.webServiceURL = webServiceURL;
    }

    public SOAPMessage call() throws SOAPException {
        // Create SOAP Connection
        SOAPConnectionFactory connectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = connectionFactory.createConnection();

        // Send SOAP Message to the SOAP Server
        SOAPMessage message = connection.call(this.messageCreator.create(), this.webServiceURL);

        // Close the connection
        connection.close();

        return message;
    }

    public String getWebServiceURL() {
        return webServiceURL;
    }

    public void setWebServiceURL(String webServiceURL) {
        this.webServiceURL = webServiceURL;
    }

    public SOAPMessageCreator getMessageCreator() {
        return messageCreator;
    }

    public void setMessageCreator(SOAPMessageCreator messageCreator) {
        this.messageCreator = messageCreator;
    }
}
