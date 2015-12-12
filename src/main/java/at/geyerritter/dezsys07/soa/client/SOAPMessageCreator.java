package at.geyerritter.dezsys07.soa.client;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public interface SOAPMessageCreator {

    SOAPMessage create() throws SOAPException;
}
