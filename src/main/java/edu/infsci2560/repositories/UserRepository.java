package edu.infsci2560.repositories;

import edu.infsci2560.models.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author April
 */
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findByLastName(String lastName);
}