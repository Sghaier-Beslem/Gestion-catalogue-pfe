package tn.essat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pfe implements Serializable{
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	private String titre;
	@ManyToOne
	@JoinColumn(name = "categorie_id")
	private Categorie categorie;
	public Pfe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pfe(Integer id, String titre, Categorie categorie) {
		super();
		this.id = id;
		this.titre = titre;
		this.categorie = categorie;
	}

	public Pfe(String titre, Categorie categorie) {
		this.titre = titre;
		this.categorie = categorie;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return "Pfe [id=" + id + ", titre=" + titre + ", categorie=" + categorie + "]";
	}

}
