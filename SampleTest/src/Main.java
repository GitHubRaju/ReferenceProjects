
public class Main {

public static void main(String[] args) {
	
Single single=Single.getSingleInstance();
Single single1=Single.getSingleInstance();

System.out.println(single==single1);
	}

}
