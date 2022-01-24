package tn.essat.rest;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import tn.essat.dao.ICategorieDao;
import tn.essat.dao.IPfeDao;
import tn.essat.model.Categorie;
import tn.essat.model.Pfe;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pfes")
public class PfeController {

    @Autowired
    private IPfeDao pfeDao;
    @Autowired
    private ICategorieDao categorieDao;
    @GetMapping
    public List<Pfe> searchPfe(@RequestParam(name = "titre", required = false) String titre, @RequestParam(name = "id",required = false) Integer id) {
        if((titre == null || titre.isEmpty())&& id== null)
        {
            return pfeDao.findAll();
        }
        else if(id==null) {
            return pfeDao.findByTitreIsStartingWithIgnoreCase(titre);
        }
        else if(titre == null || titre.isEmpty())
        {
            return pfeDao.findByCategorie_IdEquals(id);
        }
        else
            return  pfeDao.findByTitreAndCategorie_Id(titre,id);
    }
    @GetMapping("/count")
    public Long countPfe(@RequestParam(name = "id",required = false) Integer id) {
        if(id == null ) {
            return pfeDao.count();
        }
        else
            return pfeDao.countByCategorie_Id(id);
    }
 /* @GetMapping("/categories/{id}")
    public List<Pfe> chercherPfebyCat(@RequestParam(name = "id",required = false) Integer idcat) {
      if(idcat == null  )
      {
          return pfeDao.findAll();
      }
        return pfeDao.findByCategorie_IdEquals(idcat);
    }*/
    @PostMapping
    public Pfe createPfe(@RequestBody Pfe pfe ){
    return pfeDao.save(pfe);
    }
    @DeleteMapping("/{id}")
    public void deletePfe(@PathVariable(name = "id") Integer id) {
        pfeDao.deleteById(id);
    }
    @PutMapping("/{id}")
    public Pfe updatePfe(@PathVariable(name = "id") Integer id, @RequestBody Pfe p) {
        p.setId(id);
        return pfeDao.save(p);

    }

}
