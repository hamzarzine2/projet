package domaine;

public class Troncon {

  int idLigne,duree;
  Station stationDepart,stationArrive;

  public Troncon(int idLigne, int duree, Station stationDepart, Station stationArrive) {
    this.idLigne = idLigne;
    this.duree = duree;
    this.stationDepart = stationDepart;
    this.stationArrive = stationArrive;
  }
}
