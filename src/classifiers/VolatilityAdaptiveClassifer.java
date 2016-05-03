package classifiers;

import java.security.AlgorithmConstraints;

import com.yahoo.labs.samoa.instances.Instance;
import com.yahoo.labs.samoa.instances.Prediction;

import moa.classifiers.AbstractClassifier;
import moa.core.Measurement;
import volatilityevaluation.RelativeVolatilityDetector;

public class VolatilityAdaptiveClassifer extends AbstractClassifier
{
	private AbstractClassifier classifier1;
	private AbstractClassifier classifier2;
	private AbstractClassifier activeClassifier;
	private RelativeVolatilityDetector volatilityDetector;
	
	
	@Override
	public boolean isRandomizable()
	{
		return false;
	}

	@Override
	public void getModelDescription(StringBuilder arg0, int arg1)
	{
		
	}

	/**return the information of the current algorithm */
	@Override
	protected Measurement[] getModelMeasurementsImpl()
	{
		/*
        return new Measurement[]{
                new Measurement("tree size (nodes)", this.decisionNodeCount
                + this.activeLeafNodeCount + this.inactiveLeafNodeCount),
                new Measurement("tree size (leaves)", this.activeLeafNodeCount
                + this.inactiveLeafNodeCount),
                new Measurement("active learning leaves",
                this.activeLeafNodeCount),
                new Measurement("tree depth", measureTreeDepth()),
                new Measurement("active leaf byte size estimate",
                this.activeLeafByteSizeEstimate),
                new Measurement("inactive leaf byte size estimate",
                this.inactiveLeafByteSizeEstimate),
                new Measurement("byte size estimate overhead",
                this.byteSizeEstimateOverheadFraction)};
                */
		return null;
	}

	@Override
	public double[] getVotesForInstance(Instance arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetLearningImpl()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trainOnInstanceImpl(Instance inst)
	{
		// if there is a volatility shift.
		if(volatilityDetector.setInputVar(
				correctlyClassifies(inst) ? 0.0 : 1.0))
		{
			/* 
			 * TODO 
			 * compute the avg interval in the buffer.
			 * decide if I need to switch algorithm.
			 * 
			 */
		}
		
		activeClassifier.trainOnInstance(inst);
	}
	
}
