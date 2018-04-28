// Tristan Tapson
// 001319964
// NOTE!: package was used for all classes, called robot

package robot;

import java.util.ArrayList;

// @brief GenericList class
// @details Class initializes the paths generic list
public class GenericList<T> {
	
	protected ArrayList<T> GenericList = new ArrayList<T>();
	public static final int MAX_SIZE = 100;

	// @brief GenericList constructor
	// @details initializes a generic list
	// @param d the generic list of type T
	public ArrayList<T> GenericList(){
		 GenericList = new ArrayList<T>();
		 return GenericList;
	}
	
	// @brief add method
	// @details inserts object p of type T at position i
	// @param i the index at which the object is to be inserted
	// @param p the object of type T
	// @exception FullSequenceException throws if list size goes over MAX_SIZE
	// @exception InvalidSequenceException throws if the element is already in the list
	public void add(int i, T p) throws FullSequenceException, InvalidPositionException{
		
		ArrayList<T> temp = GenericList;
		
		if(temp.size() == MAX_SIZE ){
			throw new FullSequenceException("Cannot add to set. Set is full.");
		}
		
		if(temp.contains(p)){
			throw new InvalidPositionException("Cannot add to set. Member already exists.");
		}
		
		temp.add(i, p);
		GenericList = temp;
	}
	
	// @brief del method
	// @details deletes an object from position i
	// @param i the index at which the object is to be deleted
	// @exception InvalidSequenceException throws if the element is already in the list
	public void del(int i) throws InvalidPositionException{
		
		ArrayList<T> temp = GenericList;
		
		if(temp.contains(i)){
			throw new InvalidPositionException("Cannot delete from set. Member doesnt exist.");
		}
		
		temp.remove(i);
		GenericList = temp;
	}
	
	// @brief setval method
	// @details sets the value at index i of type T in the generic list
	// @param i the index at which the object is to be set
	// @param p the object of type T
	// @exception InvalidSequenceException throws if the element is already in the list
	public void setval(int i, T p) throws InvalidPositionException{
		
		ArrayList<T> temp = GenericList;
		
		if(temp.contains(i)){
			throw new InvalidPositionException("Cannot change set. Member already exist.");
		}
		
		temp.set(i, p);
		GenericList = temp;
	}
	
	// @brief getval method
	// @details gets the value at index i in the generic list
	// @param i the index at which the object is to be taken from
	// @exception InvalidSequenceException throws if the element is already in the list
	// @return the object gotten
	public T getval(int i) throws InvalidPositionException{
		ArrayList<T> temp = GenericList;
		
		if(temp.contains(i)){
			throw new InvalidPositionException("Cannot get from set. Member doesnt exist.");
		}
		
		temp.get(i);
		GenericList = temp;
		return temp.get(i);
	}
	
	// @brief size method
	// @details gets the size of the generic list
	// @return the size of the list
	public int size(){
		ArrayList<T> temp = GenericList;
		return temp.size();
	}
}
