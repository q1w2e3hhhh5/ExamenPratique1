package examen.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Commentary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PostUser user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private String myComment;

    public Commentary(PostUser user, Post post, String myComment) {
        this.user = user;
        this.post = post;
        this.myComment = myComment;
    }
}
