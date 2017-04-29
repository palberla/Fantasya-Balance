package de.x8bit.Fantasya.Atlantis.Units;

import de.x8bit.Fantasya.Atlantis.Skill;
import de.x8bit.Fantasya.Atlantis.Unit;
import de.x8bit.Fantasya.Atlantis.Skills.Armbrustschiessen;
import de.x8bit.Fantasya.Atlantis.Skills.Ausdauer;
import de.x8bit.Fantasya.Atlantis.Skills.Bergbau;
import de.x8bit.Fantasya.Atlantis.Skills.Bogenbau;
import de.x8bit.Fantasya.Atlantis.Skills.Bogenschiessen;
import de.x8bit.Fantasya.Atlantis.Skills.Architektur;
import de.x8bit.Fantasya.Atlantis.Skills.Handel;
import de.x8bit.Fantasya.Atlantis.Skills.Hiebwaffen;
import de.x8bit.Fantasya.Atlantis.Skills.Holzfaellen;
import de.x8bit.Fantasya.Atlantis.Skills.Katapultbedienung;
import de.x8bit.Fantasya.Atlantis.Skills.Magie;
import de.x8bit.Fantasya.Atlantis.Skills.Tierdressur;
import de.x8bit.Fantasya.Atlantis.Skills.Reiten;
import de.x8bit.Fantasya.Atlantis.Skills.Ruestungsbau;
import de.x8bit.Fantasya.Atlantis.Skills.Schiffbau;
import de.x8bit.Fantasya.Atlantis.Skills.Seefahrt;
import de.x8bit.Fantasya.Atlantis.Skills.Speerkampf;
import de.x8bit.Fantasya.Atlantis.Skills.Spionage;
import de.x8bit.Fantasya.Atlantis.Skills.Steinbau;
import de.x8bit.Fantasya.Atlantis.Skills.Steuereintreiben;
import de.x8bit.Fantasya.Atlantis.Skills.Strassenbau;
import de.x8bit.Fantasya.Atlantis.Skills.Taktik;
import de.x8bit.Fantasya.Atlantis.Skills.Tarnung;
import de.x8bit.Fantasya.Atlantis.Skills.Unterhaltung;
import de.x8bit.Fantasya.Atlantis.Skills.Waffenbau;
import de.x8bit.Fantasya.Atlantis.Skills.Wagenbau;
import de.x8bit.Fantasya.Atlantis.Skills.Wahrnehmung;

public class Halbling extends Unit // SKILL
{
	public Halbling()
	{
		RekrutierungsKosten = 70;
		
		// Wiegen weniger und Tragen weniger
		this.gewicht = 800;
		this.kapazitaet = 1300;

		minHunger = 4;
		maxHunger = 12;
	}

	public int Talentwert(Skill skill)
	{
		int tw = super.Talentwert(skill);
		if (tw == 0) return 0;
		
		if (skill.getClass().equals(Armbrustschiessen.class))	tw +=  0;	// SKILL
		if (skill.getClass().equals(Bogenschiessen.class))		tw +=  1;	// SKILL
		if (skill.getClass().equals(Katapultbedienung.class))	tw += -1;	// SKILL
		if (skill.getClass().equals(Hiebwaffen.class)) 			tw += -1;	// SKILL
		if (skill.getClass().equals(Speerkampf.class))			tw += -1;	// SKILL
		if (skill.getClass().equals(Reiten.class))				tw +=  1;	// SKILL
		if (skill.getClass().equals(Taktik.class))				tw +=  0;	// SKILL
		if (skill.getClass().equals(Bergbau.class))				tw +=  1;	// SKILL
		if (skill.getClass().equals(Architektur.class))			tw +=  1;	// SKILL
		if (skill.getClass().equals(Handel.class))				tw +=  2;	// SKILL
		if (skill.getClass().equals(Holzfaellen.class))			tw +=  0;	// SKILL
		if (skill.getClass().equals(Magie.class))				tw +=  0;	// SKILL
		if (skill.getClass().equals(Tierdressur.class))		tw +=  1;	// SKILL
		if (skill.getClass().equals(Ruestungsbau.class))		tw +=  0;	// SKILL
		if (skill.getClass().equals(Schiffbau.class))			tw += -1;	// SKILL
		if (skill.getClass().equals(Seefahrt.class))				tw += -2;	// SKILL
		if (skill.getClass().equals(Steinbau.class))			tw +=  0;	// SKILL
		if (skill.getClass().equals(Strassenbau.class))			tw +=  1;	// SKILL
		if (skill.getClass().equals(Tarnung.class))				tw +=  1;	// SKILL
		if (skill.getClass().equals(Unterhaltung.class))		tw +=  0;	// SKILL
		if (skill.getClass().equals(Waffenbau.class))			tw +=  0;	// SKILL
		if (skill.getClass().equals(Wagenbau.class))			tw +=  2;	// SKILL
		if (skill.getClass().equals(Wahrnehmung.class))			tw +=  1;	// SKILL
		if (skill.getClass().equals(Steuereintreiben.class))	tw +=  0;	// SKILL
		if (skill.getClass().equals(Bogenbau.class))			tw +=  1;	// SKILL
		if (skill.getClass().equals(Spionage.class))			tw +=  1;	// SKILL
		if (skill.getClass().equals(Ausdauer.class))			tw +=  0;	// SKILL

		return (tw < 0 ? 0 : tw);
	}
	
	/** 
	 * hier bekommen die Einheiten ihre Fertigkeiten mit denen sie geboren werden.
	 * Halblinge bekommen 30 Lerntage auf Tarnung und Unterhaltung
	 * @param anzahl - soviele Personen kommen hinzu
	 **/
	@Override
	public void hinzufuegenStartFertigkeiten(int anzahl)
	{
		getSkill(Tarnung.class).setLerntage(getSkill(Tarnung.class).getLerntage() + 30 * anzahl);
		getSkill(Unterhaltung.class).setLerntage(getSkill(Unterhaltung.class).getLerntage() + 30 * anzahl);
	};

	public int Trefferpunkte() { return 17; }

	@Override
	public boolean istSpielerRasse() { return true;	}

	@Override
	public String getRassenName() {
		if (this.getPersonen() == 1) return getRasse();
		return "Halblinge";
	}

}
