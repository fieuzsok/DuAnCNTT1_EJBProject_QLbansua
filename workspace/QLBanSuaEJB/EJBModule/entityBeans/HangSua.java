package entityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hang_sua database table.
 * 
 */
@Entity
@Table(name="hang_sua")
@NamedQuery(name="HangSua.findAll", query="SELECT h FROM HangSua h")
public class HangSua implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ma_hang_sua;

	private String dia_chi;

	private String dien_thoai;

	private String email;

	private String ten_hang_sua;

	//bi-directional many-to-one association to Sua
	@OneToMany(mappedBy="hangSua")
	private List<Sua> suas;

	public HangSua() {
	}

	public String getMa_hang_sua() {
		return this.ma_hang_sua;
	}

	public void setMa_hang_sua(String ma_hang_sua) {
		this.ma_hang_sua = ma_hang_sua;
	}

	public String getDia_chi() {
		return this.dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getDien_thoai() {
		return this.dien_thoai;
	}

	public void setDien_thoai(String dien_thoai) {
		this.dien_thoai = dien_thoai;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTen_hang_sua() {
		return this.ten_hang_sua;
	}

	public void setTen_hang_sua(String ten_hang_sua) {
		this.ten_hang_sua = ten_hang_sua;
	}

	public List<Sua> getSuas() {
		return this.suas;
	}

	public void setSuas(List<Sua> suas) {
		this.suas = suas;
	}

	public Sua addSua(Sua sua) {
		getSuas().add(sua);
		sua.setHangSua(this);

		return sua;
	}

	public Sua removeSua(Sua sua) {
		getSuas().remove(sua);
		sua.setHangSua(null);

		return sua;
	}

}