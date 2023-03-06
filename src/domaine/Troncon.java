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
    return idLigne == troncon.idLigne && stationDepart.equals(troncon.stationDepart)
        && stationArrive.equals(troncon.stationArrive);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idLigne, stationDepart, stationArrive);
  }

  public Station getStationDepart() {
    return stationDepart;
  }

  public void setStationDepart(Station stationDepart) {
    this.stationDepart = stationDepart;
  }

  public Station getStationArrive() {
    return stationArrive;
  }

  public void setStationArrive(Station stationArrive) {
    this.stationArrive = stationArrive;
  }
}
