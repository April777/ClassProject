package edu.infsci2560.repositories;

import edu.infsci2560.models.Note;
import org.springframework.data.repository.PagingAndSortingRepository;
import javax.transaction.Transactional;

/**
 *
 * @author April
 */

public interface NoteRepository extends PagingAndSortingRepository<Note, Long> {
    @Transactional
    Long deleteById(Long Id);
}