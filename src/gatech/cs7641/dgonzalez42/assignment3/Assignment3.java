/*********************************
* Dave Gonzalez
* CS 7641 Spring 2015
* Assignment 3
* 
* All Weka test code on clustering and dimensionality reductions.
* 
* 
**********************************/
package gatech.cs7641.dgonzalez42.assignment3;

import java.text.DecimalFormat;

public class Assignment3 
{
	
	// Set-up variables 
	private static DecimalFormat df = new DecimalFormat("0.0000");

	public static void main(String[] args) throws Exception 
	{
		String fullTrainingAdultDataset = "dataset/adult_randomized_clean.arff";
		String trainingDataset = "dataset/adult_randomized_top_75pct_clean.arff";
		String testingDataset = "dataset/adult_randomized_bottom_25pct_clean.arff";
		String pcaReducedAdultDataset = "dataset/adult_randomized_PCA_out.arff";
		String icaReducedAdultDataset = "dataset/adult_randomized_ICA_out.arff";
		String icaReducedNominalClassAdultDataset = "dataset/adult_ICA-out4.arff";
		String rpReduced4AdultDataset = "dataset/adult_randomized_RP_4_out.arff";
		String rpReduced10AdultDataset = "dataset/adult_randomized_RP_10_out.arff";
		String ldaReducedNominalClassAdultDataset = "dataset/adult_LDA-outV2.arff";
		
		String fullTrainingIrisDataset = "dataset/iris_randomized.arff";
		String pcaReducedIrisDataset = "dataset/iris_randomized_PCA_out.arff";
		String icaReducedIrisDataset = "dataset/iris_randomized_ICA_out.arff";
		String icaReducedNominalClassIrisDataset = "dataset/iris_randomized_ICA_out_nominal_class.arff";
		String rpReducedNominalClassIrisDataset = "dataset/iris_randomized_RP_Gaus_out.arff";
		String ldaReducedNominalClassIrisDataset = "dataset/iris_LDA_out_NominalClass.arff";
		String kmClustersAddedIrisDataset = "dataset/iris_randomized_km_appended.arff";
		String emClustersAddedIrisDataset = "dataset/iris_randomized_em_appended.arff";
		
		
		// String trainingIrisDataset = "dataset/adult_randomized_top_75pct_clean.arff";
		// String testingIsisDataset = "dataset/adult_randomized_bottom_25pct_clean.arff";
		
		// NormalizeArffFile nf = new NormalizeArffFile(fullTrainingAdultDataset);
		
		
		// Adult Dataset
		
		NeuralNetworkRun ann = new NeuralNetworkRun(fullTrainingAdultDataset, trainingDataset, testingDataset);
		
		// 1 - Clustering
		KMeansClusteringRun kmc = new KMeansClusteringRun(fullTrainingAdultDataset, 2); 
		KMeansClusteringScreePlot kmsp = new KMeansClusteringScreePlot(fullTrainingAdultDataset); 
		KMeansClusterToClassComparison kmctc = new KMeansClusterToClassComparison(fullTrainingAdultDataset, 2);
		
		EMClusteringRun emc = new EMClusteringRun(fullTrainingAdultDataset, -1); 
		EMClusteringScreePlot emsp = new EMClusteringScreePlot(fullTrainingAdultDataset);
		EMClusteringRun emc2 = new EMClusteringRun(fullTrainingAdultDataset, 2); 
		EMClusterToClassComparison emctc = new EMClusterToClassComparison(fullTrainingAdultDataset, 2);
		
		// 2 - Dimensionality Reduction
		// PCA
		PrincipalComponentsAnalysisFilter pcaf = new PrincipalComponentsAnalysisFilter(fullTrainingAdultDataset);
		PrincipalComponentsAnalysisRun pcar = new PrincipalComponentsAnalysisRun(fullTrainingAdultDataset);
		
		// Random Projections
		RandomProjectionsFilter rpAf = new RandomProjectionsFilter(fullTrainingAdultDataset, 2);
		
		// 3 - Dimensionality Reduction then Cluster
		// PCA and then Cluster 
		KMeansClusteringRun pcaAkmc = new KMeansClusteringRun(pcaReducedAdultDataset, 2); 
		KMeansClusteringScreePlot pcaAkmsp = new KMeansClusteringScreePlot(pcaReducedAdultDataset); 
		KMeansClusterToClassComparison pcaAkmctc = new KMeansClusterToClassComparison(pcaReducedAdultDataset, 2);
				
		EMClusteringRun emcA = new EMClusteringRun(pcaReducedAdultDataset, -1); 
		EMClusteringScreePlot emspA = new EMClusteringScreePlot(pcaReducedAdultDataset);
		EMClusteringRun emcA2 = new EMClusteringRun(pcaReducedAdultDataset, 2); 
		EMClusterToClassComparison emctcA = new EMClusterToClassComparison(pcaReducedAdultDataset, 2);
				
		// ICA and then Cluster 
		KMeansClusteringRun kmAkmc = new KMeansClusteringRun(icaReducedNominalClassAdultDataset, 2); 
		KMeansClusteringScreePlot kmAkmsp = new KMeansClusteringScreePlot(icaReducedNominalClassAdultDataset); 
		KMeansClusterToClassComparison kmAkmctc = new KMeansClusterToClassComparison(icaReducedNominalClassAdultDataset, 2);
				
		EMClusteringScreePlot emAsp = new EMClusteringScreePlot(icaReducedNominalClassAdultDataset);
		EMClusteringRun emAc2 = new EMClusteringRun(icaReducedNominalClassAdultDataset, 2); 
		EMClusterToClassComparison emActc = new EMClusterToClassComparison(icaReducedNominalClassAdultDataset, 2);
		
		// Random Projection and then Cluster 
		KMeansClusteringRun rpAkmc = new KMeansClusteringRun(rpReduced4AdultDataset, 2); 
		KMeansClusteringScreePlot rpAkmsp = new KMeansClusteringScreePlot(rpReduced4AdultDataset); 
		KMeansClusterToClassComparison rpAkmctc = new KMeansClusterToClassComparison(rpReduced4AdultDataset, 2);
				
		EMClusteringScreePlot emAsp2 = new EMClusteringScreePlot(rpReduced4AdultDataset);
		EMClusteringRun emAc22 = new EMClusteringRun(rpReduced4AdultDataset, 2); 
		EMClusterToClassComparison emActc2 = new EMClusterToClassComparison(rpReduced4AdultDataset, 2);
				
		// LDA and then Cluster 
		KMeansClusteringRun ldaAkmc = new KMeansClusteringRun(ldaReducedNominalClassAdultDataset, 2); 
		KMeansClusteringScreePlot ldaAkmsp = new KMeansClusteringScreePlot(ldaReducedNominalClassAdultDataset); 
		KMeansClusterToClassComparison ldaAkmctc = new KMeansClusterToClassComparison(ldaReducedNominalClassAdultDataset, 2);
				
		EMClusteringScreePlot ldaEmAsp = new EMClusteringScreePlot(ldaReducedNominalClassAdultDataset);
		EMClusteringRun dlaEmAc2 = new EMClusteringRun(ldaReducedNominalClassAdultDataset, 2); 
		EMClusterToClassComparison ldaEmActc = new EMClusterToClassComparison(ldaReducedNominalClassAdultDataset, 2);
		

		// 4 - Dimensionality Reduction then Cluster
		// PCA then ANN
		NeuralNetworkRun annPcaIris = new NeuralNetworkRun(pcaReducedIrisDataset, pcaReducedIrisDataset, pcaReducedIrisDataset);
				
		// Random Projections then ANN
		NeuralNetworkRun annRp4Adult = new NeuralNetworkRun(rpReduced4AdultDataset, rpReduced4AdultDataset, rpReduced4AdultDataset);
		NeuralNetworkRun annRp10Adult = new NeuralNetworkRun(rpReduced10AdultDataset, rpReduced10AdultDataset, rpReduced10AdultDataset);
				
		
		// Iris Dataset
		
		NeuralNetworkRun annI = new NeuralNetworkRun(fullTrainingIrisDataset, trainingDataset, testingDataset);
		
		// 1 - Clustering
		
		KMeansClusteringRun kmcI = new KMeansClusteringRun(fullTrainingIrisDataset, 3); 
		KMeansClusteringScreePlot kmspI = new KMeansClusteringScreePlot(fullTrainingIrisDataset); 
		KMeansClusterToClassComparison kmctcI = new KMeansClusterToClassComparison(fullTrainingIrisDataset, 3);
		
		EMClusteringRun emcI = new EMClusteringRun(fullTrainingIrisDataset, -1); 
		EMClusteringScreePlot emspI = new EMClusteringScreePlot(fullTrainingIrisDataset);
		EMClusteringRun emc2I = new EMClusteringRun(fullTrainingIrisDataset, 3); 
		EMClusterToClassComparison emctcI = new EMClusterToClassComparison(fullTrainingIrisDataset, 3);
		
		// 2 - Dimensionality Reduction
		// PCA
		PrincipalComponentsAnalysisFilter pcafI = new PrincipalComponentsAnalysisFilter(fullTrainingIrisDataset);
		PrincipalComponentsAnalysisRun pcarI = new PrincipalComponentsAnalysisRun(fullTrainingIrisDataset);
		
		// Random Projections
		RandomProjectionsFilter rpIf = new RandomProjectionsFilter(fullTrainingIrisDataset, 2);
		
		// 3 - Dimensionality Reduction then Cluster
		// Iris PCA and then Cluster 
		KMeansClusteringRun pcakmc = new KMeansClusteringRun(pcaReducedIrisDataset, 3); 
		KMeansClusteringScreePlot pcakmsp = new KMeansClusteringScreePlot(pcaReducedIrisDataset); 
		KMeansClusterToClassComparison pcakmctc = new KMeansClusterToClassComparison(pcaReducedIrisDataset, 3);
		
		EMClusteringRun emcDr = new EMClusteringRun(pcaReducedIrisDataset, -1); 
		EMClusteringScreePlot emspDr = new EMClusteringScreePlot(pcaReducedIrisDataset);
		EMClusteringRun emc2Dr = new EMClusteringRun(pcaReducedIrisDataset, 3); 
		EMClusterToClassComparison emctcDr = new EMClusterToClassComparison(pcaReducedIrisDataset, 3);
		
		EMClusteringScreePlot emspDr2 = new EMClusteringScreePlot(pcaReducedIrisDataset);
		EMClusteringRun emc2Dr2 = new EMClusteringRun(pcaReducedIrisDataset, 3); 
		EMClusterToClassComparison emctcDr2 = new EMClusterToClassComparison(pcaReducedIrisDataset, 3);
		
		// Iris ICA and then Cluster 
		KMeansClusteringRun icakmc = new KMeansClusteringRun(icaReducedIrisDataset, 3); 
		KMeansClusteringScreePlot icakmsp = new KMeansClusteringScreePlot(icaReducedIrisDataset); 
		KMeansClusterToClassComparison icakmctc = new KMeansClusterToClassComparison(icaReducedNominalClassIrisDataset, 3);
					
		EMClusteringRun iemc = new EMClusteringRun(icaReducedIrisDataset, -1); 
		EMClusteringScreePlot iemsp = new EMClusteringScreePlot(icaReducedIrisDataset);
		EMClusteringRun iemc2 = new EMClusteringRun(icaReducedIrisDataset, 3); 
		EMClusterToClassComparison iemctc = new EMClusterToClassComparison(icaReducedNominalClassIrisDataset, 3);
								
		// Iris Random Projection and then Cluster 
		KMeansClusteringRun rpkmc = new KMeansClusteringRun(rpReducedNominalClassIrisDataset, 3); 
		KMeansClusteringScreePlot rpkmsp = new KMeansClusteringScreePlot(rpReducedNominalClassIrisDataset); 
		KMeansClusterToClassComparison rpkmctc = new KMeansClusterToClassComparison(rpReducedNominalClassIrisDataset, 3);
		
		EMClusteringScreePlot rpEmsp = new EMClusteringScreePlot(rpReducedNominalClassIrisDataset);
		EMClusteringRun rpEmc2 = new EMClusteringRun(rpReducedNominalClassIrisDataset, 3); 
		EMClusterToClassComparison rpEmctc = new EMClusterToClassComparison(rpReducedNominalClassIrisDataset, 3);
		
		// Iris Random Projection and then Cluster 
		KMeansClusteringRun ldakmc = new KMeansClusteringRun(ldaReducedNominalClassIrisDataset, 3); 
		KMeansClusteringScreePlot ldakmsp = new KMeansClusteringScreePlot(ldaReducedNominalClassIrisDataset); 
		KMeansClusterToClassComparison ldakmctc = new KMeansClusterToClassComparison(ldaReducedNominalClassIrisDataset, 3);
		
		EMClusteringScreePlot ldaemsp = new EMClusteringScreePlot(ldaReducedNominalClassIrisDataset);
		EMClusteringRun ldaemc2 = new EMClusteringRun(ldaReducedNominalClassIrisDataset, 3); 
		EMClusterToClassComparison ldaemctc = new EMClusterToClassComparison(ldaReducedNominalClassIrisDataset, 3);
		
		// 4 - Dimensionality Reduction then Cluster
		// PCA then ANN
		NeuralNetworkRun annPcaIris2 = new NeuralNetworkRun(pcaReducedIrisDataset, pcaReducedIrisDataset, pcaReducedIrisDataset);
		
		// ICA then ANN
		NeuralNetworkRun annIcaIris = new NeuralNetworkRun(icaReducedIrisDataset, icaReducedIrisDataset, icaReducedIrisDataset);

		// Random Projection then ANN
		NeuralNetworkRun annRpIris = new NeuralNetworkRun(rpReducedNominalClassIrisDataset, rpReducedNominalClassIrisDataset, rpReducedNominalClassIrisDataset);
		
		// Random Projection then ANN
		NeuralNetworkRun annRpIris2 = new NeuralNetworkRun(ldaReducedNominalClassIrisDataset, ldaReducedNominalClassIrisDataset, ldaReducedNominalClassIrisDataset);
		
		// 5 - Use Clustering as a Dimensionality Reduction Technique then ANN
		// PCA then ANN
		NeuralNetworkRun annKmIris = new NeuralNetworkRun(kmClustersAddedIrisDataset, kmClustersAddedIrisDataset, kmClustersAddedIrisDataset);
		NeuralNetworkRun annEmIris = new NeuralNetworkRun(emClustersAddedIrisDataset, emClustersAddedIrisDataset, emClustersAddedIrisDataset);
	}
}