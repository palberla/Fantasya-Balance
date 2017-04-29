package de.x8bit.Fantasya.Atlantis.Helper;

import de.x8bit.Fantasya.Atlantis.Unit;

public class ConstructionRace {

	/** von dieser Rasse werden Resourcen gespart */
	private Class<? extends Unit> constructionRace = null;

	/** 
	 * diese Items werden gespart ... unter Value steht jedes wievielte Item gespart wird
	 * eine 1 bedeutet eins verwendet eins gespart ... 2 bedeutet zwei verwendet eins gespart
	 */
	private ConstructionContainer constructionItems [] = null;

	public void setConstructionItems(ConstructionContainer constructionItems[])	{ this.constructionItems = constructionItems; }
	public ConstructionContainer[] getConstructionItems() 						{ return constructionItems; }
	public void setConstructionRace(Class<? extends Unit> race) 	{ this.constructionRace = race; }
	public Class<? extends Unit> getConstructionRace() 					{ return constructionRace; }

	public ConstructionRace(Class<? extends Unit> race, ConstructionContainer[] items)
	{
		setConstructionRace(race);
		setConstructionItems(items);
	}
}
