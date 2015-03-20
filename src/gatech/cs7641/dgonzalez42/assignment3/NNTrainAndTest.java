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
		
		NeuralNetworkRun ann = new NeuralNetworkRun(fullTrainingDataset, trainingDataset, testingDataset);
	}
}