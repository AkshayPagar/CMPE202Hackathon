
public class UKStrategy implements IStrategy{

	@Override
	public String display(String num) {
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<num.length();i++)
		{
			switch(i)
			{
			case 2:sb.append(" "); break;
			case 6:sb.append("-"); break;
			}
			sb.append(num.charAt(i));
		}
		return sb.toString();
	}

}
