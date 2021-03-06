package de.x8bit.Fantasya.Host.ZAT.Battle.Weapons;

import de.x8bit.Fantasya.Atlantis.Item;
import de.x8bit.Fantasya.Atlantis.Skill;
import de.x8bit.Fantasya.Atlantis.Unit;
import de.x8bit.Fantasya.Atlantis.Skills.Hiebwaffen;
import de.x8bit.Fantasya.Host.ZAT.Battle.Krieger;
import de.x8bit.Fantasya.util.Random;

public class MKlauen extends Tier {
	public MKlauen(Unit unit) { super(unit); }

    @Override
    public int numberOfAttacks() { return 1; }

    @Override
    public boolean istFernkampfTauglich() { return false; }

    // --- Angriff
	public int AttackValue(int reihe_attacker, int reihe_defender)
	{
		return Krieger.Distanz(reihe_attacker, reihe_defender) == 0 ? getUnit().Talentwert(neededSkill()) : 0;
	}
	public int DefenceValue(int reihe_attacker, int reihe_defender)
	{
		return Krieger.Distanz(reihe_attacker, reihe_defender) == 0 ? getUnit().Talentwert(neededSkill()) : 0;
	}	
	public float AttackModifikation_Attacker(Krieger attacker, Krieger defender) 		{ return 0; }
	public float AttackModifikation_Defender(Krieger attacker, Krieger defender) 		{ return 0; }
	public float DefenceModifikation_Attacker(Krieger attacker, Krieger defender) 		{ return 0; }
	public float DefenceModifikation_Defender(Krieger attacker, Krieger defender) 		{ return 0; }
    
	// --- Schaden
	public int DamageValue() { 
        // p ~ 8%  :  == 0
        // p ~45%  :  <= 3
        // p ~17%  :  > 10
        // p ~ 3%  :  > 20
        return (int)Math.round(Random.NextChiSquare(2, 6d)); 
    }	
    public float AverageDamageValue() { return 6f; }

	public float BlockModifikation_Attacker(Krieger attacker, Krieger defender) 		{ return 0; }
	public float BlockModifikation_Defender(Krieger attacker, Krieger defender) 		{ return 0; }
	public float DamageModifikation_Attacker(Krieger attacker, Krieger defender) 		{ return 0; }
	public float DamageModifikation_Defender(Krieger attacker, Krieger defender) 		{ return 0; }

	public Class<? extends Skill> neededSkill() { return Hiebwaffen.class; }

    @Override
    public Class<? extends Item> getUrsprungsItem() { return null; }

    @Override
    public String kurzCode() { return "Kln"; }


}
