package gatech.cs7641.dgonzalez42.assignment3;

import java.text.DecimalFormat;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.clusterers.EM;
import weka.clusterers.ClusterEvaluation;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class EMClusteringRun 
{
	private static DecimalFormat df = new DecimalFormat("0.0000");

	public EMClusteringRun(String fullTrainingDataset) throws Exception 
	{
		kMeans(fullTrainingDataset);
	}

	public void kMeans(String fullTrainingDataset) throws Exception
	{
		// Cluster	
		System.out.println("*** EM Clustering ***");

		// DataSource dsTrain = new DataSource("dataset/weather.numeric.arff");
		DataSource dsFull = new DataSource(fullTrainingDataset);
		Instances full = dsFull.getDataSet(); 

		// full.setClassIndex(full.numAttributes() - 1);
		
		String[] removeOptions = new String[] { "-R",  Integer.toString(full.numAttributes())};
		Remove remove = new Remove();
		remove.setOptions(removeOptions);
		remove.setInputFormat(full);
		Instances fullFiltered = Filter.useFilter(full, remove);

		// Build Clusterer
		// String[] options = new String[2];
		//options[0] = "-A";                 // max. iterations
		//options[1] = "weka.core.EuclideanDistance -R first-last";
		EM clusterer = new EM();   // new instance of clusterer
		clusterer.setSeed(100);
		clusterer.setMinStdDev(1E-6);
		clusterer.setNumClusters(-1);
		clusterer.setMaxIterations(100);
		//clusterer.setOptions(options);     // set the options
		clusterer.buildClusterer(fullFiltered);    // build the clusterer

		// Evaluate Clusterer
		ClusterEvaluation eval = new ClusterEvaluation();
		eval.setClusterer(clusterer);                                   // the cluster to evaluate
		eval.evaluateClusterer(fullFiltered);                                // data to evaluate the clusterer on

		System.out.println(clusterer.getSeed());
		System.out.println(clusterer.getMinStdDev());
		System.out.println(clusterer.getNumClusters());
		System.out.println(clusterer.getMaxIterations());
		System.out.println(clusterer.getOptions().toString());

		System.out.println("# of clusters: " + eval.getNumClusters());  // output # of clusters
		System.out.println(eval.clusterResultsToString());
	}

}
