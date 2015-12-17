package at.geyerritter.dezsys07.soa;

import at.geyerritter.dezsys07.data.DataRecord;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * A generated class that supplies the SOAP application with objects.
 *
 * @author Stefan Geyer
 * @author Mathias Ritter
 * @version 20151217.1
 */
@XmlRegistry
public class ObjectFactory {

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.geyerritter.dezsys07.soa
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDataRecordRequest }
     */
    public GetDataRecordRequest createGetDataRecordRequest() {
        return new GetDataRecordRequest();
    }

    /**
     * Create an instance of {@link GetDataRecordResponse }
     */
    public GetDataRecordResponse createGetDataRecordResponse() {
        return new GetDataRecordResponse();
    }

    /**
     * Create an instance of {@link DataRecord }
     */
    public DataRecord createDataRecord() {
        return new DataRecord();
    }

}
