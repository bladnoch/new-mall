package senior.new_mall.controller.member;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import senior.new_mall.dto.member.MemberLoginRequest;
import senior.new_mall.dto.member.MemberRegisterRequest;
import senior.new_mall.service.member.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // register
    @PostMapping("/register")
    public Long register(@RequestBody MemberRegisterRequest request) { // email, password
        // memberId 반환
        return memberService.registerMember(request);
    }

    // login
    @PostMapping("login")
    public Long login(@RequestBody MemberLoginRequest request) { // email, password
        // memberId 반환
        // id, pw 확인
        return memberService.loginMember(request);
    }
}
