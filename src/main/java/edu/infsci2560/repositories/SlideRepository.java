package edu.infsci2560.repositories;

import edu.infsci2560.models.Slide;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author April
 */
public interface SlideRepository extends PagingAndSortingRepository<Slide, Long>{
}
