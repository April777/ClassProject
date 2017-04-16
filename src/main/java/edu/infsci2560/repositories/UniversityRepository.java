package edu.infsci2560.repositories;

import edu.infsci2560.models.University;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author April
 */

public interface UniversityRepository extends PagingAndSortingRepository<University, Long> {
}