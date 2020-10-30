import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class FuzzyLogicCharts {

        public FuzzyLogicCharts(){

        }
    public static void main(String[] args) throws Exception {
            String fileName = "fuzzy_plane.fcl";
            FIS fis = FIS.load(fileName,false);

            int frontSensor = 80;
            int leftSensor = 15;
            int rightSensor =  90;

            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();

            fuzzyRuleSet.setVariable("front_sensor", frontSensor);
            fuzzyRuleSet.setVariable("left_sensor", leftSensor);
            fuzzyRuleSet.setVariable("right_sensor", rightSensor);

            fuzzyRuleSet.evaluate();

            fuzzyRuleSet.getVariable("direction").chartDefuzzifier(true);

            System.out.println(fuzzyRuleSet);

    }

}