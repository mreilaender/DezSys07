package at.geyerritter.dezsys07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.WebContext;

import java.util.List;

/**
 *
 *
 * Unfortunately, there is a bug in IntelliJ IDEA so context variables do not get resolved in thymeleaf templates <br />
 * It will be fixed in version 15.1 (release on March 1st, 2016) <br />
 * For more info visit https://youtrack.jetbrains.com/issue/IDEA-132738 <br />
 * As a workaround you have to add all attributes again in a new WebContext (see if statements in the methods of this class)
 *
 */
@Controller
public class DataRecordViewController {

    @Autowired
    private DataRecordRestController restController;

    @RequestMapping(value = "/datarecords", method = RequestMethod.GET, produces = "text/html")
    public String displayDataRecords(@RequestParam(value = "name", defaultValue = "") String name, Model model) {
        List<DataRecordDTO> dataRecords = restController.findDataRecordsByName(name).getBody();
        model.addAttribute("dataRecords", dataRecords);

        // IntelliJ bug workaround (see class comment)
        if (false) {
            WebContext context = new org.thymeleaf.context.WebContext(null, null, null);
            context.setVariable("dataRecords", dataRecords);
        }

        return "datarecords";
    }

    @RequestMapping(value = "/datarecords/{id}", method = RequestMethod.GET, produces = "text/html")
    public String displayDataRecord(@PathVariable String id, Model model) {
        DataRecordDTO dataRecord = restController.findDataRecord(id).getBody();
        model.addAttribute("dataRecord", dataRecord);

        // IntelliJ bug workaround (see class comment)
        if (false) {
            WebContext context = new org.thymeleaf.context.WebContext(null, null, null);
            context.setVariable("dataRecord", dataRecord);
        }

        return "edit";
    }

}
