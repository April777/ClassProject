package edu.infsci2560.repositories;

import edu.infsci2560.models.Course;
import edu.infsci2560.models.CoursePk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author April
 */

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}