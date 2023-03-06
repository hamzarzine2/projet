package domaine;

import java.util.Objects;

public class Station {

  String nom;

  public Station(String nom) {
    this.nom = nom;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Station station)) {
      return false;
    }
    return Objects.equals(nom, station.nom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nom);
  }

  public String getNom() {
    return nom;
  }
}
