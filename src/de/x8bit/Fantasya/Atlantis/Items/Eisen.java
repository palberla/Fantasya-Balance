package de.x8bit.Fantasya.Atlantis.Items;

import de.x8bit.Fantasya.Atlantis.Item;
import de.x8bit.Fantasya.Atlantis.Buildings.Bergwerk;
import de.x8bit.Fantasya.Atlantis.Helper.ConstructionCheats;
import de.x8bit.Fantasya.Atlantis.Helper.ConstructionContainer;
import de.x8bit.Fantasya.Atlantis.Helper.ConstructionRace;
import de.x8bit.Fantasya.Atlantis.Skills.Bergbau;
import de.x8bit.Fantasya.Atlantis.Units.Zwerg;
import de.x8bit.Fantasya.util.ComplexName;

public class Eisen extends Item implements PersistentResource {

	public Eisen()
	{
		super(500, 0);
		setConstructionSkills(new ConstructionContainer [] { new ConstructionContainer(Bergbau.class, 1) } );
		setConstructionCheats(new ConstructionCheats [] { 
				new ConstructionCheats(Bergwerk.class, new ConstructionContainer [] { new ConstructionContainer(Eisen.class, 2)})
				});
		setConstructionRaces(new ConstructionRace [] { 
				new ConstructionRace(Zwerg.class, new ConstructionContainer [] { new ConstructionContainer(Eisen.class, 4)})
				});
	}
	
	
	
	
	public Eisen(int anzahl)
	{
		this();
//		super(500, 0); // Gewicht, Kapazität
		setAnzahl(anzahl);
//		setConstructionSkills(new ConstructionContainer [] { new ConstructionContainer(Bergbau.class, 1) } );
//		setConstructionCheats(new ConstructionCheats [] { 
//				new ConstructionCheats(Bergwerk.class, new ConstructionContainer [] { new ConstructionContainer(Eisen.class, 2)}),
//				});
	}
	
	@Override
	public String getName()
	{
		if (anzahl != 1) return "Eisen";
		return "Eisen";
	}
	
	@Override
	public boolean surviveBattle() { return true; }

	@Override
	public ComplexName getComplexName() {
		return new ComplexName("Eisen", "Eisen", null);
	}
}
