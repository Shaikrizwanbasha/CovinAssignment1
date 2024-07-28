package Covin.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import Covin.UserEntity.Userentity;
@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<Userentity, Long> {
	

}
