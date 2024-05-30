package senior.new_mall.dto;

import lombok.Getter;

@Getter
public class MemberLoginResponse {
    private Long id;
    private String email;

    public MemberLoginResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
