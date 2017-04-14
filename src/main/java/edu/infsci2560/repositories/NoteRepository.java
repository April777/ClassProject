package edu.infsci2560.repositories;

import edu.infsci2560.models.Note;
import edu.infsci2560.models.NotePk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author April
 */

public interface NoteRepository extends PagingAndSortingRepository<Note, NotePk> {
    Note findByNoteId(Long noteId);
    Page<Note> findByUserId(Long userId, Pageable pageable);
}