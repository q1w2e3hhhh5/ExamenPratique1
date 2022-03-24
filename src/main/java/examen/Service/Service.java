package examen.Service;

import examen.Model.Post;
import examen.Persistance.DaoJpa;

import java.time.LocalDateTime;

public class Service {
    private DaoJpa daoJpa;

    public Service(DaoJpa daoJpa) {
        this.daoJpa = daoJpa;
    }

    public long addPostUser(String name) {
        return daoJpa.createUser(name);
    }

    public long addPost(long posterId, String data) {
        return daoJpa.createPost(posterId, data, LocalDateTime.now());
    }

    public long addComment(long commentaryId, long postId, String comment) {
        return daoJpa.creatComment(commentaryId, postId, comment);
    }

    public Post getPost(long postId) {
        return daoJpa.getPostById(postId);
    }
}
