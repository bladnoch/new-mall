package senior.new_mall.controller;


import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import senior.new_mall.dto.MemberLoginRequest;
import senior.new_mall.dto.MemberRegisterRequest;
import senior.new_mall.service.MemberService;

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

//    @PostMapping("/api/products")
//    public ProductCreateResponse registerProduct(@RequestBody ProductCreateRequest request) {
//        return memberService.registerProduct(request);
//    }
}
