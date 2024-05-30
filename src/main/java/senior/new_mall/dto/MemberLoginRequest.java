package senior.new_mall.dto;

import lombok.Getter;

@Getter
public class MemberLoginRequest {

    private String email;
    private String password;

    public MemberLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
