package sessionBeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entityBeans.HangSua;
import entityBeans.LoaiSua;

/**
 * Session Bean implementation class LoaiSuaSB
 */
@Stateless
@LocalBean
public class LoaiSuaSB implements LoaiSuaSBLocal {
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public LoaiSuaSB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<LoaiSua> docTatCa3() {
		return em.createNamedQuery("LoaiSua.findAll").getResultList();
	}
	
	@Override
	public LoaiSua getLoaiByID(String id) {
		// TODO Auto-generated method stub
		
		return (LoaiSua) em.createQuery("select ls from LoaiSua ls where ls.ma_loai_sua = :id").setParameter("id", id).getSingleResult();
	}

}
