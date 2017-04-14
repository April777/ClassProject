package edu.infsci2560.repositories;

import edu.infsci2560.models.Comment;
import edu.infsci2560.models.CommentPk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author April
 */

public interface CommentRepository extends PagingAndSortingRepository<Comment, CommentPk> {
    Page<Comment> findByNoteId(Long noteId, Pageable pageable);
}