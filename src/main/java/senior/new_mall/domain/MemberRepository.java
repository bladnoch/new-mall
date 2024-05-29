package senior.new_mall.domain;

import org.springframework.data.jpa.repository.JpaRepository;



public interface MemberRepository extends JpaRepository<Member, Long> {
}
