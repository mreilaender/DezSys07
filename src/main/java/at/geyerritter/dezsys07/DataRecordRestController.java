package at.geyerritter.dezsys07;

import at.geyerritter.dezsys07.DataRecordDTO;
import at.geyerritter.dezsys07.MongoDBDataRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value="/datarecords", method = RequestMethod.POST)
    public ResponseEntity<DataRecordDTO> createDataRecord(@RequestBody DataRecordDTO dataRecordDTO) {

        // the id will be set when inserting into the database, so we set it to null now
        dataRecordDTO.setId(null);

        service.create(dataRecordDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
