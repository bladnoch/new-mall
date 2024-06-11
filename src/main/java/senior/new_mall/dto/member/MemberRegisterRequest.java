package senior.new_mall.dto.member;

import lombok.Getter;

@Getter
public class MemberRegisterRequest {
    public MemberRegisterRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    private String email;
    private String password;
}
