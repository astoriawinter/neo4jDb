package astoria;

import astoria.CRUD.AuthorCRUD;
import astoria.CRUD.PageCRUD;
import astoria.CRUD.SpaceCRUD;
import astoria.entity.*;
import astoria.dummymaker.factory.IProduceFactory;
import astoria.dummymaker.factory.impl.GenProduceFactory;
import org.neo4j.ogm.config.Configuration;
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
        List<Space> spaces = iProduceFactory.produce(Space.class, 10);
        List<Attachment> attachments = iProduceFactory.produce(Attachment.class, 5);
        AuthorCRUD authorCRUD = new AuthorCRUD();
        PageCRUD pageCRUD = new PageCRUD();
        Random rand = new Random();
       /* int pageGen, attGen, authorGen, spaceGen, crossedLinks;
        for (Author a: authors) {
            Page page = null;
            Attachment attachment;
            for (int i = 0; i < pages.size() / authors.size(); i++) {
                pageGen = rand.nextInt(30);
                attGen = rand.nextInt(5);
                authorGen = rand.nextInt(10);
                spaceGen = rand.nextInt(10);
                crossedLinks = rand.nextInt(30);
                page = pages.get(pageGen);
                attachment = attachments.get(attGen);
                authorCRUD.link(a, authors.get(authorGen),authors.get(authorGen), page, attachment);
                pageCRUD.link(page, attachment, spaces.get(spaceGen), pages.get(crossedLinks));
            }
            authorCRUD.createOrUpdate(a);
            pageCRUD.createOrUpdate(page);
        } */
        //Long id = authorCRUD.getIdByName("MILAN");
        //Iterable<Page> iterable = getPageOwners("MILAN");
        //SpaceCRUD spaceCRUD = new SpaceCRUD();
        //Long id = spaceCRUD.getIdByName("Silverlight");
        //spaceCRUD.delete(id);
        getInstance().endNeo4jSession();
    }
    public static Iterable<Page> getLinkedPages(String name){
        try {
            Map<String, String> map = new HashMap<>();
            map.put("param", name);
            return sessionFactory.openSession().query(Page.class, "MATCH (n:Page)-[:LINKED]->(m) WHERE m.name = {param} RETURN n", map);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Iterable<Page> getPageInSpace(String name){
        try {
            Map<String, String> map = new HashMap<>();
            map.put("param", name);
            return sessionFactory.openSession().query(Page.class, "MATCH (n:Page)-[:INCLUDED_IN]->(m:Space) m.name={param} RETURN n", map);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Iterable<Page> getAuthorsPagesCreated(String name){
        try {
            Map<String, String> map = new HashMap<>();
            map.put("param", name);
            return sessionFactory.openSession().query(Page.class, "MATCH (n:Author)-[:CREATED]->(m:Page) WHERE n.name={param} RETURN m", map);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Iterable<Page> getAuthorsPagesCommented(String name){
        try {
            Map<String, String> map = new HashMap<>();
            map.put("param", name);
            return sessionFactory.openSession().query(Page.class, "MATCH (n:Author)-[:COMMENTED]->(m:Page) WHERE n.name={param} RETURN m", map);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Iterable<Page> getPageOwners(String name){
        try {
            Map<String, String> map = new HashMap<>();
            map.put("param", name);
            return sessionFactory.openSession().query(Page.class, "MATCH (n:Author)-[:OWN]->(m:Page) WHERE n.name={param} RETURN m", map);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Iterable<Attachment> getAuthorsUploads(String name){
        try {
            Map<String, String> map = new HashMap<>();
            map.put("param", name);
            return sessionFactory.openSession().query(Attachment.class, "MATCH (n:Author)-[:UPLOADED]->(m:Attachment) WHERE n.name={param} RETURN m", map);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Iterable<Page> getPagesIncludesAttachment(String name){
        try {
            Map<String, String> map = new HashMap<>();
            map.put("param", name);
            return sessionFactory.openSession().query(Page.class, "MATCH (n:Page)-[:INCLUDES]->(m:Attachment) WHERE m.name={param} RETURN n", map);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
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
