package tn.essat.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.essat.dao.ICategorieDao;
import tn.essat.model.Categorie;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategorieDao categorieDao;

    @GetMapping("/{id}")
    public Categorie findCategorieById(@PathVariable(name = "id") Integer id) {
        return categorieDao.findById(id).get();
    }
    @GetMapping
    public List<Categorie> FindCategorie() {
        return categorieDao.findAll();
    }
    @PostMapping("/addcat")
    public Categorie createcateg(@RequestBody Categorie c) {
        return categorieDao.save(c);
    }

    @PutMapping("/{id}")
    public Categorie updatecat(@PathVariable(name = "id") Integer id, @RequestBody Categorie c) {
        c.setId(id);
        return categorieDao.save(c);

    }
    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable(name = "id") Integer id) {
        categorieDao.deleteById(id);
    }
}
