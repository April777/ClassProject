package edu.infsci2560.repositories;

import edu.infsci2560.models.Semester;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author April
 */

public interface SemesterRepository extends PagingAndSortingRepository<Semester, Long> {
}