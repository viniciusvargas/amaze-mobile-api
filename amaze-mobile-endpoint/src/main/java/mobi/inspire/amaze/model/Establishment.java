package mobi.inspire.amaze.model;

import org.mongodb.morphia.annotations.Entity;

@Entity("establishments")
public class Establishment extends BaseEntity{
	
	public int idEstablishment;
	public String code;
	public String shortName;
	public String longName;
	public String formalName;
	
	public Establishment(){}
}
