

import java.io.Serializable;
import java.util.List;

public class Topic implements Serializable{
	private int id;
	private List<String> keywords;
	public String name;
	public Topic(int i, List<String> l, String n){
		id = i;
		keywords = l;
		name = n;
	}
}
