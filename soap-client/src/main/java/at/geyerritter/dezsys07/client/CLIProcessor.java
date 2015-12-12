package at.geyerritter.dezsys07.client;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CLIProcessor {

    public Options getOptions() {

        Options options = new Options();

        Option name = Option.builder().argName("n").longOpt("name")
                .desc("The name that is going to be looked up").required().build();

        Option host = Option.builder().argName("h").longOpt("host")
                .desc("The ip or domain of the application server").build();

        Option port = Option.builder().argName("p").longOpt("port")
                .desc("The port where the application server is running on").build();

        options.addOption(name);
        options.addOption(host);
        options.addOption(port);

        return options;
    }
}
