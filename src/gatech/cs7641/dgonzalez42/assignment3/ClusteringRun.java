package gatech.cs7641.dgonzalez42.assignment3;

import java.text.DecimalFormat;

import weka.core.EuclideanDistance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.clusterers.SimpleKMeans;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.Clusterer;

public class ClusteringRun 
{
	private static DecimalFormat df = new DecimalFormat("0.0000");
	
	public ClusteringRun(String fullTrainingDataset) throws Exception 
	{
		kMeans(fullTrainingDataset);
	}
	
	public void kMeans(String fullTrainingDataset) throws Exception
	{
		// Cross-validation of full set		
		System.out.println("*** k-Means Clustering ***");

		// DataSource dsTrain = new DataSource("dataset/weather.numeric.arff");
		DataSource dsFull = new DataSource(fullTrainingDataset);
		Instances full = dsFull.getDataSet(); 

		// full.setClassIndex(full.numAttributes() - 1);
		
		// Build Clusterer
		String[] options = new String[2];
		//options[0] = "-A";                 // max. iterations
		//options[1] = "weka.core.EuclideanDistance -R first-last";
		SimpleKMeans clusterer = new SimpleKMeans();   // new instance of clusterer
		clusterer.setSeed(10);
		clusterer.setDontReplaceMissingValues(false);
		clusterer.setPreserveInstancesOrder(false);
		clusterer.setDisplayStdDevs(false);
		clusterer.setNumClusters(2);
		clusterer.setMaxIterations(500);
		clusterer.setDistanceFunction(new EuclideanDistance());
		//clusterer.setOptions(options);     // set the options
		clusterer.buildClusterer(full);    // build the clusterer
		
		// Evaluate Clusterer
		ClusterEvaluation eval = new ClusterEvaluation();

		eval.setClusterer(clusterer);                                   // the cluster to evaluate
		eval.evaluateClusterer(full);                                // data to evaluate the clusterer on
				
		System.out.println(clusterer.getSeed());
		System.out.println(clusterer.getDontReplaceMissingValues());
		System.out.println(clusterer.getPreserveInstancesOrder());
		System.out.println(clusterer.getDisplayStdDevs());
		System.out.println(clusterer.getNumClusters());
		System.out.println(clusterer.getMaxIterations());
		System.out.println(clusterer.getDistanceFunction().toString());
		System.out.println(clusterer.getOptions().toString());
		
		System.out.println("# of clusters: " + eval.getNumClusters());  // output # of clusters
		System.out.println(eval.clusterResultsToString());
	}

}
