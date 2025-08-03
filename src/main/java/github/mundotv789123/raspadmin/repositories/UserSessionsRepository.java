package github.mundotv789123.raspadmin.repositories;

import org.springframework.data.repository.CrudRepository;

import github.mundotv789123.raspadmin.models.entities.UserSessionEntity;

import java.util.Calendar;
import java.util.Optional;


public interface UserSessionsRepository extends CrudRepository<UserSessionEntity, Integer> {
    Optional<UserSessionEntity> findByRefreshTokenAndExpireAtGreaterThan(String refreshToken, Calendar expireAt);
}
