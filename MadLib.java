//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String story = "";

	public MadLib()
	{
		verbs.add("punched");
		nouns.add("Wal-Mart");
		adjectives.add("massive");
		story="I punched Wal-Mart in a massive way.";
	}

	public MadLib(String fileName)
	{
		//load stuff
		loadNouns();
		loadAdjectives();
		loadVerbs();
		try
		{  
			Scanner reader = new Scanner(new File("story.dat"));

			while(reader.hasNext())
			{
				story+=reader.hasNext();
			}

			Scanner chop = new Scanner(story)
			String sym = "";
			String returnStr = "";
			while(chop.hasNext())
				sym = chop.next();
				if (sym.equals("#"))
					returnStr += getRandomNoun();
				else if	(sym.equals("@"))
					returnStr += getRandomVerb();
				else if (sym.equals("&"))
					returnStr += getRandomAdjective();	
				else	
					returnStr += story;
			
			//Read the different parts of the story and concatenate the resulting
			//story using the symbols to tell you the parts of speech
		
		
		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}

	}

	public void loadNouns()
	{
		try
		{
			Scanner reader = new Scanner(new File("nouns.dat"));

			while(reader.hasNext())
			{
				nouns.add(reader.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("nouns.dat does not exist");
		}

	}

	public void loadVerbs()
	{
		try
		{
			Scanner scan = new Scanner(new File("verbs.dat"));

			while(scan.hasNext())
			{
				verbs.add(scan.next());
			}

		}
		catch(Exception e)
		{
			System.out.println("verbs.dat does not exist");
		}
	}

	public void loadAdjectives()
	{
		try
		{
			Scanner scan = new Scanner(new File("adjectives.dat"));

			while(scan.hasNext())
			{
				adjectives.add(scan.next());
			}

		}
		catch(Exception e)
		{
			System.out.println("adjectives.dat does not exist");
		}
	}

	public String getRandomVerb()
	{
		//verbs.get(((int)(Math.random()*14 +1)));
		return "" + verbs.get(((int)(Math.random()*14 +1)));
	}

	public String getRandomNoun()
	{
		return "" + nouns.get(((int)(Math.random()*19 +1)));
	}

	public String getRandomAdjective()
	{
		return "" + adjectives.get(((int)(Math.random()*17 +1)));
	}

	public String toString()
	{
		return "" + verbs + adjectives + nouns;
	}
}