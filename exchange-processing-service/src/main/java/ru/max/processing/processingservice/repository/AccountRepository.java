package ru.max.processing.processingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.max.processing.processingservice.model.AccountEntity;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    List<AccountEntity> findByUserId(Long userId);

}
