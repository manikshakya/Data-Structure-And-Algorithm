/*
*	Student name:
*	Student number:
*/
/*
*  Assignment9_2018
*
*		Urban Explorers Problem
*
*  An urban explorer is a person who visits cities and explores them. Each time an explorer 
*  visits a city they record its name. An explorer only visits a city once. 
*  Two classes called Explorer and City are given. In each case they encapsulate a String that 
*  represents the name of an explorer or the name of city. 
*  An outline of the class UrbanExplorers is also given. 
*  The data structure TreeMap<Explorer,TreeSet<City>> is used to model the relationship between 
*  explorers and the cities already visited by them.
*  Your task is to complete the methods listed as part of the interface to this class. 
*  In each case the signature and semantics of the method are given.
*  You must also complete a simple test of these methods.
*
*
*
*
*/

import java.util.*;
public class Assignment9_2018Solution{
	public static void main(String args[]){
	  UrbanExplorers exps = new UrbanExplorers();
		exps.add(new Explorer("Nora"),new City("Paris"));
		exps.add(new Explorer("James"),new City("Paris"));
	  exps.add(new Explorer("Joe"),
	           new TreeSet<City>(Arrays.asList(new City("London"),new City("Paris"),new City("Rome"),new City("Berlin"))));
	  exps.add(new Explorer("Carmel"),
	           new TreeSet<City>(Arrays.asList(new City("Rome"),new City("Paris"),new City("Barcelona"),new City("Berlin"))));
	  exps.add(new Explorer("Paddy"),
	           new TreeSet<City>(Arrays.asList(new City("London"),new City("Paris"),new City("Madrid"),new City("Lyon"))));
	  exps.add(new Explorer("Martina"),
	           new TreeSet<City>(Arrays.asList(new City("Amsterdam"),new City("Paris"),new City("Rome"),new City("Berlin"))));
	  System.out.println(exps.explorers());
	  System.out.println(exps.citiesVisited());
	  System.out.println(exps.visitsPerCity());
	  System.out.println("Visitors to Rome: "+exps.listVisitors("Rome"));
	  
	}

}
final class Explorer implements Comparable<Explorer>{
 	private final String explorer;
 	Explorer(String n){
 		assert n != null && n != "";
 		explorer = n;
 	}
 	String explorer(){return explorer;}
 	public String toString(){return explorer;}
 	public boolean equals(Object ob){
 		if(!(ob instanceof Explorer)) return false;
 		Explorer exp = (Explorer)ob;
 		return explorer.equals(exp.explorer);
	}
	public int hashCode(){return explorer.hashCode();}
	public int compareTo(Explorer exp){
		if(exp == null) return -1;
		return explorer.compareTo(exp.explorer);
	}
}
class City implements Comparable<City>{
 	private  String city;
 	City(String n){
 		assert n != null && n != "";
 		city = n;
 	}
 	String city(){return city;}
 	public String toString(){return city;}
 	public boolean equals(Object ob){
 		if(!(ob instanceof City)) return false;
 		City c = (City)ob;
 		return city.equals(c.city);
	}
	public int hashCode(){return city.hashCode();}
	public int compareTo(City c){
		if(c == null) return -1;
		return city.compareTo(c.city);
	}
}
class UrbanExplorers{
	private TreeMap<Explorer,TreeSet<City>> data;
	UrbanExplorers(){
		data = new TreeMap<>();
	}
	void add(Explorer p, City city){
	  assert p != null && city != null;
	  if(data.containsKey(p))
	  	data.get(p).add(city);
	  else{
	  	TreeSet<City> lst = new TreeSet<>();
	  	lst.add(city);
	  	data.put(p,lst);
	  }
	}
	void add(Explorer p, Set<City> cities){
	  assert p != null && cities != null;
	  if(data.containsKey(p))
	  	data.get(p).addAll(cities);
	  else{
	  	TreeSet<City> lst = new TreeSet<>();
	  	lst.addAll(cities);
	  	data.put(p,lst);
	  }
	}
	Set<City> listCities(Explorer p){
	  assert p != null;
		if(data.containsKey(p)) return new TreeSet<City>(data.get(p));
		return null;
	}
	Set<Explorer> listVisitors(String c){
	  assert c != null;
	  City c1 = new City(c);
		TreeSet<Explorer> lst = new TreeSet<>();
		for(Explorer p : data.keySet())
			if(data.get(p).contains(c1)) lst.add(p);
		return lst;
	}
  Set<Explorer> explorers(){
	   return new TreeSet<Explorer>(data.keySet());
	}
	Set<City> citiesVisited(){
	  	TreeSet<City> lst = new TreeSet<>();
	  	for(Explorer p : data.keySet()){
	  		lst.addAll(data.get(p));
	  	}
	  	return lst;
	}
	Map<City,Integer> visitsPerCity(){
	  TreeMap<City,Integer> mp = new TreeMap<>();
	  for(City c : this.citiesVisited()) mp.put(c,0);
		for(City c : this.citiesVisited()){
	  	for(Explorer p : data.keySet())
	  		if(data.get(p).contains(c))
	  		    mp.put(c,mp.get(c)+1);
	  }
	  return mp;
	}
}