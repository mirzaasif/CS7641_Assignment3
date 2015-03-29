package gatech.cs7641.dgonzalez42.assignment3;

import java.text.DecimalFormat;

import weka.core.EuclideanDistance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.clusterers.SimpleKMeans;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.Clusterer;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.unsupervised.attribute.Remove;

public class KMeansClusteringRun 
{
	private static DecimalFormat df = new DecimalFormat("0.0000");
	
	public KMeansClusteringRun(String fullTrainingDataset, int k) throws Exception 
	{
		kMeans(fullTrainingDataset, k);
	}
	
	public void kMeans(String fullTrainingDataset, int k) throws Exception
	{
		// Cluster	
		System.out.println("*** k-Means Clustering ***");

		DataSource dsFull = new DataSource(fullTrainingDataset);
		Instances full = dsFull.getDataSet(); 
		
		// Remove class label
		String[] removeOptions = new String[] { "-R",  Integer.toString(full.numAttributes())};
		Remove remove = new Remove();
		remove.setOptions(removeOptions);
		remove.setInputFormat(full);
		Instances fullFiltered = Filter.useFilter(full, remove);
		
		// Normalize numeric attributes
		Normalize normalize = new Normalize();
		normalize.setInputFormat(fullFiltered);	
		Instances removeAndNormalizedFiltered = Filter.useFilter(fullFiltered, normalize);
		
		// Build Clusterer
		SimpleKMeans clusterer = new SimpleKMeans();
		clusterer.setSeed(10);
		clusterer.setDontReplaceMissingValues(false);
		clusterer.setPreserveInstancesOrder(false);
		clusterer.setDisplayStdDevs(false);
		clusterer.setNumClusters(k);
		clusterer.setMaxIterations(500);
		clusterer.setDistanceFunction(new EuclideanDistance());
		clusterer.buildClusterer(removeAndNormalizedFiltered);
		
		// Evaluate Clusterer
		ClusterEvaluation eval = new ClusterEvaluation();
		eval.setClusterer(clusterer);
		eval.evaluateClusterer(removeAndNormalizedFiltered);
		
		// Results
		System.out.println(clusterer.getSeed());
		System.out.println(clusterer.getDontReplaceMissingValues());
		System.out.println(clusterer.getPreserveInstancesOrder());
		System.out.println(clusterer.getDisplayStdDevs());
		System.out.println(clusterer.getNumClusters());
		System.out.println(clusterer.getMaxIterations());
		System.out.println(clusterer.getDistanceFunction().toString());
		// System.out.println(clusterer.getOptions().toString());
		
		System.out.println("# of clusters: " + eval.getNumClusters());
		System.out.println("Within cluster sum of squared errors: " + df.format(clusterer.getSquaredError()));
		System.out.println(eval.clusterResultsToString());
	}

}
