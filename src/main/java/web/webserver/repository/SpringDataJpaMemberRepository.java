package web.webserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.webserver.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository{

    //JPQL select m from Member m where m.name = ? 를 인터페이스 레벨에서 구현되게 한다.
    @Override
    Optional<Member> findByName(String name);


}
