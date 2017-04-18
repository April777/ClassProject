package edu.infsci2560.repositories;

import edu.infsci2560.models.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author April
 */

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}