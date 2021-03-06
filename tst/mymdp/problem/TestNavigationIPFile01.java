package mymdp.problem;

import static mymdp.test.MDPAssertions.assertThat;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.Test;

import mymdp.core.MDPIP;
import mymdp.core.UtilityFunction;
import mymdp.core.UtilityFunctionImpl;
import mymdp.dual.ValueIterationProbImpl;

public class TestNavigationIPFile01
{

	@Test
	public void test01() {
		final MDPIP mdpip = MDPImpreciseFileProblemReader.readFromFile("precise_problems\\navigation01.net", new ImprecisionGeneratorImpl(
				0.000001));
		final Offset<Double> delta = Assertions.offset(0.001);
		final UtilityFunction result = new ValueIterationProbImpl(new UtilityFunctionImpl(mdpip.getStates())).solve(mdpip,
				delta.value);
		assertThat(result)
				.stateHasValue("broken-robot", -9.991404955, delta)
				.stateHasValue("robot-at-x01y01", -4.684730495, delta)
				.stateHasValue("robot-at-x01y02", -3.439, delta)
				.stateHasValue("robot-at-x01y03", -2.71, delta)
				.stateHasValue("robot-at-x02y01", -5.216171495, delta)
				.stateHasValue("robot-at-x02y02", -2.71, delta)
				.stateHasValue("robot-at-x02y03", -1.9, delta)
				.stateHasValue("robot-at-x03y01", -5.694468395, delta)
				.stateHasValue("robot-at-x03y02", -1.9, delta)
				.stateHasValue("robot-at-x03y03", -1.0, delta)
				.stateHasValue("robot-at-x04y01", -6.124935605, delta)
				.stateHasValue("robot-at-x04y02", -1.0, delta)
				.stateHasValue("robot-at-x04y03", 0.0, delta);
	}
}
