package senior.new_mall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senior.new_mall.domain.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

}
