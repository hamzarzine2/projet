package domaine;

public class Ligne {

  int idLigne,numeroLigne,temps;
  Troncon depart,arrive;
  Type typeTransport;

  public Ligne(int idLigne, int numeroLigne, int temps, Troncon depart, Troncon arrive,Type typeTransport) {
    this.idLigne = idLigne;
    this.numeroLigne = numeroLigne;
    this.temps = temps;
    this.depart = depart;
    this.arrive = arrive;
    this.typeTransport=typeTransport;
  }
}
