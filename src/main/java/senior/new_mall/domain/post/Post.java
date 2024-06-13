package senior.new_mall.domain.post;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import senior.new_mall.domain.member.Member;

@Entity
@Transactional(readOnly = true)
@NoArgsConstructor
@Getter
public class Post {

    public Post(String title, String content,Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id=null;


    private String title;

    @Lob
    private String content;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Member member;



}
