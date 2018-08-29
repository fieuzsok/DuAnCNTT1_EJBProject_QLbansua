package sessionBeans;

import java.util.List;

import javax.ejb.Local;

import entityBeans.*;
@Local
public interface HangSuaSBLocal {
	List<HangSua> getAll();
	HangSua getHangByID(String id);
}
