package gatech.cs7641.dgonzalez42.assignment3;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.EM;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class EMClusterToClassComparison 
{
	public EMClusterToClassComparison(String fullTrainingDataset) throws Exception 
	{
		// Compare to class	
		System.out.println("*** EM Clustering Comparisomn to Class***");

		// DataSource dsTrain = new DataSource("dataset/weather.numeric.arff");
		DataSource dsFull = new DataSource(fullTrainingDataset);
		Instances full = dsFull.getDataSet(); 
		
		full.setClassIndex(full.numAttributes() - 1);
		
		Remove filtered = new Remove();
		filtered.setAttributeIndices("" + (full.classIndex() + 1));
		filtered.setInputFormat(full);
		Instances fullFiltered = Filter.useFilter(full, filtered);
		
		EM clustererForClasses = new EM();
		// set further options for EM, if necessary...
		clustererForClasses.setSeed(100);
		clustererForClasses.setMinStdDev(1E-6);
		clustererForClasses.setNumClusters(-1);
		clustererForClasses.setMaxIterations(100);
		clustererForClasses.buildClusterer(fullFiltered);
		
		ClusterEvaluation evalForClasses = new ClusterEvaluation();
		evalForClasses.setClusterer(clustererForClasses);
		evalForClasses.evaluateClusterer(full);
		
		System.out.println(evalForClasses.clusterResultsToString());
	}
}
