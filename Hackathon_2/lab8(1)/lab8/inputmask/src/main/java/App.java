/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

/**
 *  Main App Class for Displaying Screen.
 */
public class App {

    private Screen screen;
    private CreditCardNum num;
    private int count;

    public App() {

        screen = new Screen();
        num = new CreditCardNum();
        screen.addSubComponent(num);
        count = 0;

    }

    public String display() {
        String output = "";
        output += "========================================\n";
        output += screen.name() + "\n";
        output += "========================================\n";
        output += "\n\n\n\n";
        output += screen.display() + "\n";
        output += "\n\n\n\n";
        output += "========================================\n";
        return output;
    }

    public void key(String ch) throws Exception{
    	if(ch.matches("0|1|2|3|4|5|6|7|8|9")) 
    	{
        count++;
        screen.key(ch, count);
        }
    	else if(ch.matches("x|X")&&count>0)
    	{
    	 count--;
    	 screen.key(ch, count);
    	}
    
    }

}

