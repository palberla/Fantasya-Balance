package de.x8bit.Fantasya.Atlantis.Items;

import de.x8bit.Fantasya.Atlantis.Item;
import de.x8bit.Fantasya.Atlantis.Buildings.Sattlerei;
import de.x8bit.Fantasya.Atlantis.Helper.ConstructionCheats;
import de.x8bit.Fantasya.Atlantis.Helper.ConstructionContainer;
import de.x8bit.Fantasya.Atlantis.Skills.Ruestungsbau;
import de.x8bit.Fantasya.util.ComplexName;
import de.x8bit.Fantasya.util.Random;

public class Plattenpanzer extends Item
{
	public Plattenpanzer()
	{
		super(400, 0);
		setConstructionSkills(new ConstructionContainer [] { new ConstructionContainer(Ruestungsbau.class, 3) } );
		setConstructionItems(new ConstructionContainer [] { new ConstructionContainer(Eisen.class, 5) } );
		setConstructionCheats(new ConstructionCheats [] { 
				new ConstructionCheats(Sattlerei.class, new ConstructionContainer [] { new ConstructionContainer(Eisen.class, 2)})
				});
	}

	@Override
	public String getName()
	{
		if (anzahl != 1) return "Plattenpanzer";
		return "Plattenpanzer";
	}
	
	@Override
	public boolean surviveBattle() { return Random.rnd(0, 100) < 90; }

	@Override
	public ComplexName getComplexName() {
		return new ComplexName("Plattenpanzer", "Plattenpanzer", null);
	}
}
