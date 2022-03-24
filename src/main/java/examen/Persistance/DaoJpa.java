package examen.Persistance;

import examen.Model.Commentary;
import examen.Model.Post;
import examen.Model.PostUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;

public class DaoJpa implements Dao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("examen1");

    @Override
    public <T> void create(T t) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public long createUser(String name) {
        final PostUser postUser = new PostUser(name);
        create(postUser);
        return postUser.getId();
    }

    @Override
    public PostUser getUserById(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<PostUser> query = em.createQuery("select u from PostUser u where u.id = :idToSearch ", PostUser.class);
        query.setParameter("idToSearch", id);
        final PostUser user = query.getSingleResult();

        em.getTransaction().commit();
        em.close();

        return user;
    }

    @Override
    public Post getPostById(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Post> query = em.createQuery("select p from Post p where p.id = :idToSearch ", Post.class);
        query.setParameter("idToSearch", id);
        final Post post = query.getSingleResult();

        em.getTransaction().commit();
        em.close();

        return post;
    }

    @Override
    public long creatComment(long commentaryId, long postId, String comment) {
        Post post = this.getPostById(postId);
        PostUser commentary = this.getUserById(commentaryId);

        final Commentary comment1 = new Commentary(commentary, post, comment);
        create(comment1);
        return comment1.getId();

    }

    @Override
    public long createPost(long posterId, String data, LocalDateTime now) {
        PostUser user = this.getUserById(posterId);
        final Post post = new Post(data, user, now);
        create(post);
        return post.getId();
    }
}
