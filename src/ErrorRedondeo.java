
public class ErrorRedondeo {
	static float sumNumSimple(int times,float num)
	{
		float result=0;
		for(int i=0;i<times;i++)
		{
			result=result+1;
			if(num<Float.MAX_VALUE)
				System.out.println(result);
		
		}
		return result;
	}
	
	static double sumNumDouble(int times,double num)
	{
		double result=0;
		for(int i=0;i<times;i++)
		{
			result=result+1;
			if(num<Float.MAX_VALUE)
				System.out.println(result);
		
		}
		return result;
	}
	
	
}
