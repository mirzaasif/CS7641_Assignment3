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
		
		String fullTrainingIrisDataset = "dataset/iris_randomized.arff";
		
		String pcaReducedDataset = "dataset/iris_randomized_PCA_out.arff";
		// String trainingIrisDataset = "dataset/adult_randomized_top_75pct_clean.arff";
		// String testingIsisDataset = "dataset/adult_randomized_bottom_25pct_clean.arff";
		
		// NormalizeArffFile nf = new NormalizeArffFile(fullTrainingDataset);
		
		
		// NeuralNetworkRun ann = new NeuralNetworkRun(fullTrainingDataset, trainingDataset, testingDataset);
		/*
		KMeansClusteringRun kmc = new KMeansClusteringRun(fullTrainingIrisDataset, 3); 
		KMeansClusteringScreePlot kmsp = new KMeansClusteringScreePlot(fullTrainingIrisDataset); 
		KMeansClusterToClassComparison kmctc = new KMeansClusterToClassComparison(fullTrainingIrisDataset, 3);
		
		EMClusteringRun emc = new EMClusteringRun(fullTrainingIrisDataset, -1); 
		EMClusteringScreePlot emsp = new EMClusteringScreePlot(fullTrainingIrisDataset);
		EMClusteringRun emc2 = new EMClusteringRun(fullTrainingIrisDataset, 3); 
		EMClusterToClassComparison emctc = new EMClusterToClassComparison(fullTrainingIrisDataset, 3);
		*/
		
		// Titanic Dataset
		//String fullTrainingTitanicDataset = "dataset/titanic.randomized.arff";
		/*
		//KMeansClusteringRun kmcT = new KMeansClusteringRun(fullTrainingTitanicDataset);
		//KMeansClusteringScreePlot kmspT = new KMeansClusteringScreePlot(fullTrainingTitanicDataset);
		*/
		
		// PCA
		//PrincipalComponentsAnalysisFilter pcaf = new PrincipalComponentsAnalysisFilter(fullTrainingTitanicDataset);
		//PrincipalComponentsAnalysisRun pcar = new PrincipalComponentsAnalysisRun(fullTrainingDataset);
		// PrincipalComponentsAnalysisRun pcarT = new PrincipalComponentsAnalysisRun(fullTrainingTitanicDataset);
		
		
		// Iris Dataset
		// NormalizeArffFile nf = new NormalizeArffFile(fullTrainingDataset);
		
		
		// NeuralNetworkRun ann = new NeuralNetworkRun(fullTrainingDataset, trainingDataset, testingDataset);
		/*
		KMeansClusteringRun kmc = new KMeansClusteringRun(fullTrainingIrisDataset, 3); 
		KMeansClusteringScreePlot kmsp = new KMeansClusteringScreePlot(fullTrainingIrisDataset); 
		KMeansClusterToClassComparison kmctc = new KMeansClusterToClassComparison(fullTrainingIrisDataset, 3);
		
		EMClusteringRun emc = new EMClusteringRun(fullTrainingIrisDataset, -1); 
		EMClusteringScreePlot emsp = new EMClusteringScreePlot(fullTrainingIrisDataset);
		EMClusteringRun emc2 = new EMClusteringRun(fullTrainingIrisDataset, 3); 
		EMClusterToClassComparison emctc = new EMClusterToClassComparison(fullTrainingIrisDataset, 3);
		*/	
		// PCA
		// PrincipalComponentsAnalysisFilter pcafI = new PrincipalComponentsAnalysisFilter(fullTrainingIrisDataset);
		// PrincipalComponentsAnalysisRun pcarI = new PrincipalComponentsAnalysisRun(fullTrainingIrisDataset);
		// PrincipalComponentsAnalysisRun pcarT = new PrincipalComponentsAnalysisRun(fullTrainingTitanicDataset);
				
		// Iris PCA and then Cluster 
		// KMeansClusteringRun pcakmc = new KMeansClusteringRun(pcaReducedDataset, 3); 
		// KMeansClusteringScreePlot pcakmsp = new KMeansClusteringScreePlot(pcaReducedDataset); 
		// KMeansClusterToClassComparison pcakmctc = new KMeansClusterToClassComparison(pcaReducedDataset, 3);
		
		// EMClusteringRun emc = new EMClusteringRun(pcaReducedDataset, -1); 
		EMClusteringScreePlot emsp = new EMClusteringScreePlot(pcaReducedDataset);
		// EMClusteringRun emc2 = new EMClusteringRun(pcaReducedDataset, 3); 
		// EMClusterToClassComparison emctc = new EMClusterToClassComparison(pcaReducedDataset, 3);
		
		// PCA then ANN
		// NeuralNetworkRun ann2 = new NeuralNetworkRun(fullTrainingDataset, trainingDataset, testingDataset);
		NeuralNetworkRun ann3 = new NeuralNetworkRun(pcaReducedDataset, pcaReducedDataset, pcaReducedDataset);

	}
}