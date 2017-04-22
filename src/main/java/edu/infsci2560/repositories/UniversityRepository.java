package edu.infsci2560.repositories;

import edu.infsci2560.models.University;
import org.springframework.data.repository.PagingAndSortingRepository;
import javax.transaction.Transactional;

/**
 *
 * @author April
 */

public interface UniversityRepository extends PagingAndSortingRepository<University, Long> {
    public University findById(Long id);
    @Transactional
    Long deleteById(Long Id);
}