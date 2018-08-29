package sessionBeans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entityBeans.Sua;

/**
 * Session Bean implementation class DanhSachSuaSB
 */
@Stateless
@LocalBean
public class SuaSB implements SuaSBLocal {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public SuaSB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Sua> getSuaByMaHang(String maHangSua) {
		return em.createQuery("Select s from Sua s where s.hangSua.ma_hang_sua = :maHangSua").setParameter("maHangSua",maHangSua).getResultList();
		}

	@Override
	public List<Sua> getLimitByHang(String maHangSua, int from, int to) {
		// TODO Auto-generated method stub
		String sql = "Select s from Sua s where s.hangSua.ma_hang_sua = :maHangSua";
		javax.persistence.Query q = em.createQuery(sql);
		q.setParameter("maHangSua", maHangSua);
		q.setFirstResult(from);
		q.setMaxResults(to);
		return q.getResultList();
	
	
	}

	@Override
	public List<Sua> getSuaByMaLoai(String maLoaiSua) {
		// TODO Auto-generated method stub
		return em.createQuery("Select s from Sua s where s.loaiSua.ma_loai_sua = :maLoaiSua").setParameter("maLoaiSua",maLoaiSua).getResultList();
		
	}

	@Override
	public List<Sua> getLimitByLoai(String maLoaiSua, int from, int amount) {
		// TODO Auto-generated method stub
		String sql = "Select s from Sua s where s.loaiSua.ma_loai_sua = :maLoaiSua";		
		javax.persistence.Query q = em.createQuery(sql);
		q.setParameter("maLoaiSua", maLoaiSua);
		q.setFirstResult(from);
		q.setMaxResults(amount);
		return q.getResultList();
	}

	@Override
	public List<Sua> getDSBanChay() {
		// TODO Auto-generated method stub
		String sql = "SELECT s "
				+ "from Sua s INNER JOIN s.ctHoadons ct "
				+ "group by s.ma_sua  order by sum(ct.so_luong) desc";
					
		javax.persistence.Query q = em.createQuery(sql);
		q.setMaxResults(5);
		return q.getResultList();
	}

	@Override
	public Sua getByMa(String id) {
		// TODO Auto-generated method stub
		return (Sua) em.createQuery("Select s from Sua s where s.ma_sua = :id").setParameter("id",id).getSingleResult();
		
	}

	@Override
	public void insertSua(Sua sua) {
		// TODO Auto-generated method stub
		em.persist(sua);
	}

	@Override
	public List<Sua> findByWord(String word) {
		// TODO Auto-generated method stub
		 String sql = "select s from Sua s where s.ten_sua like '%"+word+"%'";
		return em.createQuery(sql).getResultList();
	}

	@Override
	public List<Sua> findByMaHang(String maHang, String word) {
		// TODO Auto-generated method stub
		String sql = "select s from Sua s where s.ten_sua like '%"+ word +"%'" + " and s.hangSua.ma_hang_sua = :maHang";
		return em.createQuery(sql).setParameter("maHang", maHang).getResultList();
	}
	
	@Override
	public List<Sua> findByLoaiSua(String loaiSua, String word) {
		// TODO Auto-generated method stub
		String sql = "select s from Sua s where s.ten_sua like '%"+ word +"%'" + " and s.loaiSua.ma_loai_sua = :loaiSua";
		return em.createQuery(sql).setParameter("loaiSua", loaiSua).getResultList();
	}

	@Override
	public List<Sua> findByHangAndLoai(String maHang, String maLoai, String word) {
		String sql = "select s from Sua s where s.ten_sua like '%"+ word +"%'" + " and s.loaiSua.ma_loai_sua = :maLoai and s.hangSua.ma_hang_sua = :maHang ";
		javax.persistence.Query q = em.createQuery(sql);
		q.setParameter("maHang", maHang);
		q.setParameter("maLoai", maLoai);
		return q.getResultList();
	
	}

}
