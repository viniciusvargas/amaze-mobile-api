package mobi.inspire.amaze.services;

import java.lang.reflect.ParameterizedType;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class BaseService<T> {

	protected DB db = null;

	public static final String DbName = "amaze";
	public static final String MongoDbId = "_id";
	protected Gson gson = null;
	protected DBCollection dbCollection = null;
	protected MongoClientProvider mongoClientProvider; 
	private Class<T> type;

	public BaseService(String collectionName) throws UnknownHostException {
		this.gson = new Gson();
		this.mongoClientProvider = new MongoClientProvider();
		type = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		dbCollection = mongoClientProvider.get().getDB(DbName)
				.getCollection(collectionName);
		
	}

	public T get(String id) {
		BasicDBObject query = new BasicDBObject(MongoDbId, id);
		DBObject dbObject = dbCollection.findOne(query);
		T object = gson.fromJson(gson.toJson(dbObject), type);
		return object;
	}

	public List<T> get() {
		DBCursor cursor = dbCollection.find();
		List<T> objectList = new ArrayList<T>();
		for (DBObject dbObject : cursor) {
			T object = gson.fromJson(gson.toJson(dbObject), type);
			objectList.add(object);
		}
		return objectList;
	}

	public List<T> query(String queryParam) {
		if (queryParam == null) {
			return get();
		}
		BasicDBObject query = new BasicDBObject(gson.fromJson(queryParam,
				Map.class));		
		DBCursor cursor = dbCollection.find(query);
		List<T> objectList = new ArrayList<T>();
		for (DBObject dbObject : cursor) {
			T object = gson.fromJson(gson.toJson(dbObject), type);
			objectList.add(object);
		}
		return objectList;
	}
	
	public List<T> query(T object) {
		return query(gson.toJson(object));
	}

	public T post(T object, String id) {
		return save(object, id);
	}

	public T post(T object) {
		return save(object);
	}

	public T put(T object, String id) {
		return save(object, id);
	}

	public T put(T object) {
		return save(object);
	}

	public T save(T object, String id) {
		BasicDBObject dbObject = getBasicDBObject(object);
		dbObject.put(MongoDbId, id);
		return save(dbObject);
	}

	private T save(BasicDBObject dbObject) {
		dbCollection.save(dbObject);
		return get(dbObject.getString(MongoDbId));
	}

	public T save(T object) {
		BasicDBObject dbObject = getBasicDBObject(object);
		if (!dbObject.containsField(MongoDbId)) {
			String id = UUID.randomUUID().toString();
			dbObject.put(MongoDbId, id);
		}
		return save(dbObject);
	}

	private BasicDBObject getBasicDBObject(T object) {
		return gson.fromJson(gson.toJson(object), BasicDBObject.class);
	}

	public void delete(String id) {
		BasicDBObject query = new BasicDBObject(MongoDbId, id);
		dbCollection.findAndRemove(query);
	}

	public void clear() {
		dbCollection.drop();
	}

}
