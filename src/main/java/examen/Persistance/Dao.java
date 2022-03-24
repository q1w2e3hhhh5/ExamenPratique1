package examen.Persistance;

import examen.Model.Post;
import examen.Model.PostUser;

import java.time.LocalDateTime;

public interface Dao {
    <T> void create(T t);

    long createUser(String name);

    long createPost(long posterId, String data, LocalDateTime now);

    PostUser getUserById(long id);

    Post getPostById(long id);

    long creatComment(long commentaryId, long postId, String comment);
}
