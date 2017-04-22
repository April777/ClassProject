package edu.infsci2560.repositories;

import edu.infsci2560.models.School;
import org.springframework.data.repository.PagingAndSortingRepository;
import javax.transaction.Transactional;

/**
 *
 * @author April
 */

public interface SchoolRepository extends PagingAndSortingRepository<School, Long> {
    public School findById(Long id);
    @Transactional
    Long deleteById(Long Id);
}