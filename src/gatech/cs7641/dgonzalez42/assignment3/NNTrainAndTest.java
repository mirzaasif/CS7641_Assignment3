package gatech.cs7641.dgonzalez42.assignment3;

import java.text.DecimalFormat;

public class NNTrainAndTest {
	
	// Set-up variables 
	private static DecimalFormat df = new DecimalFormat("0.0000");

	public static void main(String[] args) throws Exception 
	{
		String fullTrainingDataset = "dataset/adult_randomized_clean.arff";
		String trainingDataset = "dataset/adult_randomized_top_75pct_clean.arff";
		String testingDataset = "dataset/adult_randomized_bottom_25pct_clean.arff";
		/*
		NormalizeArffFile nf = new NormalizeArffFile(fullTrainingDataset);
		
		
		// NeuralNetworkRun ann = new NeuralNetworkRun(fullTrainingDataset, trainingDataset, testingDataset);
		
		KMeansClusteringRun kmc = new KMeansClusteringRun(fullTrainingDataset); 
		KMeansClusteringScreePlot kmsp = new KMeansClusteringScreePlot(fullTrainingDataset); 
		KMeansClusterToClassComparison kmctc = new KMeansClusterToClassComparison(fullTrainingDataset);
		
		EMClusteringRun emc = new EMClusteringRun(fullTrainingDataset); 
		// Log likelihood ???
		// EMClusteringScreePlot kmsp = new EMClusteringScreePlot(fullTrainingDataset); 
		EMClusterToClassComparison emctc = new EMClusterToClassComparison(fullTrainingDataset);
		
		*/
		String fullTrainingTitanicDataset = "dataset/titanic.randomized.arff";
		//KMeansClusteringRun kmcT = new KMeansClusteringRun(fullTrainingTitanicDataset);
		//KMeansClusteringScreePlot kmspT = new KMeansClusteringScreePlot(fullTrainingTitanicDataset);
		
		
		// PCA
		// PrincipalComponentsAnalysisFilter pcaf = new PrincipalComponentsAnalysisFilter(fullTrainingDataset);
		PrincipalComponentsAnalysisRun pcar = new PrincipalComponentsAnalysisRun(fullTrainingTitanicDataset);
		
		
	}
}