package senior.new_mall.controller.member;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import senior.new_mall.dto.member.MemberLoginRequest;
import senior.new_mall.dto.member.MemberRegisterRequest;
import senior.new_mall.dto.product.ProductCreateRequest;
import senior.new_mall.service.member.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/auth/register")
    public ResponseEntity<?> register(@RequestBody MemberRegisterRequest request) {
        return memberService.registerMember(request);
    }

    @PostMapping("/api/aut/login")
    public ResponseEntity<?> login(@RequestBody MemberLoginRequest request) {
        return memberService.loginMember(request);
    }


}
