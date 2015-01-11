package bg.fmi.unisofia.piss.appframework.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Dummy")
public class DummyBean implements Persistable {
	
	@Column (name = "Name")
	private String dummyName;
	
	@Column (name = "Value")
	private String dummyValue;
	
	@Id
	private int id;
	
	public DummyBean() {
		//DO NOT USE: Required by hibernate
	}
	
	public String getDummyName() {
		return dummyName;
	}
	
	public void setDummyName(String name) {
		dummyName = name;
	}
	
	public String getDummyValue() {
		return dummyValue;
	}
	
	public void setDummyValue(String value) {
		dummyValue = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int value) {
		id = value;
	}
}
