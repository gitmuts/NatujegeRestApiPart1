package com.gitmuts.NatujengeAPIDemo.repo;

import com.gitmuts.NatujengeAPIDemo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepo extends PagingAndSortingRepository<User, Long> {

    List<User> findAll();

    Page<User> findAllByOrderByIdDesc(Pageable pageable);

    Page<User> findAllByNameContainingOrUsernameContainingOrderByIdDesc(String name,String username, Pageable pageable);

}
