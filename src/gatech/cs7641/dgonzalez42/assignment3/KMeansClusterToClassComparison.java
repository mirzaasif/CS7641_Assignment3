package gatech.cs7641.dgonzalez42.assignment3;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.unsupervised.attribute.Remove;

public class KMeansClusterToClassComparison 
{
	public KMeansClusterToClassComparison(String fullTrainingDataset, int k) throws Exception 
	{
		// Compare to class	
		System.out.println("*** k-Means Clustering Comparisomn to Class***");

		// DataSource dsTrain = new DataSource("dataset/weather.numeric.arff");
		DataSource dsFull = new DataSource(fullTrainingDataset);
		Instances full = dsFull.getDataSet(); 
		
		full.setClassIndex(full.numAttributes() - 1);
		
		// Remove class label
		Remove filtered = new Remove();
		filtered.setAttributeIndices("" + (full.classIndex() + 1));
		filtered.setInputFormat(full);
		Instances fullFiltered = Filter.useFilter(full, filtered);
		
		// Normalize numeric attributes
		Normalize normalize = new Normalize();
		normalize.setInputFormat(fullFiltered);	
		Instances removeAndNormalizedFiltered = Filter.useFilter(fullFiltered, normalize);

		// Build Clusterer
		SimpleKMeans clustererForClasses = new SimpleKMeans();
		clustererForClasses.setSeed(10);
		clustererForClasses.setDontReplaceMissingValues(false);
		clustererForClasses.setPreserveInstancesOrder(false);
		clustererForClasses.setDisplayStdDevs(false);
		clustererForClasses.setNumClusters(k);
		clustererForClasses.setMaxIterations(500);
		clustererForClasses.setDistanceFunction(new EuclideanDistance());
		clustererForClasses.buildClusterer(removeAndNormalizedFiltered);
		
		// Normalize full dataset
		Normalize normalizeFull = new Normalize();
		normalizeFull.setInputFormat(full);	
		Instances normalizedFull = Filter.useFilter(full, normalizeFull);
		
		// Compare to class
		ClusterEvaluation evalForClasses = new ClusterEvaluation();
		evalForClasses.setClusterer(clustererForClasses);
		evalForClasses.evaluateClusterer(normalizedFull);
		
		System.out.println(evalForClasses.clusterResultsToString());
	}
}
