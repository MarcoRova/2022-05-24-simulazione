package it.polito.tdp.itunes.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.itunes.db.ItunesDAO;

public class Model {
	
	private ItunesDAO dao;
	private Graph<Track, DefaultWeightedEdge> grafo;
	private List<Track> vertici;
	private Map<Integer, Track> mapTrackId = new HashMap<>();
 
	public Model() {
		this.dao = new ItunesDAO();
		
		for(Track t : this.dao.getAllTracks()) {
			this.mapTrackId.put(t.getTrackId(), t);
		}
	}
	
	
	public void creaGrafo(Genre g) {
		
		this.grafo = new SimpleWeightedGraph<Track, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		this.vertici = this.dao.getTracksByGenre(g);
		
		Graphs.addAllVertices(this.grafo, vertici);
		
		aggiungiArchi(g);
		
		
		
	}
	
	
	public void aggiungiArchi(Genre g) {
		
		List<Arco> archi = this.dao.getArchi(g);
		
		for(Arco a : archi) {
			
			if(this.grafo.containsVertex(this.mapTrackId.get(a.getT1())) && this.grafo.containsVertex(this.mapTrackId.get(a.getT2()))) {
				
				double peso = Math.abs(a.getDelta());
				
				Graphs.addEdgeWithVertices(this.grafo, this.mapTrackId.get(a.getT1()), this.mapTrackId.get(a.getT2()), peso);
				
			}	
		}
	}
	
	public List<DeltaMassimo> getDeltaMassimo(){
		double max = 0;
		List<DeltaMassimo> deltaMax = new ArrayList<>();
		
		for(DefaultWeightedEdge d : this.grafo.edgeSet()) {
			double grado = grafo.getEdgeWeight(d);

			if(grado>max) {
				
				deltaMax.clear();
				
				Track t2 = this.grafo.getEdgeSource(d);
				Track t1 = this.grafo.getEdgeTarget(d);
				double p = grado;
				max=grado;
				
				deltaMax.add(new DeltaMassimo(t1.getName(), t2.getName(), p));
			}
		}
		return deltaMax;

	}
	
	public String infoGrafo() {
		return "Grafo creato!\n#Vertici: "+this.grafo.vertexSet().size()+"\n#Archi: "+this.grafo.edgeSet().size();
	}
	
	
	public List<Genre> getAllGenres(){
		return this.dao.getAllGenres();
	}
	
	
	
	
}
