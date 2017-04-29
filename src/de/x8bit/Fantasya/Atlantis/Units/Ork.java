package de.x8bit.Fantasya.Atlantis.Units;

import de.x8bit.Fantasya.Atlantis.Coords;
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

public class Ork extends Unit // SKILL
{
	public Ork()
	{
		RekrutierungsKosten = 80;

		minHunger = 7;
		maxHunger = 15;
	}

	public int Talentwert(Skill skill)
	{
		int tw = super.Talentwert(skill);
		if (tw == 0) return 0;
		
		if (skill.getClass().equals(Armbrustschiessen.class))	tw +=  0;	// SKILL
		if (skill.getClass().equals(Bogenschiessen.class))		tw +=  0;	// SKILL
		if (skill.getClass().equals(Katapultbedienung.class))	tw +=  0;	// SKILL
		if (skill.getClass().equals(Hiebwaffen.class)) 			tw +=  0;	// SKILL
		if (skill.getClass().equals(Speerkampf.class))			tw +=  0;	// SKILL
		if (skill.getClass().equals(Reiten.class))				tw +=  0;	// SKILL
		if (skill.getClass().equals(Taktik.class))				tw +=  0;	// SKILL
		if (skill.getClass().equals(Bergbau.class))				tw +=  1;	// SKILL
		if (skill.getClass().equals(Architektur.class))			tw +=  1;	// SKILL
		if (skill.getClass().equals(Handel.class))				tw += -2;	// SKILL
		if (skill.getClass().equals(Holzfaellen.class))			tw +=  1;	// SKILL
		if (skill.getClass().equals(Magie.class))				tw += -2;	// SKILL
		if (skill.getClass().equals(Tierdressur.class))		tw += -1;	// SKILL
		if (skill.getClass().equals(Ruestungsbau.class))		tw +=  0;	// SKILL
		if (skill.getClass().equals(Schiffbau.class))			tw += -1;	// SKILL
		if (skill.getClass().equals(Seefahrt.class))				tw += -1;	// SKILL
		if (skill.getClass().equals(Steinbau.class))			tw +=  1;	// SKILL
		if (skill.getClass().equals(Strassenbau.class))			tw +=  0;	// SKILL
		if (skill.getClass().equals(Tarnung.class))				tw +=  0;	// SKILL
		if (skill.getClass().equals(Unterhaltung.class))		tw += -2;	// SKILL
		if (skill.getClass().equals(Waffenbau.class))			tw +=  2;	// SKILL
		if (skill.getClass().equals(Wagenbau.class))			tw += -1;	// SKILL
		if (skill.getClass().equals(Wahrnehmung.class))			tw +=  0;	// SKILL
		if (skill.getClass().equals(Steuereintreiben.class))	tw +=  1;	// SKILL
		if (skill.getClass().equals(Bogenbau.class))			tw +=  0;	// SKILL
		if (skill.getClass().equals(Spionage.class))			tw +=  0;	// SKILL
		if (skill.getClass().equals(Ausdauer.class))			tw +=  1;	// SKILL

		return (tw < 0 ? 0 : tw);
	}
	
	/** 
	 * hier bekommen die Einheiten ihre Fertigkeiten mit denen sie geboren werden.
	 * Orks bekommen 30 Lerntage auf Hiebwaffen
	 * @param anzahl - soviele Personen kommen hinzu
	 **/
	@Override
	public void hinzufuegenStartFertigkeiten(int anzahl)
	{
		getSkill(Hiebwaffen.class).setLerntage(getSkill(Hiebwaffen.class).getLerntage() + 30 * anzahl);
	};
	
	/**
	 * Faktor der Regionsrekruten für die Rasse.
	 */
	public double rekrutierungsFaktor(Coords coords) { return 1.25; }

	public int Trefferpunkte() { return 23; }

	@Override
	public boolean istSpielerRasse() { return true;	}

	@Override
	public String getRassenName() {
		if (this.getPersonen() == 1) return getRasse();
		return "Orks";
	}
}
