package at.geyerritter.dezsys07;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoDBConfig extends AbstractMongoConfiguration {

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("192.168.10.200", 27017);
    }

    @Override
    protected String getDatabaseName() {
        return "testdb";
    }


}