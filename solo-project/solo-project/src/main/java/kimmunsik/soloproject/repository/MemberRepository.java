package kimmunsik.soloproject.repository;

import kimmunsik.soloproject.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByName(String name);
}
