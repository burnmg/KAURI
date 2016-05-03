package lin.test;

import java.io.*;
import java.util.Enumeration;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import classifiers.CVFDT;
import classifiers.VFDT;

public class CVFDTTest
{
	public static void main(String args[]) throws Exception
	{
		DataSource source = new DataSource("data/tree.arff");
		Instances data = source.getDataSet();
		data.setClassIndex(data.numAttributes()-1);
		Enumeration<Instance> enumeration = data.enumerateInstances();
		VFDT tree = new VFDT();
		//tree.initialize(data);
		tree.buildClassifier(data);
		System.out.println("Tree size: " + tree.getRoot().getTreeSize());
		tree.getRoot().getClassValue();
		for(int i=0;i<10;i++)
		{
			Instance instance = enumeration.nextElement();
			double res = tree.classifyInstance(instance);
			System.out.println(instance);
			System.out.println(res);
		}
		
		
	}
}
