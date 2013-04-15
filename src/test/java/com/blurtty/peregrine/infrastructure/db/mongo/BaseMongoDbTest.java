package com.blurtty.peregrine.infrastructure.db.mongo;

import com.blurtty.peregrine.testing.db.MongodForTestsFactory;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.IOException;
import java.util.Set;

/**
 * <p>Base class to provide the following to MongoDB specific tests</p>
 * <ul>
 * <li>A running instance of MongoDB</li>
 * </ul>
 *
 * @since 0.0.1
 *         
 */
public class BaseMongoDbTest {

  private static MongodForTestsFactory factory = null;

  protected static DB db;

  @BeforeClass
  public static void beforeClass() throws IOException {
    db = getNewMongoDB();
  }

  @AfterClass
  public static void afterClass() {
    shutdownMongoDB();
  }

  protected static DB getNewMongoDB() throws IOException {
    initFactory();
    Mongo mongo = factory.newMongo();
    return factory.newDB(mongo);
  }

  private static void initFactory() throws IOException {
    if (factory == null)
      factory = new MongodForTestsFactory();
  }

  protected static void shutdownMongoDB() {
    if (factory != null) {
      factory.shutdown();
    }
  }

  protected void dropAllCollections(DB db) {
    Set<String> collectionNames = db.getCollectionNames();
    for (String name : collectionNames) {
      DBCollection collection = db.getCollection(name);
      try {
        collection.drop();
      } catch (RuntimeException e) {
        // ignore
      }
    }
  }
}