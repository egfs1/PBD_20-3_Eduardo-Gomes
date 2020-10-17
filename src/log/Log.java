package log;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="Log.findAll", 
			query="SELECT l FROM Log l ORDER BY l.id DESC"),
})

@Entity
@Table(name="log")
public class Log {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Date data;
	
	@Column
	private String texto;

	public Log(Date data, String texto) {
		this.data = data;
		this.texto = texto;
	}

	public Log() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public static int[] columnsSize() {
		int[] array = {50, 250, 2300};
		return array;
	}
	
	
}
