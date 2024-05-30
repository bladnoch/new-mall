package senior.new_mall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import senior.new_mall.domain.Member;
import senior.new_mall.domain.MemberRepository;
import senior.new_mall.dto.MemberLoginRequest;
import senior.new_mall.dto.MemberLoginResponse;
import senior.new_mall.dto.MemberRegisterRequest;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public ResponseEntity<?> registerMember(MemberRegisterRequest request) {
        // if member does not exist
        // register member
        if (memberRepository.findByEmail(request.getEmail()).isEmpty()) {
            memberRepository.save(new Member(request.getEmail(), request.getPassword()));
            return ResponseEntity.ok().body(
                    Map.of("message", "Registeration completed", "member", request)
            );
        }

        // if member exist
        // cancel registration
        return ResponseEntity.badRequest().body(
                Map.of("message", "Registration failed", "error", "Member already exist")
        );
    }

    public ResponseEntity<?> loginMember(MemberLoginRequest request) {

        // not exist
        if (memberRepository.findByEmailAndPassword(request.getEmail(), request.getPassword()).isEmpty()) {
            return ResponseEntity.badRequest().body(
                    Map.of("message", "login failed", "error", "Invalid email or password")
            );
        }
        else {
            // exist
            Member currentMember = memberRepository.findByEmailAndPassword(request.getEmail(), request.getPassword()).orElseThrow(IllegalArgumentException::new);
            MemberLoginResponse response = new MemberLoginResponse(currentMember.getId(), currentMember.getEmail());
            return ResponseEntity.ok().body(
                    Map.of("message", "Login successful", "member", response, "token", "JWT_TOKEN_HERE")
            );
        }
    }
}
