
public class SpaceDecorator implements Decorator{
	static String Country="";
	
	@Override
	public String decorator(String N) {
		String Value=N;
		int count=N.length();
		StringBuilder sb=new StringBuilder();
		if(Value.charAt(0)=='1')
		{
			Country="US";
			sb.append(Country);
		}
		if(Value.length()>=2&& Value.charAt(0)=='4' && Value.charAt(1)=='4')
		{
			Country="UK";
			sb.append(Country);
		}		
		
		for(int i=0;i<count;i++)
		{
			if(Country.equals("US"))
			{
				switch(i)
				{
				case 1:sb.append(" ("); break;
				case 4:sb.append(") "); break;
				case 7:sb.append("-"); break;
				}
				sb.append(Value.charAt(i));
			}
			if(Country.equals("UK"))
			{
				switch(i)
				{
				case 2:sb.append(" ("); break;
				case 5:sb.append(") "); break;
				case 10:sb.append(" "); break;
				}
				sb.append(Value.charAt(i));
			}
		}
		
		return sb.toString();
	}

}
