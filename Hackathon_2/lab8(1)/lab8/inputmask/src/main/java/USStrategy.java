
public class USStrategy implements IStrategy{

	@Override
	public String display(String num) {
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<num.length();i++)
		{
			switch(i)
			{
			case 1:sb.append("("); break;
			case 4:sb.append(") "); break;
			case 7:sb.append("-"); break;
			}
			sb.append(num.charAt(i));
		}
		return sb.toString();
	}

}
