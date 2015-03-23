package gatech.cs7641.dgonzalez42.assignment3;

import java.text.DecimalFormat;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class KMeansClusteringScreePlot 
{
private static DecimalFormat df = new DecimalFormat("0.0000");
	
	public KMeansClusteringScreePlot(String fullTrainingDataset) throws Exception 
	{
		// Cluster	
		System.out.println("*** k-Means Clustering Scree Plot ***");
		
		for (int k=1; k <= 25; k++)
		{
			double sse = plot(k, fullTrainingDataset);
			System.out.println(df.format(sse));
		}
	}
	
	public double plot(int k, String fullTrainingDataset) throws Exception
	{
		// DataSource dsTrain = new DataSource("dataset/weather.numeric.arff");
		DataSource dsFull = new DataSource(fullTrainingDataset);
		Instances full = dsFull.getDataSet(); 

		// full.setClassIndex(full.numAttributes() - 1);
		
		String[] removeOptions = new String[] { "-R",  Integer.toString(full.numAttributes())};
		Remove remove = new Remove();
		remove.setOptions(removeOptions);
		remove.setInputFormat(full);
		Instances fullFiltered = Filter.useFilter(full, remove);

		/*
		Remove filtered = new Remove();
		filtered.setAttributeIndices("" + (full.classIndex() + 1));
		filtered.setInputFormat(full);
		Instances fullFiltered = Filter.useFilter(full, filtered);
		*/
		// Build Clusterer
		// String[] options = new String[2];
		//options[0] = "-A";                 // max. iterations
		//options[1] = "weka.core.EuclideanDistance -R first-last";
		SimpleKMeans clusterer = new SimpleKMeans();   // new instance of clusterer
		clusterer.setSeed(10);
		clusterer.setDontReplaceMissingValues(false);
		clusterer.setPreserveInstancesOrder(false);
		clusterer.setDisplayStdDevs(false);
		clusterer.setNumClusters(k);
		clusterer.setMaxIterations(500);
		clusterer.setDistanceFunction(new EuclideanDistance());
		//clusterer.setOptions(options);     // set the options
		clusterer.buildClusterer(fullFiltered);    // build the clusterer
		
		// Evaluate Clusterer
		ClusterEvaluation eval = new ClusterEvaluation();
		eval.setClusterer(clusterer);                                   // the cluster to evaluate
		eval.evaluateClusterer(fullFiltered);                                // data to evaluate the clusterer on
		/*		
		System.out.println(clusterer.getSeed());
		System.out.println(clusterer.getDontReplaceMissingValues());
		System.out.println(clusterer.getPreserveInstancesOrder());
		System.out.println(clusterer.getDisplayStdDevs());
		System.out.println(clusterer.getNumClusters());
		System.out.println(clusterer.getMaxIterations());
		System.out.println(clusterer.getDistanceFunction().toString());
		// System.out.println(clusterer.getOptions().toString());
		
		System.out.println("# of clusters: " + eval.getNumClusters());  // output # of clusters
		System.out.println("Within cluster sum of squared errors: " + df.format(clusterer.getSquaredError()));
		System.out.println(eval.clusterResultsToString());
		*/
		return clusterer.getSquaredError();
	}

}
