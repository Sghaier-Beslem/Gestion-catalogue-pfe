package tn.essat.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.essat.dao.ICategorieDao;
import tn.essat.dao.IPfeDao;
import tn.essat.model.Categorie;
import tn.essat.model.Pfe;

@RestController
@CrossOrigin("*")
public class AppRest {
	@Autowired
	private IPfeDao pfeDao;
	@Autowired
	private ICategorieDao categorieDao;

	public IPfeDao getPfeDao() {
		return pfeDao;
	}

	public void setPfeDao(IPfeDao pfeDao) {
		this.pfeDao = pfeDao;
	}

	public ICategorieDao getCategorieDao() {
		return categorieDao;
	}

	public void setCategorieDao(ICategorieDao categorieDao) {
		this.categorieDao = categorieDao;
	}

	@GetMapping("/listCategorie")
	public List<Categorie> FindCategorie() {
		return categorieDao.findAll();
	}

//	@GetMapping("/listPfe")
//	public List<Pfe> FindPfe() {
//		return pfeDao.findAll();
//	}

	@GetMapping("/listPfe")
	public List<Pfe> chercherPfebytitre(@RequestParam(name = "titre", required = false) String titre) {
		if(titre == null || titre.isEmpty() )
		{
			return pfeDao.findAll();
		}
		//return pfeDao.findByTitreLikeIgnoreCase(titre);
		return pfeDao.findByTitre(titre);
	}
	@GetMapping("/listPfe/categories/{cat}")
	public List<Pfe> chercherPfebyCat(@PathVariable(name = "id") Integer idcat) {
		return pfeDao.findByCategorie_IdEquals(idcat);
	}

	@PostMapping("/addPfe")
	public Pfe createPfe(@RequestBody Pfe pfe) {
		return pfeDao.save(pfe);
	}
	@PostMapping("/addcat")
	public Categorie createcateg(@RequestBody Categorie c) {
		return categorieDao.save(c);
	}

	@PutMapping("/listCategorie/{id}")
	public Categorie updatecat(@PathVariable(name = "id") Integer id, @RequestBody Categorie c) {
		c.setId(id);
		return categorieDao.save(c);

	}
	@PutMapping("/listPfe/{id}")
	public Pfe updatePfe(@PathVariable(name = "id") Integer id, @RequestBody Pfe p) {
		p.setId(id);
		return pfeDao.save(p);

	}

	@DeleteMapping("/listPfe/{id}")
	public void supprimePfe(@PathVariable(name = "id") Integer id) {
		pfeDao.deleteById(id);
	}
	@DeleteMapping("/listCategorie/{id}")
	public void supprimeCat(@PathVariable(name = "id") Integer id) {
		categorieDao.deleteById(id);
	}

}
