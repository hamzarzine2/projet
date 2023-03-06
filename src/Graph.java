import domaine.Ligne;
import domaine.Station;
import domaine.Troncon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Graph {

  private HashSet<Station> stationsSet =new HashSet<>();
  private HashSet<Troncon> tronconsSet =new HashSet<>();
  private HashSet<Ligne> lignesSet =new HashSet<>();
  private ListeDAdjacence listeDAdjacence=new ListeDAdjacence();
  public Graph() {}
  public Graph(File lignes, File troncons) throws IOException {
    readFile(lignes,"ligne");
    readFile(troncons,"troncon");
  }

  public void calculerCheminMinimisantNombreTroncons(String depart, String arrive) {
    Station departStation= new Station(depart);
    Station arriveStation=new Station(arrive);

    for (Station station : listeDAdjacence.getOutputFlights().keySet()) {
      Set<Troncon> set = listeDAdjacence.getOutputFlights().get(station);
      for (Troncon troncon : set) {
        System.out.println(troncon.getStationArrive().getNom());
      }
    }
    int temps= BFS.search(departStation,arriveStation );
  }

  public void calculerCheminMinimisantTempsTransport(String depart, String arrive) {
  }

  public void readFile(File file,String type) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    while ((st = br.readLine()) != null){
      String [] tabSplit = st.split(",");
      if(type.equals("ligne")){
        Station depart=new Station(tabSplit[2]);
        Station arrive= new Station(tabSplit[3]);
        lignesSet.add(new Ligne(Integer.parseInt(tabSplit[0]),tabSplit[1],depart,arrive,tabSplit[4],Integer.parseInt(tabSplit[5])));
        stationsSet.add(depart);
        stationsSet.add(arrive);

      }else{
        Station depart=new Station(tabSplit[1]);
        Station arrive= new Station(tabSplit[2]);
        Troncon newTroncon=new Troncon(Integer.parseInt(tabSplit[0]),depart,arrive,Integer.parseInt(tabSplit[3]));
        tronconsSet.add(newTroncon);

      }
    }
    for (Station station : stationsSet) {
      listeDAdjacence.ajouterSommet(station);
    }
    for (Troncon troncon : tronconsSet) {
      System.out.println(troncon);
      listeDAdjacence.ajouterArc(troncon);
    }

  }
}
