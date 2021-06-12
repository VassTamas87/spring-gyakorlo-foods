package hu.flowacademy.springgyakorlas.repository;

import hu.flowacademy.springgyakorlas.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
}
