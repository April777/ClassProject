package edu.infsci2560.repositories;

import edu.infsci2560.models.Semester;
import org.springframework.data.repository.PagingAndSortingRepository;
import javax.transaction.Transactional;

/**
 *
 * @author April
 */

public interface SemesterRepository extends PagingAndSortingRepository<Semester, Long> {
    public Semester findById(Long id);
    @Transactional
    Long deleteById(Long Id);
}