package at.geyerritter.dezsys07.rest;

import at.geyerritter.dezsys07.data.DataRecord;
import at.geyerritter.dezsys07.data.DataRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * This class accesses the database.
 * The Methods will return DTOs in order to cut the connection
 * of the model classes to the database.
 *
 * @version 20151211.1
 * @author Stefan Geyer
 * @author Mathias Ritter
 */
@Service
public class MongoDBDataRecordService implements DataRecordService {

    private DataRecordRepository repository;

    @Autowired
    MongoDBDataRecordService(DataRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DataRecord create(DataRecord record) {
        record = repository.save(record);
        return record;
    }

    @Override
    public DataRecord delete(String id) {
        DataRecord deleted = repository.findOne(id);
        repository.delete(deleted);
        return deleted;
    }

    @Override
    public DataRecord findById(String id) throws EmptyResultDataAccessException {
        DataRecord found = repository.findOne(id);
        if (found == null)
            throw new EmptyResultDataAccessException("There is no data record with id " + id, 1);
        return found;
    }

    @Override
    public List<DataRecord> findTop100ByNameContainingIgnoreCase(String name) {
        return repository.findTop100ByNameContainingIgnoreCase(name);
    }

    @Override
    public List<DataRecord> findTop100() {
        return repository.findAll(new PageRequest(0, 100)).getContent();
    }

    @Override
    public DataRecord update(DataRecord recordDTO) {

        DataRecord updated = DataRecord.getBuilder()
                .name(recordDTO.getName())
                .description(recordDTO.getDescription())
                .id(recordDTO.getId())
                .build();

        repository.save(updated);
        return updated;
    }
}
