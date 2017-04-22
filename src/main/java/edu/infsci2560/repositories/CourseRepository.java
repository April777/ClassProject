package edu.infsci2560.repositories;

import edu.infsci2560.models.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import javax.transaction.Transactional;

/**
 *
 * @author April
 */

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
    public Course findById(Long id);
    @Transactional
    Long deleteById(Long Id);
}