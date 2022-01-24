package tn.essat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Categorie implements Serializable {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	@Column
	private String type;
	//@OneToMany(mappedBy = "categorie")
	//private List<Pfe> pfes;
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
public Categorie(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

/*	public Categorie(Integer id, String type, List<Pfe> pfes) {
		super();
		this.id = id;
		this.type = type;
		this.pfes = pfes;
	}*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/*public List<Pfe> getPfes() {
		return pfes;
	}
	public void setPfes(List<Pfe> pfes) {
		this.pfes = pfes;
	}*/

}
