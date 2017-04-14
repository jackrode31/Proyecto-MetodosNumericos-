
public class ErrorRedondeo {
	static float sumNumSimple(int times,float num)
	{
		for(int i=0;i<times;i++)
			num=num+num;
		return num;
	}
	
	static double sumNumDouble(int times,double num)
	{
		for(int i=0;i<times;i++)
			num=num+num;
		return num;
	}
	
	
}
