package at.geyerritter.dezsys07;

import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface DataRecordService {

    DataRecordDTO create(DataRecordDTO todo);

    DataRecordDTO delete(String id);

    DataRecordDTO findById(String id) throws EmptyResultDataAccessException;

    List<DataRecordDTO> findByNameContainingIgnoreCase(String name);

    List<DataRecordDTO> findAll();

    DataRecordDTO update(DataRecordDTO todo);

}
