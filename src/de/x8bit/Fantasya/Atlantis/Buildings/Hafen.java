package de.x8bit.Fantasya.Atlantis.Buildings;

import de.x8bit.Fantasya.Atlantis.Building;
import de.x8bit.Fantasya.Atlantis.Item;
import de.x8bit.Fantasya.Atlantis.Region;
import de.x8bit.Fantasya.Atlantis.Unit;
import de.x8bit.Fantasya.Atlantis.Items.Eisen;
import de.x8bit.Fantasya.Atlantis.Items.Holz;
import de.x8bit.Fantasya.Atlantis.Items.Silber;
import de.x8bit.Fantasya.Atlantis.Items.Stein;
import de.x8bit.Fantasya.Atlantis.Messages.Fehler;
import de.x8bit.Fantasya.Atlantis.Skills.Architektur;
import de.x8bit.Fantasya.util.ComplexName;

public class Hafen extends Building
{
	public void Zerstoere(Unit u)
	{
		super.Zerstoere(u, new Item [] {  new Stein(3), new Eisen(3), new Holz(1)  });	
	}
	
	public String getTyp() { return "Hafen"; }
	
	public int GebaeudeUnterhalt() { return 150; }

	public boolean hatFunktion()
	{
		if (getSize() < 10) return false;
		return super.hatFunktion(); 
	}
	
	
	/**
	 * erstellt ein Gebäude bzw. baut daran weiter
	 * @param u - diese Einheit will daran bauen
	 */
	public void Mache(Unit u)
	{
		// nochmal holen ... ist größer als Null
		int tw = u.Talentwert(Architektur.class);
		if (tw < 3)
		{
			new Fehler(u + " hat nicht genügend Talent um an " + this + " zu bauen", u, u.getCoords());
			return;
		}
		
		// zusätzlichen Gebäude testen
		Region region = Region.Load(u.getCoords());
		if (!region.hatGebaeude(Burg.class, 10, u))
		{
			new Fehler(u + " - in " + region + " fehlt ein Turm um " + getTyp() + " bauen zu können", u, u.getCoords());
			return;
		}
		
		GenericMake(u, 10, Architektur.class, 3, new Item [] { new Stein(7), new Eisen(5), new Holz(2), new Silber(150) } );
	}

	@Override
	public ComplexName getComplexName() {
		return new ComplexName("Hafen", "Häfen", null);
	}
}
