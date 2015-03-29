package gatech.cs7641.dgonzalez42.assignment3;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.EM;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.unsupervised.attribute.Remove;

public class EMClusterToClassComparison 
{
	public EMClusterToClassComparison(String fullTrainingDataset, int k) throws Exception 
	{
		// Compare to class	
		System.out.println("*** EM Clustering Comparisomn to Class***");

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
		
		// Build clusterer
		EM clustererForClasses = new EM();
		clustererForClasses.setSeed(100);
		clustererForClasses.setMinStdDev(1E-6);
		clustererForClasses.setNumClusters(k);
		clustererForClasses.setMaxIterations(100);
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
