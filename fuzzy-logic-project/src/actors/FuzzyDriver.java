package actors;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class FuzzyDriver {
    FIS fis;

    public FuzzyDriver() {
        String fileName = "fuzzy_plane.fcl";
         fis = FIS.load(fileName,false);

    }
    public void showCharts(){
        // Wyświetlamy wyrkesy wejściowe
        FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
        fuzzyRuleSet.chart();
    }
    public Variable calculate(double frontSensor, double rightSensor, double leftSensor){

        FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();

// zadaj wartosci wejsciowe
        fuzzyRuleSet.setVariable("front_sensor", frontSensor);
        fuzzyRuleSet.setVariable("left_sensor", leftSensor);
        fuzzyRuleSet.setVariable("right_sensor", rightSensor);
// logika sterownika
        fuzzyRuleSet.evaluate();

//        System.out.println(fuzzyRuleSet.toString());

        return fuzzyRuleSet.getVariable("direction");
    }
}
