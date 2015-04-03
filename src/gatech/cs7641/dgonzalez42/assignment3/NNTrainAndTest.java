package gatech.cs7641.dgonzalez42.assignment3;

import java.text.DecimalFormat;

public class NNTrainAndTest {
	
	// Set-up variables 
	private static DecimalFormat df = new DecimalFormat("0.0000");

	public static void main(String[] args) throws Exception 
	{
		String fullTrainingAdultDataset = "dataset/adult_randomized_clean.arff";
		String trainingDataset = "dataset/adult_randomized_top_75pct_clean.arff";
		String testingDataset = "dataset/adult_randomized_bottom_25pct_clean.arff";
		String pcaReducedAdultDataset = "dataset/adult_randomized_PCA_out.arff";
		String icaReducedAdultDataset = "dataset/adult_randomized_ICA_out.arff";
		String icaReducedNominalClassAdultDataset = "dataset/adult_randomized_ICA_out_nominal_class.arff";
		String rpReduced4AdultDataset = "dataset/adult_randomized_RP_4_out.arff";
		String rpReduced10AdultDataset = "dataset/adult_randomized_RP_10_out.arff";
		
		String fullTrainingIrisDataset = "dataset/iris_randomized.arff";
		String pcaReducedIrisDataset = "dataset/iris_randomized_PCA_out.arff";
		String icaReducedIrisDataset = "dataset/iris_randomized_ICA_out.arff";
		String icaReducedNominalClassIrisDataset = "dataset/iris_randomized_ICA_out_nominal_class.arff";
		String rpReducedNominalClassIrisDataset = "dataset/iris_randomized_RP_Gaus_out.arff";
		
		
		// String trainingIrisDataset = "dataset/adult_randomized_top_75pct_clean.arff";
		// String testingIsisDataset = "dataset/adult_randomized_bottom_25pct_clean.arff";
		
		// NormalizeArffFile nf = new NormalizeArffFile(fullTrainingAdultDataset);
		
		
		// Adult Dataset
		
		// NeuralNetworkRun ann = new NeuralNetworkRun(fullTrainingAdultDataset, trainingDataset, testingDataset);
		
		// 1 - Clustering
		// KMeansClusteringRun kmc = new KMeansClusteringRun(fullTrainingAdultDataset, 2); 
		// KMeansClusteringScreePlot kmsp = new KMeansClusteringScreePlot(fullTrainingAdultDataset); 
		// KMeansClusterToClassComparison kmctc = new KMeansClusterToClassComparison(fullTrainingAdultDataset, 2);
		
		// EMClusteringRun emc = new EMClusteringRun(fullTrainingAdultDataset, -1); 
		// EMClusteringScreePlot emsp = new EMClusteringScreePlot(fullTrainingAdultDataset);
		// EMClusteringRun emc2 = new EMClusteringRun(fullTrainingAdultDataset, 2); 
		// EMClusterToClassComparison emctc = new EMClusterToClassComparison(fullTrainingAdultDataset, 2);
		
		// 2 - Dimensionality Reduction
		// PCA
		// PrincipalComponentsAnalysisFilter pcaf = new PrincipalComponentsAnalysisFilter(fullTrainingAdultDataset);
		// PrincipalComponentsAnalysisRun pcar = new PrincipalComponentsAnalysisRun(fullTrainingAdultDataset);
		
		// Random Projections
		// RandomProjectionsFilter rpAf = new RandomProjectionsFilter(fullTrainingAdultDataset, 2);
		
		// 3 - Dimensionality Reduction then Cluster
		// PCA and then Cluster 
		// KMeansClusteringRun pcaAkmc = new KMeansClusteringRun(pcaReducedAdultDataset, 2); 
		// KMeansClusteringScreePlot pcaAkmsp = new KMeansClusteringScreePlot(pcaReducedAdultDataset); 
		// KMeansClusterToClassComparison pcaAkmctc = new KMeansClusterToClassComparison(pcaReducedAdultDataset, 2);
				
		// EMClusteringRun emcA = new EMClusteringRun(pcaReducedAdultDataset, -1); 
		// EMClusteringScreePlot emspA = new EMClusteringScreePlot(pcaReducedAdultDataset);
		// EMClusteringRun emcA2 = new EMClusteringRun(pcaReducedAdultDataset, 2); 
		// EMClusterToClassComparison emctcA = new EMClusterToClassComparison(pcaReducedAdultDataset, 2);
				
		// Random Projection and then Cluster 
		// KMeansClusteringRun rpAkmc = new KMeansClusteringRun(rpReduced4AdultDataset, 2); 
		// KMeansClusteringScreePlot rpAkmsp = new KMeansClusteringScreePlot(rpReduced4AdultDataset); 
		// KMeansClusterToClassComparison rpAkmctc = new KMeansClusterToClassComparison(rpReduced4AdultDataset, 2);
				
		// EMClusteringScreePlot emAsp = new EMClusteringScreePlot(rpReduced4AdultDataset);
		// EMClusteringRun emAc2 = new EMClusteringRun(rpReduced4AdultDataset, 2); 
		// EMClusterToClassComparison emActc = new EMClusterToClassComparison(rpReduced4AdultDataset, 2);
				
		
		
		
		
		// 4 - Dimensionality Reduction then Cluster
		// PCA then ANN
		// NeuralNetworkRun annPcaIris = new NeuralNetworkRun(pcaReducedIrisDataset, pcaReducedIrisDataset, pcaReducedIrisDataset);
				
		// Random Projections then ANN
		// NeuralNetworkRun annRp4Adult = new NeuralNetworkRun(rpReduced4AdultDataset, rpReduced4AdultDataset, rpReduced4AdultDataset);
		// NeuralNetworkRun annRp10Adult = new NeuralNetworkRun(rpReduced10AdultDataset, rpReduced10AdultDataset, rpReduced10AdultDataset);
						
		
		
		
		// Iris Dataset
		
		// NeuralNetworkRun ann = new NeuralNetworkRun(fullTrainingDataset, trainingDataset, testingDataset);
		
		// 1 - Clustering
		/*
		KMeansClusteringRun kmc = new KMeansClusteringRun(fullTrainingIrisDataset, 3); 
		KMeansClusteringScreePlot kmsp = new KMeansClusteringScreePlot(fullTrainingIrisDataset); 
		KMeansClusterToClassComparison kmctc = new KMeansClusterToClassComparison(fullTrainingIrisDataset, 3);
		
		EMClusteringRun emc = new EMClusteringRun(fullTrainingIrisDataset, -1); 
		EMClusteringScreePlot emsp = new EMClusteringScreePlot(fullTrainingIrisDataset);
		EMClusteringRun emc2 = new EMClusteringRun(fullTrainingIrisDataset, 3); 
		EMClusterToClassComparison emctc = new EMClusterToClassComparison(fullTrainingIrisDataset, 3);
		*/	
		
		// 2 - Dimensionality Reduction
		// PCA
		// PrincipalComponentsAnalysisFilter pcafI = new PrincipalComponentsAnalysisFilter(fullTrainingIrisDataset);
		// PrincipalComponentsAnalysisRun pcarI = new PrincipalComponentsAnalysisRun(fullTrainingIrisDataset);
		
		// Random Projections
		// RandomProjectionsFilter rpIf = new RandomProjectionsFilter(fullTrainingIrisDataset, 2);
		
		// 3 - Dimensionality Reduction then Cluster
		// Iris PCA and then Cluster 
		// KMeansClusteringRun pcakmc = new KMeansClusteringRun(pcaReducedIrisDataset, 3); 
		// KMeansClusteringScreePlot pcakmsp = new KMeansClusteringScreePlot(pcaReducedIrisDataset); 
		// KMeansClusterToClassComparison pcakmctc = new KMeansClusterToClassComparison(pcaReducedIrisDataset, 3);
		
		// EMClusteringRun emc = new EMClusteringRun(pcaReducedIrisDataset, -1); 
		// EMClusteringScreePlot emsp = new EMClusteringScreePlot(pcaReducedIrisDataset);
		// EMClusteringRun emc2 = new EMClusteringRun(pcaReducedIrisDataset, 3); 
		// EMClusterToClassComparison emctc = new EMClusterToClassComparison(pcaReducedIrisDataset, 3);
		
		// EMClusteringScreePlot emsp = new EMClusteringScreePlot(pcaReducedIrisDataset);
		// EMClusteringRun emc2 = new EMClusteringRun(pcaReducedIrisDataset, 3); 
		// EMClusterToClassComparison emctc = new EMClusterToClassComparison(pcaReducedIrisDataset, 3);
		
		
		// Iris ICA and then Cluster 
		// KMeansClusteringRun icakmc = new KMeansClusteringRun(icaReducedIrisDataset, 3); 
		// KMeansClusteringScreePlot icakmsp = new KMeansClusteringScreePlot(icaReducedIrisDataset); 
		// KMeansClusterToClassComparison icakmctc = new KMeansClusterToClassComparison(icaReducedNominalClassIrisDataset, 3);
					
		// EMClusteringRun iemc = new EMClusteringRun(icaReducedIrisDataset, -1); 
		// EMClusteringScreePlot iemsp = new EMClusteringScreePlot(icaReducedIrisDataset);
		// EMClusteringRun iemc2 = new EMClusteringRun(icaReducedIrisDataset, 3); 
		// EMClusterToClassComparison iemctc = new EMClusterToClassComparison(icaReducedNominalClassIrisDataset, 3);
						
		
		// Iris Random Projection and then Cluster 
		// KMeansClusteringRun rpkmc = new KMeansClusteringRun(rpReducedNominalClassIrisDataset, 3); 
		// KMeansClusteringScreePlot rpkmsp = new KMeansClusteringScreePlot(rpReducedNominalClassIrisDataset); 
		// KMeansClusterToClassComparison rpkmctc = new KMeansClusterToClassComparison(rpReducedNominalClassIrisDataset, 3);
		
		// EMClusteringScreePlot emsp = new EMClusteringScreePlot(rpReducedNominalClassIrisDataset);
		// EMClusteringRun emc2 = new EMClusteringRun(rpReducedNominalClassIrisDataset, 3); 
		// EMClusterToClassComparison emctc = new EMClusterToClassComparison(rpReducedNominalClassIrisDataset, 3);
		
		
		// 4 - Dimensionality Reduction then Cluster
		// PCA then ANN
		// NeuralNetworkRun annPcaIris = new NeuralNetworkRun(pcaReducedIrisDataset, pcaReducedIrisDataset, pcaReducedIrisDataset);
		
		// ICA then ANN
		// NeuralNetworkRun annIcaIris = new NeuralNetworkRun(icaReducedIrisDataset, icaReducedIrisDataset, icaReducedIrisDataset);

		// Random Projection then ANN
		NeuralNetworkRun annRpIris = new NeuralNetworkRun(rpReducedNominalClassIrisDataset, rpReducedNominalClassIrisDataset, rpReducedNominalClassIrisDataset);
	}
}