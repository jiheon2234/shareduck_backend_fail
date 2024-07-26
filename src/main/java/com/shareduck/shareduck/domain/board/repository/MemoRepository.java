package com.shareduck.shareduck.domain.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shareduck.shareduck.domain.board.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long> {
	Page<Memo> findByCategoryIdOrderByIdDesc(long categoryId, Pageable pageable);

}