import domaine.Ligne;
import domaine.Station;
import domaine.Troncon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

  private HashMap<String,Station> stationsMap = new HashMap();
  private HashSet<Troncon> tronconsSet = new HashSet<>();
  private HashMap<Integer, Ligne> ligneHashMap = new HashMap<>();
  private ListeDAdjacence listeDAdjacence = new ListeDAdjacence();

  public Graph() {
  }

  public Graph(File lignes, File troncons) throws IOException {
    readFile(lignes, "ligne");
    readFile(troncons, "troncon");
  }

  public void calculerCheminMinimisantNombreTroncons(String depart, String arrive) {
    Station departStation = stationsMap.get(depart);
    Station arriveStation = stationsMap.get(arrive);

    LinkedList<Troncon> route = listeDAdjacence.searchBFS(departStation, arriveStation);
    afficherChemin(route);
  }

  public void calculerCheminMinimisantTempsTransport(String depart, String arrive) {
    Station departStation = stationsMap.get(depart);
    Station arriveStation = stationsMap.get(arrive);

  }


  private void afficherChemin(LinkedList<Troncon> routeInverse){
    HashSet<Integer> ligneVisite = new HashSet<>();

    int dureeTransport = 0;
    int dureeTotal = 0;
    for (Iterator it = routeInverse.descendingIterator(); it.hasNext(); ) {
      Troncon troncon = (Troncon) it.next();
      System.out.println(troncon);
      if (!ligneVisite.contains(troncon.getIdLigne())) {
        dureeTotal += ligneHashMap.get(troncon.getIdLigne()).getTemps();
        ligneVisite.add(troncon.getIdLigne());
      }
      dureeTransport += troncon.getDuree();

    }
    dureeTotal+=dureeTransport;
    System.out.println("nbrTroncons ==> " + routeInverse.size());
    System.out.println("dureeTransport = " + dureeTransport + " duree Total = " + dureeTotal);
  }


  public void readFile(File file, String type) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    while ((st = br.readLine()) != null) {
      String[] tabSplit = st.split(",");
      if (type.equals("ligne")) {
        Station depart = new Station(tabSplit[2]);
        Station arrive = new Station(tabSplit[3]);
        ligneHashMap.put(Integer.parseInt(tabSplit[0]),
            new Ligne(Integer.parseInt(tabSplit[0]), tabSplit[1], depart, arrive, tabSplit[4],
                Integer.parseInt(tabSplit[5])));
        stationsMap.put(depart.getNom(),depart);
        stationsMap.put(arrive.getNom(),arrive);

      } else {
        Station depart = new Station(tabSplit[1]);
        Station arrive = new Station(tabSplit[2]);
        Troncon newTroncon = new Troncon(Integer.parseInt(tabSplit[0]), depart, arrive,
            Integer.parseInt(tabSplit[3]));
        stationsMap.put(depart.getNom(),depart);
        stationsMap.put(arrive.getNom(),arrive);
        tronconsSet.add(newTroncon);

      }
    }
    for (Station station : stationsMap.values()) {
      listeDAdjacence.ajouterSommet(station);
    }
    for (Troncon troncon : tronconsSet) {
      listeDAdjacence.ajouterArc(troncon);
    }

  }


}
