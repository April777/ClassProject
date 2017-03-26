package edu.infsci2560.repositories;

import edu.infsci2560.models.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author April
 */

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long>{
}
