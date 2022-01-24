package tn.essat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.essat.model.Categorie;
import tn.essat.model.Pfe;

@Repository
public interface IPfeDao extends JpaRepository<Pfe, Integer>, JpaSpecificationExecutor<Pfe> {

	//@Query("select p from Pfe p where p.ct.id=?1")
//	public List<Pfe> getAllPfeByCat(int id);
//	  @Query("SELECT u FROM  Pfe u WHERE u.titre like ?1")
//	public Pfe findPfeByTitre(String titre);

	@Query("select p from Pfe p where p.titre = ?1")
	List<Pfe> findByTitre(String titre);

	List<Pfe> findByCategorie_IdEquals(Integer id);

	@Query("select p from Pfe p where p.titre = ?1 and p.categorie.id = ?2")
	List<Pfe> findByTitreAndCategorie_Id(String titre, Integer id);


	@Query("select p from Pfe p where upper(p.titre) like upper(?1)")
	List<Pfe> findByTitreIsLikeIgnoreCase(String titre);

	@Query("select count(p) from Pfe p where p.categorie.id = ?1")
	long countByCategorie_Id(Integer id);

	@Query("select (count(p) > 0) from Pfe p where upper(p.titre) = upper(?1)")
	boolean existsByTitreIgnoreCase(String titre);




/*

	@Query("select count(p) from Pfe p where p.categorie = ?1")
	long countByCategorie(Categorie categorie);
*/

	@Query("select p from Pfe p where upper(p.titre) like upper(concat(?1, '%'))")
	List<Pfe> findByTitreIsStartingWithIgnoreCase(String titre);




	//	@Query("select p from Pfe p where upper(p.titre) like upper(?1)")
//	List<Pfe> findByTitreLikeIgnoreCase(@Nullable String titre);


}
