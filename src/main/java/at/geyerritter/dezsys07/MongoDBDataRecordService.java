package at.geyerritter.dezsys07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public DataRecordDTO create(DataRecordDTO recordDTO) {
        DataRecord persisted = DataRecord.getBuilder()
                .name(recordDTO.getName())
                .description(recordDTO.getDescription())
                .build();

        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }

    @Override
    public DataRecordDTO delete(String id) {
        DataRecord deleted = repository.findOne(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }

    @Override
    public DataRecordDTO findById(String id) throws EmptyResultDataAccessException {
        DataRecord found = repository.findOne(id);
        if (found == null)
            throw new EmptyResultDataAccessException("There is no data record with id " + id, 1);
        return convertToDTO(found);
    }

    @Override
    public List<DataRecordDTO> findTop100ByNameContainingIgnoreCase(String name) {
        List<DataRecord> records = repository.findTop100ByNameContainingIgnoreCase(name);
        return records.stream().map(this::convertToDTO).collect(toList());
    }

    @Override
    public List<DataRecordDTO> findTop100() {
        List<DataRecord> records = repository.findAll(new PageRequest(0, 100)).getContent();

        return records.stream().map(this::convertToDTO).collect(toList());
    }

    @Override
    public DataRecordDTO update(DataRecordDTO recordDTO) {
        DataRecord updated = repository.findOne(recordDTO.getId());
        updated.setName(recordDTO.getName());
        updated.setDescription(recordDTO.getDescription());

        return convertToDTO(updated);
    }

    /**
     * Converts a DataRecord to a related DTO
     *
     * @param record The record that will be converted
     * @return The converted DTO
     */
    private DataRecordDTO convertToDTO(DataRecord record) {
        return new DataRecordDTO(record.getId(), record.getName(), record.getDescription());
    }
}
