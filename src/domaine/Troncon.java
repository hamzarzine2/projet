package domaine;

import java.util.Objects;

public class Troncon {

  int idLigne,duree;
  Station stationDepart,stationArrive;

  public Troncon(int idLigne, Station stationDepart, Station stationArrive, int duree) {
    this.idLigne = idLigne;
    this.duree = duree;
    this.stationDepart = stationDepart;
    this.stationArrive = stationArrive;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Troncon troncon)) {
      return false;
    }
    return idLigne == troncon.idLigne && duree == troncon.duree && getStationDepart().equals(
        troncon.getStationDepart()) && getStationArrive().equals(troncon.getStationArrive());
  }

  @Override
  public int hashCode() {
    return Objects.hash(idLigne, duree, getStationDepart(), getStationArrive());
  }

  public Station getStationDepart() {
    return stationDepart;
  }

  public int getIdLigne() {
    return idLigne;
  }

  public Station getStationArrive() {
    return stationArrive;
  }

  public int getDuree() {
    return duree;
  }

  @Override
  public String toString() {
    return "Troncon{" +
        "idLigne=" + idLigne +
        ", duree=" + duree +
        ", stationDepart=" + stationDepart +
        ", stationArrive=" + stationArrive +
        '}';
  }
}
