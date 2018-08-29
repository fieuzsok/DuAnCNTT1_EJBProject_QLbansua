package entityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the loai_sua database table.
 * 
 */
@Entity
@Table(name="loai_sua")
@NamedQuery(name="LoaiSua.findAll", query="SELECT l FROM LoaiSua l")
public class LoaiSua implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ma_loai_sua;

	private String ten_loai;

	//bi-directional many-to-one association to Sua
	@OneToMany(mappedBy="loaiSua")
	private List<Sua> suas;

	public LoaiSua() {
	}

	public String getMa_loai_sua() {
		return this.ma_loai_sua;
	}

	public void setMa_loai_sua(String ma_loai_sua) {
		this.ma_loai_sua = ma_loai_sua;
	}

	public String getTen_loai() {
		return this.ten_loai;
	}

	public void setTen_loai(String ten_loai) {
		this.ten_loai = ten_loai;
	}

	public List<Sua> getSuas() {
		return this.suas;
	}

	public void setSuas(List<Sua> suas) {
		this.suas = suas;
	}

	public Sua addSua(Sua sua) {
		getSuas().add(sua);
		sua.setLoaiSua(this);

		return sua;
	}

	public Sua removeSua(Sua sua) {
		getSuas().remove(sua);
		sua.setLoaiSua(null);

		return sua;
	}

}