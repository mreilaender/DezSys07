package at.geyerritter.dezsys07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.json.Json;
import java.util.List;

@RestController
public class DataRecordRestController {

    @Autowired
    private MongoDBDataRecordService service;

    @RequestMapping(value = "/datarecords", method = RequestMethod.GET)
    public ResponseEntity<List<DataRecordDTO>> findDataRecordsByName(@RequestParam(value = "search", defaultValue = "") String search) {
        if (search.length() == 0)
            return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
        else
            return new ResponseEntity<>(service.findByNameContainingIgnoreCase(search), HttpStatus.OK);
    }


    @RequestMapping(value = "/datarecords/{id}", method = RequestMethod.GET)
    public ResponseEntity<DataRecordDTO> findDataRecord(@PathVariable String id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }


    @RequestMapping(value="/datarecords", method = RequestMethod.POST)
    public ResponseEntity<DataRecordDTO> createDataRecord(@RequestBody DataRecordDTO dataRecordDTO) {

        // the id will be set when inserting into the database, so we set it to null now
        dataRecordDTO.setId(null);

        service.create(dataRecordDTO);


        return new ResponseEntity<>(dataRecordDTO, HttpStatus.CREATED);
    }



    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBadRequest(Exception ex) {
        return generateJsonErrorResponse(HttpStatus.BAD_REQUEST.value(), ex);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(Exception ex) {
        return generateJsonErrorResponse(HttpStatus.NOT_FOUND.value(), ex);
    }

    private String generateJsonErrorResponse(int code, Exception ex) {
        return Json.createBuilderFactory(null).createObjectBuilder()
                .add("code", code)
                .add("message", ex.getMessage()).build().toString();
    }


}
