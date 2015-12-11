package at.geyerritter.dezsys07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DataRecordViewController {

    @RequestMapping(value = "/datarecords", method = RequestMethod.GET, produces = "text/html")
    public String displayDataRecords() {
        return "greeting";
    }

}
