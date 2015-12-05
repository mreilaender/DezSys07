package at.geyerritter.dezsys07.controller;

import at.geyerritter.dezsys07.DataRecordDTO;
import at.geyerritter.dezsys07.MongoDBDataRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataRecordRestController {

    @Autowired
    private MongoDBDataRecordService service;

    @RequestMapping(value = "/datarecords", method = RequestMethod.GET)
    public ResponseEntity<List<DataRecordDTO>> findDataRecordsByName() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/datarecords/{id}", method = RequestMethod.GET)
    public ResponseEntity<DataRecordDTO> findDataRecord(@PathVariable String id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
