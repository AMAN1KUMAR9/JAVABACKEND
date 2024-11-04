package complex.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Complex {

    private String name;

    @Id
    private Long id;

    private Date date;

    @ElementCollection
    private List<String> subjects;

    private String gender;
    private String type;
    
    @Embedded
    private Address address;

    public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// Constructors, getters, and setters
    public String getName() {
        return name;
    }

    public Complex(String name, Long id, Date date, List<String> subjects, String gender, String type,
			Address address) {
		super();
		this.name = name;
		this.id = id;
		this.date = date;
		this.subjects = subjects;
		this.gender = gender;
		this.type = type;
		this.address = address;
	}

	public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
	public String toString() {
		return "Complex [name=" + name + ", id=" + id + ", date=" + date + ", subjects=" + subjects + ", gender="
				+ gender + ", type=" + type + ", address=" + address + "]";
	}

    public Complex(String name, Long id, Date date, List<String> subjects, String gender, String type) {
        super();
        this.name = name;
        this.id = id;
        this.date = date;
        this.subjects = subjects;
        this.gender = gender;
        this.type = type;
    }

    public Complex() {
        super();
    }
}
