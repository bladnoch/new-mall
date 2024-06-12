package senior.new_mall.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import senior.new_mall.domain.member.Member;
import senior.new_mall.domain.member.MemberRepository;
import senior.new_mall.dto.member.MemberLoginRequest;
import senior.new_mall.dto.member.MemberRegisterRequest;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    // register
    @Transactional
    public Long registerMember(MemberRegisterRequest request) {
        // 중복처리
        if (memberRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalStateException();
        } else {
            // 없을경우
            // 저장
            memberRepository.save(new Member(request.getEmail(), request.getPassword()));
            Member member = memberRepository.findByEmail(request.getEmail()).orElseThrow(IllegalArgumentException::new);

            // 리턴 memberId
            return member.getId();
        }
    }

    @Transactional
    public Long loginMember(MemberLoginRequest request) {
        // 등록되어 있는지 조회
        if (memberRepository.findByEmail(request.getEmail()).isPresent()) {
            return memberRepository.findByEmail(request.getEmail()).get().getId();
        } else {
            // 없을경우
            throw new IllegalArgumentException("회원가입 되어 있지 않습니다.");
        }
    }
}
