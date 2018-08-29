package sessionBeans;

import java.util.List;

import javax.ejb.Local;

import entityBeans.*;

@Local
public interface LoaiSuaSBLocal {
	List<LoaiSua> docTatCa3();
	LoaiSua getLoaiByID(String id);
}
