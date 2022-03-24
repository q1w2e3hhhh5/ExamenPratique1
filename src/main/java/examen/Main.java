package examen;

import examen.Model.Post;
import examen.Persistance.DaoJpa;
import examen.Service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service(new DaoJpa());

        var posterId = service.addPostUser("Poster1");
        var commentaryId = service.addPostUser("Commentary1");
        var postId = service.addPost(posterId, "Mon premier post");
        service.addComment(commentaryId, postId, "My comment 1");

        final Post post = service.getPost(postId);
        System.out.println(post);
    }
}
