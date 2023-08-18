package org.zerock.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.zerock.guestbook.entity.Guestbook;

public interface GusetbookRepository
        extends JpaRepository<Guestbook, Long>,
        QuerydslPredicateExecutor<Guestbook>
{

}
