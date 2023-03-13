import domaine.Station;
import domaine.Troncon;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class ListeDAdjacence {

  private Map<Station, HashSet<Troncon>> outputTroncon;

  public ListeDAdjacence() {
    outputTroncon = new HashMap<Station, HashSet<Troncon>>();

  }


  // Complexit�: 1
  protected void ajouterSommet(Station a) {

    outputTroncon.put(a, new HashSet<>());
  }

  // Complexit�: 1
  protected void ajouterArc(Troncon f) {
    outputTroncon.get(f.getStationDepart()).add(f);

  }

  // Complexit�: 1
  public Set<Troncon> arcsSortants(Station a) {
    //� compl�ter
    return outputTroncon.get(a);
  }

  // Complexit�: n
  public boolean sontAdjacents(Station a1, Station a2) {
    Set<Troncon> a1Set = outputTroncon.get(a1);
    for (Troncon tr : a1Set) {
      if (tr.getStationDepart().equals(a2)) {
        return true;
      }
    }
    Set<Troncon> a2set = outputTroncon.get(a1);
    for (Troncon tr : a2set) {
      if (tr.getStationArrive().equals(a1)) {
        return true;
      }
    }
    return false;
  }


  public LinkedList<Troncon> searchBFS(Station stationDepart, Station stationArrive) {
    LinkedList<Station> stationsFile = new LinkedList<>();
    HashMap<Station, Troncon> tronconPrecedent = new HashMap<>();
    HashSet<Station> stationVisite = new HashSet<>();
    LinkedList<Troncon> routeInverse = new LinkedList<>();

    stationsFile.add(stationDepart);
    stationVisite.add(stationDepart);
    Station sometcourant = stationDepart;
    while (!sometcourant.equals(stationArrive)) {
      sometcourant = stationsFile.pollFirst();
      if (outputTroncon.get(sometcourant) == null) {
        throw new NullPointerException();
      }

      for (Troncon troncon : outputTroncon.get(sometcourant)) {
        if (!stationVisite.contains(troncon.getStationArrive())) {
          stationsFile.add(troncon.getStationArrive());
          stationVisite.add(troncon.getStationArrive());
          tronconPrecedent.put(troncon.getStationArrive(), troncon);
        }
      }
    }
    Station sommet = stationArrive;
    while (sommet != stationDepart) {
      if (tronconPrecedent.get(sommet) == null) {
        break;
      }

      routeInverse.add(tronconPrecedent.get(sommet));
      sommet = tronconPrecedent.get(sommet).getStationDepart();

    }

    return routeInverse;
  }

  public LinkedList searchDijksta(Station stationDepart, Station stationArrive){
    return null;
  }




}
