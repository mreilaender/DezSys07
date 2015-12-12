package at.geyerritter.dezsys07.rest;

import at.geyerritter.dezsys07.data.DataRecordDTO;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface DataRecordService {

    /**
     * Persist a DataRecord in the database
     *
     * @param recordDTO The record that will be created and persisted
     * @return The persisted DataRecord
     */
    DataRecordDTO create(DataRecordDTO recordDTO);

    /**
     * Deletes an existing record from the database.
     * The deleted record will be returned
     *
     * @param id The record that will be deleted
     * @return The deleted record
     */
    DataRecordDTO delete(String id);

    /**
     * Finds a specific DataRecord
     *
     * @param id The id of the DataRecord
     * @return The DataRecord if found
     * @throws EmptyResultDataAccessException
     */
    DataRecordDTO findById(String id) throws EmptyResultDataAccessException;

    /**
     * Finds every DataRecord that contains the given name up to a maximum of 100
     *
     * @param name The name that will be searched
     * @return A list of all DataRecords containing the given name
     */
    List<DataRecordDTO> findTop100ByNameContainingIgnoreCase(String name);

    /**
     * Updates a existing DataRecord
     *
     * @param recordDTO The DataRecord that will be updated
     * @return The DTO of the updated DataRecord
     */
    DataRecordDTO update(DataRecordDTO recordDTO);

    List<DataRecordDTO> findTop100();

}
