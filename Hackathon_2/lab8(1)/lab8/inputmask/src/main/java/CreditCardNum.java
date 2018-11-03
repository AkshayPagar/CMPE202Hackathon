/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardNum implements IDisplayComponent, IKeyEventHandler
{

	private IKeyEventHandler nextHandler ;
	private String number = "" ;
	private IStrategy UK=new UKStrategy();
	private IStrategy US=new USStrategy();
	private IStrategy current=null;
	int count=0;

    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {
		String Num="";
		if(current==US)
		{
			Num=US.display(number);
			return "US "+Num;
		}
		else if(current==UK)
		{
			Num=UK.display(number);
			return "UK "+Num;
		}
		else if(current==null) {
		if ( number.equals("") )
			return "  " ;
		else
			return number+ "  " ;
		}
		else
			return Num;
	}	

	public void key(String ch, int cnt) {
		System.err.println("localCount:"+count+"cnt:"+cnt+"Number:"+number);

		if(ch.matches("0|1|2|3|4|5|6|7|8|9")) 
		{
			if ( count < 12 && current==UK )
			{count++;
			number += ch ;}
			else if( count < 11 && current==US )
			{count++;
			number += ch ;}
			else if( count <= 16 && current==null )
			{count++;
			number += ch ;}
		}
		else if(ch.matches("x|X")) 
		{
			if ( count > 0 )
				number = number.substring(0,number.length()-1);		
			count--;
			if(count<=0)
				current=null;	
		}

		if(count==1 && number.equals("1"))
			current=US;

		else if(count==2 && number.equals("44"))
			current=UK;


	}	

	public void addSubComponent( IDisplayComponent c ) {
		return ; // do nothing
	}

}