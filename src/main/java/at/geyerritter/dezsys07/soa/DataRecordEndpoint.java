package at.geyerritter.dezsys07.soa;

import at.geyerritter.dezsys07.DataRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DataRecordEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private DataRecordRepository dataRecordRepository;

    @Autowired
    public DataRecordEndpoint(DataRecordRepository dataRecordRepository) {
        this.dataRecordRepository = dataRecordRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetDataRecordResponse getDataRecord(@RequestPayload GetDataRecordRequest request) {
        GetDataRecordResponse response = new GetDataRecordResponse();
        response.setDataRecord(dataRecordRepository.findOne(request.getName()));

        return response;
    }
}
