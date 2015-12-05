package at.geyerritter.dezsys07.controller;

import at.geyerritter.dezsys07.DataRecord;
import at.geyerritter.dezsys07.DataRecordDTO;
import at.geyerritter.dezsys07.MongoDBDataRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataRecordRestController {

    @Autowired
    private MongoDBDataRecordService service;

    @RequestMapping(value="/datarecords", method= RequestMethod.GET)
    public ResponseEntity<DataRecordDTO> findDataRecordsByName(@RequestParam(value = "name", defaultValue = "") String name) {

        if (name.length() < 3)
            return new ResponseEntity<DataRecordDTO>(HttpStatus.LENGTH_REQUIRED);

        return new ResponseEntity<DataRecordDTO>(service.findByName(name), HttpStatus.OK);
    }


    @RequestMapping(value="/datarecords/{id}", method= RequestMethod.GET)
    public ResponseEntity<DataRecordDTO> findDataRecord(@PathVariable String id) {
        try {
            return new ResponseEntity<DataRecordDTO>(service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<DataRecordDTO>(HttpStatus.NOT_FOUND);
        }
    }


}
