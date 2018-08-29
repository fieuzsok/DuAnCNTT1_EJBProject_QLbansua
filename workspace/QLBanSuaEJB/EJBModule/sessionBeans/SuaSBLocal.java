package sessionBeans;

import java.util.List;

import javax.ejb.Local;

import entityBeans.*;

@Local
public interface SuaSBLocal {

	List<Sua> getSuaByMaHang(String maHangSua);
	List<Sua> getLimitByHang(String maHangSua, int from, int amount);
	List<Sua> getSuaByMaLoai(String maLoaiSua);
	List<Sua> getLimitByLoai(String maLoaiSua, int from, int amount);
	List<Sua> getDSBanChay();
	Sua getByMa(String id);
	void insertSua(Sua sua);
	List<Sua> findByWord(String word);
	List<Sua> findByMaHang(String maHang, String word);
	List<Sua> findByLoaiSua(String loaiSua, String word);
	List<Sua> findByHangAndLoai(String maHang, String maLoai, String word);

}
