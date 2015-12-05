package at.geyerritter.dezsys07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

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
    public List<DataRecordDTO> findByNameContainingIgnoreCase(String name) {
        List<DataRecord> records = repository.findByNameContainingIgnoreCase(name);
        return records.stream().map(this::convertToDTO).collect(toList());
    }

    @Override
    public List<DataRecordDTO> findAll() {
        List<DataRecord> records = repository.findAll();

        return records.stream().map(this::convertToDTO).collect(toList());
    }

    @Override
    public DataRecordDTO update(DataRecordDTO recordDTO) {
        DataRecord updated = repository.findOne(recordDTO.getId());
        updated.setName(recordDTO.getName());
        updated.setDescription(recordDTO.getDescription());

        return convertToDTO(updated);
    }

    private DataRecordDTO convertToDTO(DataRecord record) {
        return new DataRecordDTO(record.getId(), record.getName(), record.getDescription());
    }
}
