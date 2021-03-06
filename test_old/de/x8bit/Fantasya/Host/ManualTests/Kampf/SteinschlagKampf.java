package de.x8bit.Fantasya.Host.ManualTests.Kampf;

import de.x8bit.Fantasya.Atlantis.Kampfposition;
import de.x8bit.Fantasya.Atlantis.Partei;
import de.x8bit.Fantasya.Atlantis.Region;
import de.x8bit.Fantasya.Atlantis.Unit;
import de.x8bit.Fantasya.Atlantis.Items.Schwert;
import de.x8bit.Fantasya.Atlantis.Messages.Info;
import de.x8bit.Fantasya.Atlantis.Messages.TestMsg;
import de.x8bit.Fantasya.Atlantis.Regions.Berge;
import de.x8bit.Fantasya.Atlantis.Skills.Hiebwaffen;
import de.x8bit.Fantasya.Atlantis.Skills.Magie;
import de.x8bit.Fantasya.Atlantis.Spells.Steinschlag;
import de.x8bit.Fantasya.Atlantis.Units.Mensch;
import de.x8bit.Fantasya.Host.GameRules;
import de.x8bit.Fantasya.Host.EVA.Kampfzauber;
import de.x8bit.Fantasya.Host.ManualTests.TestBase;

/**
 *
 * @author hb
 */
public class SteinschlagKampf extends TestBase {

    @Override
    protected void mySetupTest() {
        Partei a = this.getTestWorld().createPartei(Mensch.class);
        a.setName(this.getName() + "-A");
        Partei b = this.getTestWorld().createPartei(Mensch.class);
        b.setName(this.getName() + "-B");

        Region r = this.getTestWorld().nurTerrain(getRegions(), Berge.class).get(0);
        getRegions().remove(r);

        {
            Unit ua = this.createUnit(a, r);
            ua.setName(this.getName()+" 01");
            ua.setPersonen(500);
            ua.setSkill(Hiebwaffen.class, 450 * ua.getPersonen());
            ua.setItem(Schwert.class, ua.getPersonen());
            ua.setKampfposition(Kampfposition.Vorne);

            Unit u = this.createUnit(a, r);
            u.setName(this.getName()+" 11");
            u.setPersonen(1);
            u.setSkill(Magie.class, 1650 * u.getPersonen());
            u.setAura(9);
            u.setSpell(new Steinschlag());
            // u.setSpell(new KleinesErdbeben());
			u.setProperty(Kampfzauber.CONFUSIONSPELL, "ZAUBERE Steinschlag 4");
            u.setKampfposition(Kampfposition.Hinten);


            Unit ub = this.createUnit(b, r);
            ub.setName(this.getName()+" 02");
            ub.setPersonen(590);
            ub.setSkill(Hiebwaffen.class, 450 * ub.getPersonen());
            ub.setItem(Schwert.class, ub.getPersonen());
            ub.setKampfposition(Kampfposition.Vorne);

            b.setUrsprung(r.getCoords());

            ua.Befehle.add("ATTACKIERE " + ub.getNummerBase36());
            
            new Info(this.getName() + " Setup in " + r + ".", ua, ua.getCoords());
        }
    }

    @Override
    protected boolean verifyTest() {
        boolean retval = true;
//        List<Message> messages = null;

        if ((GameRules.getRunde() > 3) || (GameRules.getRunde() < 2)) throw new IllegalStateException("GameRules.getRunde() muss 2 oder 3 sein - ist aber " + GameRules.getRunde() + ".");

        if (GameRules.getRunde() == 3) {
            new TestMsg("In Runde 3 gibt es keine Überprüfungen in " + this.getName() + ".");
            return retval;
        }

        new TestMsg("Verifiziere " + this.getName() + "...");

        String missing = this.verifyExpectedUnits(Unit.CACHE, new String[] {"01", "11"});
        if (missing != null) {
            retval = this.fail("Es wurden erwartete Einheiten gar nicht mehr gefunden: " + missing);
        }


        for (Unit u:Unit.CACHE) {
            // "fremde" Einheiten überspringen.
            if (!u.getName().startsWith(this.getName())) continue;

            String[] tokens = u.getName().split("\\ ");

            // unit 02
            if (tokens[1].equals("02")) {
                retval = this.fail("Der Feind wurde nicht verschüttet und besiegt - Einheit 02 ist noch da.");
            }
        } // next unit

        return retval;
    }

}
