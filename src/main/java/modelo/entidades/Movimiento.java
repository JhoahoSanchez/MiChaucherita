package modelo.entidades;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimiento")
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMovimiento;
	@Column(name = "valor")
	private double valor;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "fecha")
	private String fecha;
	@Column(name = "tipo")
	private TipoMovimiento tipoMovimiento;
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "categoria")
	private Categoria categoria;
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "cuenta")
	private Cuenta cuenta;

	public Movimiento() {
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Integer getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	@Override
	public String toString() {
		return "Movimiento [idMovimiento=" + idMovimiento + ", valor=" + valor + ", descripcion=" + descripcion
				+ ", fecha=" + fecha + ", tipoMovimiento=" + tipoMovimiento + ", categoria=" + categoria + ", cuenta="
				+ cuenta + "]";
	}

	public String monthDate() {
		char [] dateC = this.fecha.toCharArray();
		String date = "";
		for (int i = 0; i < 7; i++) {
			date += dateC[i];
		}
		return date;
	}
}
