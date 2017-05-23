import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortStringBYLength {

	public static void main(String[] args) {
		String words="Log file is given with some function start and ending statements";
		String[] split=words.split(" ");
		System.out.println("Total words  :"+split.length);
		Map map=new HashMap<>();
		for (String string : split) {
			map.put(string,string.length());
		}

		 Set<Entry<String, Integer>> set = map.entrySet();
	        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
	        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
	        {
	            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
	            {
	                return (o2.getValue()).compareTo( o1.getValue() );
	            }
	        } );
	        for(Map.Entry<String, Integer> entry:list){
	            System.out.println(entry.getKey()+" ==== "+entry.getValue());
	        }
	        System.out.println(list);
	    }
		
		/*Map mapTOlength=new HashMap<>();
		for (String string : split) {
			mapTOlength.put(string,string.length());
		}
		Set set=mapTOlength.entrySet();
		List mapToList=new ArrayList<>(set);
		
		Collections.sort(mapToList, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				o1.getValue().compareTo(o2.getValue());
				return 0;
			}
		});*/
		
		//System.out.println(set);
	//List list=	Arrays.asList(split);
	//Collections.sort(list);
//	System.out.println(list);
	}

