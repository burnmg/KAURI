package edu.gmu.vfml.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;

import classifiers.VFDT;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.ReplaceMissingValues;

import com.metsci.glimpse.util.io.StreamOpener;


public class Test2
{
    public static void main( String[] args ) throws Exception
    {
        // read data set
    	DataSource in = new DataSource("data/breast-cancer.arff");
        Instances data = in.getDataSet();
        Instances data2 = in.getDataSet();

        // set class index as last attribute in data set (arff default)
        data.setClassIndex( data.numAttributes( ) - 1 );

        // replace missing values with modes from the data set
        ReplaceMissingValues filter = new ReplaceMissingValues( );
        filter.setInputFormat( data );
        data = Filter.useFilter( data, filter );
        data2 = Filter.useFilter( data2, filter );
        // build a VFDT classifier
        VFDT classifier = new VFDT( );
        // set a very low confidence level so that not much data is needed for each split
        classifier.setConfidenceLevel( 0.1 );
        // apply the classifier to the data set
        classifier.buildClassifier( data );
        
        Enumeration<Instance> data2enum = data2.enumerateInstances();
        while(data2enum.hasMoreElements())
        {
        	Instance inst = data2enum.nextElement();
        	System.out.println(inst);
        	System.out.println(classifier.classifyInstance(inst));
        }
    }
}
