package gatech.cs7641.dgonzalez42.assignment3;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class KMeansClusterToClassComparison 
{
	public KMeansClusterToClassComparison(String fullTrainingDataset) throws Exception 
	{
		// Compare to class	
		System.out.println("*** k-Means Clustering Comparisomn to Class***");

		// DataSource dsTrain = new DataSource("dataset/weather.numeric.arff");
		DataSource dsFull = new DataSource(fullTrainingDataset);
		Instances full = dsFull.getDataSet(); 
		
		full.setClassIndex(full.numAttributes() - 1);
		
		Remove filtered = new Remove();
		filtered.setAttributeIndices("" + (full.classIndex() + 1));
		filtered.setInputFormat(full);
		Instances fullFiltered = Filter.useFilter(full, filtered);
		
		SimpleKMeans clustererForClasses = new SimpleKMeans();
		// set further options for EM, if necessary...
		clustererForClasses.setSeed(10);
		clustererForClasses.setDontReplaceMissingValues(false);
		clustererForClasses.setPreserveInstancesOrder(false);
		clustererForClasses.setDisplayStdDevs(false);
		clustererForClasses.setNumClusters(2);
		clustererForClasses.setMaxIterations(500);
		clustererForClasses.setDistanceFunction(new EuclideanDistance());
		clustererForClasses.buildClusterer(fullFiltered);
		
		ClusterEvaluation evalForClasses = new ClusterEvaluation();
		evalForClasses.setClusterer(clustererForClasses);
		evalForClasses.evaluateClusterer(full);
		
		System.out.println(evalForClasses.clusterResultsToString());
	}
}
