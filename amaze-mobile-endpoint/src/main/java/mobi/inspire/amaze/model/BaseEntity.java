package mobi.inspire.amaze.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Version;

@Entity
public abstract class BaseEntity {
	
	@Property("id")
	public String _id;
	
	@Property("version")
	public long version;
	
	public BaseEntity() {}

}
