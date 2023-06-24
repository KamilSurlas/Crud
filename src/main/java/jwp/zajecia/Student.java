package jwp.zajecia;



import org.springframework.boot.context.properties.bind.Name;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "Studenci")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdStudenta;
	private String imie;
	private String nazwisko;
	private int wiek;
	@Enumerated(EnumType.STRING)
	private StopienStudiow stopienStudiow;

	public Student(String imie, String nazwisko, int wiek, StopienStudiow stopienStudiow) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = wiek;
		this.stopienStudiow = stopienStudiow;
	}

	public Student() {

	}


	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public StopienStudiow getStopienStudiow() {
		return stopienStudiow;
	}

	public void setStopienStudiow(StopienStudiow stopienStudiow) {
		this.stopienStudiow = stopienStudiow;
	}

	@Override
	public String toString() {
		return this.getIdStudenta() + this.imie + this.nazwisko + this.wiek;
	}


	public Long getIdStudenta() {
		return IdStudenta;
	}

	public void setIdStudenta(Long idStudenta) {
		IdStudenta = idStudenta;
	}
}
