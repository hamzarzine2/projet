package domaine;

import java.util.Objects;

public class Ligne {

  int idLigne,temps;
  Station depart,arrive;
  String typeTransport,numeroLigne;

  public Ligne(int idLigne, String numeroLigne,Station depart, Station arrive,String typeTransport, int temps) {
    this.idLigne = idLigne;
    this.numeroLigne = numeroLigne;
    this.temps = temps;
    this.depart = depart;
    this.arrive = arrive;
    this.typeTransport=typeTransport;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Ligne ligne)) {
      return false;
    }
    return idLigne == ligne.idLigne;
  }

  @Override
  public int hashCode() {
    return Objects.hash(idLigne);
  }

  public int getIdLigne() {
    return idLigne;
  }

  public int getTemps() {
    return temps;
  }

  public Station getDepart() {
    return depart;
  }

  public Station getArrive() {
    return arrive;
  }

  public String getTypeTransport() {
    return typeTransport;
  }

  public String getNumeroLigne() {
    return numeroLigne;
  }
}
