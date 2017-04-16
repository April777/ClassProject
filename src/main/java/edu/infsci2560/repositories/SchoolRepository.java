package edu.infsci2560.repositories;

import edu.infsci2560.models.School;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author April
 */

public interface SchoolRepository extends PagingAndSortingRepository<School, Long> {
}