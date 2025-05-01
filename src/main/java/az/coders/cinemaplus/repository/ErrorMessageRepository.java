package az.coders.cinemaplus.repository;

import az.coders.cinemaplus.entity.ErrorMessage;
import az.coders.cinemaplus.enums.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ErrorMessageRepository extends JpaRepository<ErrorMessage,Integer> {

    Optional<ErrorMessage> findByErrorCode(ErrorCode errorCode);
}
