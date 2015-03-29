package gatech.cs7641.dgonzalez42.assignment3;

import java.text.DecimalFormat;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;
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

		return clusterer.getSquaredError();
	}

}
