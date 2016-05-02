package edu.gmu.vfml.test;

import java.io.File;
import classifiers.CVFDT;
import weka.core.Instances;
import weka.core.converters.C45Loader;

public class Test4
{
    public static void main( String[] args ) throws Exception
    {
        C45Loader loader = new C45Loader( );

        // example of data file location specified relative to classpath
        //ClassLoader classloader = Test3.class.getClassLoader( );
        //File file = new File( classloader.getResource( "data/binary.names" ).getFile( ) );

        // example of data file location specified with absolute path 
        File file = new File( "/home/ulman/GMU/Spring2013/CS782/Project/data/binary.names" );

        loader.setSource( file );
        Instances data = loader.getDataSet( );

        // set class index as last attribute in data set (arff default)
        data.setClassIndex( data.numAttributes( ) - 1 );

        // build a VFDT classifier
        CVFDT classifier = new CVFDT( );
        // set a very low confidence level so that not much data is needed for each split
        classifier.setConfidenceLevel( 1e-2 );
        classifier.setNMin( 30 );
        // apply the classifier to the data set
        classifier.buildClassifier( data );

        System.out.println( "Final tree size: " + classifier.getRoot( ).getTreeSize( ) );

        System.out.println( classifier.toString( ) );
    }
}
