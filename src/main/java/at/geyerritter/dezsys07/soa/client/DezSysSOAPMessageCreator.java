package at.geyerritter.dezsys07.soa.client;

import javax.xml.soap.*;

public class DezSysSOAPMessageCreator implements SOAPMessageCreator {

    private String name;

    private static final String NAMESPACE = "http://at/geyerritter/dezsys07/soa";

    public DezSysSOAPMessageCreator(String name) {
        this.name = name;
    }

    /**
     * The following request will be created: <br>
     * <p>
     * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
     * xmlns:gs="http://at/geyerritter/dezsys07/soa">
     * <soapenv:Header/>
     * <soapenv:Body>
     * <gs:getDataRecordRequest>
     * <gs:name>Ralph</gs:name>
     * </gs:getDataRecordRequest>
     * </soapenv:Body>
     * </soapenv:Envelope>
     *
     * @return The SOAP Request Envelope to search for DataRecords
     * @throws SOAPException Will be thrown if a SOAP related feature fails
     */
    @Override
    public SOAPMessage create() throws SOAPException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("gs", NAMESPACE);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement requestElement = soapBody.addChildElement("getDataRecordRequest", "gs");
        SOAPElement nameElement = requestElement.addChildElement("name", "gs");
        nameElement.addTextNode(this.name);

        // Headers
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", NAMESPACE + "getDataRecordRequest");

        soapMessage.saveChanges();

        return soapMessage;
    }
}
