package com.soufiane.book.feedBack;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
    @Query("""
        SELECT feedback
        FROM FeedBack feedback
        WHERE feedback.book.id = :bookId
    """)
    Page<FeedBack> findAllByBookId(Integer bookId, Pageable pageable);
}
