
public class Single {
	private static Single single;
	private Single()
	{
		System.out.println("first time");
	}
	public static Single getSingleInstance()
	{
		if(single==null)
		{
			 single=new  Single();
			  return single;
		}
		return single;
	}

}
