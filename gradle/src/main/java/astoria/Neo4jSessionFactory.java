package astoria;

import astoria.CRUD.AuthorCRUD;
import astoria.CRUD.CommentCRUD;
import astoria.CRUD.PageCRUD;
import astoria.entity.*;
import astoria.dummymaker.factory.IProduceFactory;
import astoria.dummymaker.factory.impl.GenProduceFactory;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import java.util.*;

public class Neo4jSessionFactory {
    private static final Configuration configuration = new Configuration.Builder()
            .uri("bolt://localhost")
            .credentials("neo4j", "12345")
            .connectionLivenessCheckTimeout(1000)
            .build();
    private static final IProduceFactory factoryProduce = new GenProduceFactory();
    private static final SessionFactory sessionFactory = new SessionFactory(configuration, "astoria.entity");
    public static void main(String[] args){
        IProduceFactory iProduceFactory = Neo4jSessionFactory.getFactory();
        List<Author> authors = iProduceFactory.produce(Author.class, 10);
        List<Page> pages = iProduceFactory.produce(Page.class, 30);
        List<Comment> comments = iProduceFactory.produce(Comment.class, 20);
        List<Space> spaces = iProduceFactory.produce(Space.class, 10);
        List<Attachment> attachments = iProduceFactory.produce(Attachment.class, 5);
        AuthorCRUD authorCRUD = new AuthorCRUD();
        CommentCRUD commentCRUD = new CommentCRUD();
        PageCRUD pageCRUD = new PageCRUD();
        Random rand = new Random();
        int pageGen, attGen, commGen, spaceGen, crossedLinks;
        for (Author a: authors) {
            Comment comment = null;
            Page page = null;
            Attachment attachment;
            for (int i = 0; i < pages.size() / authors.size(); i++) {
                pageGen = rand.nextInt(30);
                attGen = rand.nextInt(5);
                commGen = rand.nextInt(20);
                spaceGen = rand.nextInt(10);
                crossedLinks = rand.nextInt(30);
                comment = comments.get(commGen);
                page = pages.get(pageGen);
                attachment = attachments.get(attGen);
                authorCRUD.link(a, authors.get(spaceGen), page, attachment);
                commentCRUD.link(comment, a, page);
                pageCRUD.link(page, attachment, spaces.get(spaceGen), pages.get(crossedLinks));
            }
            authorCRUD.createOrUpdate(a);
            commentCRUD.createOrUpdate(comment);
            pageCRUD.createOrUpdate(page);
        }

        List<Page> pages1 = new ArrayList<>();
        //getLinkedPages(473L).forEach(page -> pages1.add(page));
        System.out.println(pages1);
        // Page page = pageCRUD.find(473L);
        getInstance().endNeo4jSession();
    }
    public static Iterable<Page> getLinkedPages(Long id){
        try {
            Map<String, Long> map = new HashMap<>();
            map.put("param", id);
            return sessionFactory.openSession().query(Page.class, "MATCH (n:Page)-[:LINKED]->(m) WHERE ID(m)={param} RETURN n", map);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Iterable<Page> getPageInSpace(Long id){
        try {
            Map<String, Long> map = new HashMap<>();
            map.put("param", id);
            return sessionFactory.openSession().query(Page.class, "MATCH (n:Page)-[:INCLUDED_IN]->(m:Space) WHERE ID(m)={param} RETURN n", map);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Iterable<Page> getAuthorsPages(Long id){
        try {
            Map<String, Long> map = new HashMap<>();
            map.put("param", id);
            return sessionFactory.openSession().query(Page.class, "MATCH (n:Author)-[:CREATED]->(m:Page) WHERE ID(n)={param} RETURN m", map);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Iterable<Page> getAuthorsComments(Long id){
        try {
            Map<String, Long> map = new HashMap<>();
            map.put("param", id);
            return sessionFactory.openSession().query(Page.class, "MATCH (n:Comment)-[:WROTE_BY]->(m:Author) WHERE ID(m)={param} RETURN n", map);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Iterable<Page> getAuthorsUploads(Long id){
        try {
            Map<String, Long> map = new HashMap<>();
            map.put("param", id);
            return sessionFactory.openSession().query(Page.class, "MATCH (n:Author)-[:UPLOADED]->(m:Attachment) WHERE ID(n)={param} RETURN m", map);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Iterable<Page> getPagesIncludesAttachment(Long id){
        try {
            Map<String, Long> map = new HashMap<>();
            map.put("param", id);
            return sessionFactory.openSession().query(Page.class, "MATCH (n:Page)-[:INCLUDES]->(m:Attachment) WHERE ID(m)={param} RETURN n", map);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //eto govno ne rabotyaet govno jopa.
    //MATCH (n:Author)-[:CREATED]-(m:Page)-[:INCLUDED_IN]->(s:Space) WHERE ID(n)=316 RETURN s
    private static Neo4jSessionFactory factory = new Neo4jSessionFactory();

    public static Neo4jSessionFactory getInstance() {
        return factory;
    }
    private Neo4jSessionFactory() {
    }
    public static IProduceFactory getFactory() {
        return factoryProduce;
    }
    public Session getNeo4jSession() {
        return sessionFactory.openSession();
    }
    public void endNeo4jSession(){
        sessionFactory.close();
    }
}
