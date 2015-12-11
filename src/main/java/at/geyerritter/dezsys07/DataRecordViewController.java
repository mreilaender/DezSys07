package at.geyerritter.dezsys07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class DataRecordViewController {

    @Autowired
    private DataRecordRestController restController;

    @RequestMapping(value = "/datarecords", method = RequestMethod.GET, produces = "text/html")
    public String displayDataRecords(Model model) {
        List<DataRecordDTO> dataRecords = restController.findDataRecordsByName("").getBody();
        model.addAttribute("dataRecords", dataRecords);
        return "datarecords";
    }

}
