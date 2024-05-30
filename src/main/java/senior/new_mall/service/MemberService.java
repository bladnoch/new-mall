package senior.new_mall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import senior.new_mall.domain.Member;
import senior.new_mall.domain.MemberRepository;
import senior.new_mall.dto.MemberRegisterRequest;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    public ResponseEntity<?> registerMember(MemberRegisterRequest request) {
        // if member does not exist

        memberRepository.save(new Member(request.getEmail(), request.getPassword()));
        return ResponseEntity.ok().body(
                Map.of("message", "200 ok")
        );
//        if (memberRepository.findByEmail(request.getEmail()).isEmpty()) {
//            return ResponseEntity.badRequest().body(
//                    Map.of("message", "Registration failed", "error", "Member already exist")
//            );
//        }
//
//        // if member exist
//        memberRepository.save(new Member(request.getEmail(), request.getPassword()));
//        return ResponseEntity.ok().body(
//                Map.of("message", "Registeration completed", "member", request)
//        );
    }
}
