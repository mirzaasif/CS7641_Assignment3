package gatech.cs7641.dgonzalez42.assignment3;

import java.text.DecimalFormat;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.EM;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.unsupervised.attribute.Remove;

public class EMClusteringScreePlot 
{
	private static DecimalFormat df = new DecimalFormat("0.0000");

	public EMClusteringScreePlot(String fullTrainingDataset) throws Exception 
	{
		// Cluster	
		System.out.println("*** EM Clustering Scree Plot ***");
		
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
		EM clusterer = new EM();
		clusterer.setSeed(100);
		clusterer.setMinStdDev(1E-6);
		clusterer.setNumClusters(k);
		clusterer.setMaxIterations(100);
		clusterer.buildClusterer(removeAndNormalizedFiltered);

		// Evaluate Clusterer
		ClusterEvaluation eval = new ClusterEvaluation();
		eval.setClusterer(clusterer);
		eval.evaluateClusterer(removeAndNormalizedFiltered);

		// Results
		/*
		System.out.println(clusterer.getSeed());
		System.out.println(clusterer.getMinStdDev());
		System.out.println(clusterer.getNumClusters());
		System.out.println(clusterer.getMaxIterations());
		System.out.println(clusterer.getOptions().toString());
		
		System.out.println(df.format(eval.getLogLikelihood()));
		System.out.println("# of clusters: " + eval.getNumClusters());
		System.out.println(eval.clusterResultsToString());
		*/ 
		
		return eval.getLogLikelihood();
	}
}
