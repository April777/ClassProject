package edu.infsci2560.repositories;

import edu.infsci2560.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author April
 */

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}