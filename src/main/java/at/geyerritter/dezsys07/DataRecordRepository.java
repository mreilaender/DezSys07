package at.geyerritter.dezsys07;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * @author Stefan Geyer
 * @version 20151205.1
 */
public interface DataRecordRepository extends MongoRepository<DataRecord, String> {

    /**
     * Looks for a object with the given name.
     *
     * @param name The name of the {@link DataRecord}
     * @return The DataRecord if found, null otherwise
     */
    List<DataRecord> findByNameContainingIgnoreCase(@Param("name") String name);
}
