import domaine.Station;
import domaine.Troncon;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ListeDAdjacence{

  private Map<Station,HashSet<Troncon>> outputFlights;

  public ListeDAdjacence(){
    outputFlights=new HashMap<Station,HashSet<Troncon>>();

  }

  public Map<Station, HashSet<Troncon>> getOutputFlights() {
    return outputFlights;
  }

  // Complexit�: 1
  protected void ajouterSommet(Station a) {
    if(!outputFlights.containsKey(a)){
      outputFlights.put(a,new HashSet<>());
    }
  }

  // Complexit�: 1
  protected void ajouterArc(Troncon f) {
    if(outputFlights.containsKey(f.getStationDepart())){
      outputFlights.get(f.getStationDepart()).add(f);
    }
  }

  // Complexit�: 1
  public Set<Troncon> arcsSortants(Station a) {
    //� compl�ter
    return outputFlights.get(a);
  }

  // Complexit�: n
  public boolean sontAdjacents(Station a1, Station a2) {
    Set<Troncon> a1Set = outputFlights.get(a1);
    for (Troncon flight : a1Set) {
      if(flight.getStationDepart()==a2)return true;
    }
    Set<Troncon> a2set = outputFlights.get(a1);
    for (Troncon flight : a2set) {
      if(flight.getStationArrive()==a1)return true;
    }
    return false;
  }

}
