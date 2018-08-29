package sessionBeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entityBeans.HangSua;

/**
 * Session Bean implementation class HangSuaSB
 */
@Stateless
@LocalBean
public class HangSuaSB implements HangSuaSBLocal {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public HangSuaSB() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public List<HangSua> getAll() {
		return em.createNamedQuery("HangSua.findAll").getResultList();
	}
	@Override
	public HangSua getHangByID(String id) {
		// TODO Auto-generated method stub
		
		return (HangSua) em.createQuery("select hs from HangSua hs where hs.ma_hang_sua = :id")
				.setParameter("id", id)
				.getSingleResult();
	}
	

}
