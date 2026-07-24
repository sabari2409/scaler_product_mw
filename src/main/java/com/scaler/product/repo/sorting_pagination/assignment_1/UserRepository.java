package com.scaler.product.repo.sorting_pagination.assignment_1;

import com.scaler.product.model.sorting_pagination.assignment_1.Sex;
import com.scaler.product.model.sorting_pagination.assignment_1.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByAddress(String address, Pageable pageable);

    Page<User> findBySex(Sex sex, Pageable pageable);
}