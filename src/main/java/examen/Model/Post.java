package examen.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String data;

    @OneToOne
    @JoinColumn(name = "user_id")
    private PostUser user;

    private LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name = "commentary_id")
    private Commentary commentary;

    public Post(String data, PostUser user, LocalDateTime localDateTime) {
        this.data = data;
        this.user = user;
        this.localDateTime = localDateTime;
    }
}
