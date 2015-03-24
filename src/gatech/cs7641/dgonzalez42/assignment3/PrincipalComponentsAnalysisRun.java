package gatech.cs7641.dgonzalez42.assignment3;

import weka.attributeSelection.PrincipalComponents;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class PrincipalComponentsAnalysisRun 
{

	public PrincipalComponentsAnalysisRun(String dataset) throws Exception 
	{
		pca(dataset);
	}

	public void pca(String dataset) throws Exception
	{
		// Cluster	
		System.out.println("*** Principle Compoenents Analysis Run ***");

		DataSource dsFull = new DataSource(dataset);
		Instances full = dsFull.getDataSet(); 
		
		String[] removeOptions = new String[] { "-R",  Integer.toString(full.numAttributes())};
		Remove remove = new Remove();
		remove.setOptions(removeOptions);
		remove.setInputFormat(full);
		Instances fullFiltered = Filter.useFilter(full, remove);
		
		PrincipalComponents pc = new PrincipalComponents();
		pc.buildEvaluator(fullFiltered);
		
		double[][] correlationMatrix = pc.getCorrelationMatrix();
		System.out.println(pc.matrixToString(correlationMatrix));
		
		double[][] unsortedEigenVectros = pc.getUnsortedEigenVectors();
		System.out.println(pc.matrixToString(unsortedEigenVectros));
		
		double[] eigenValues = pc.getEigenValues();
		for (int i = 0; i < eigenValues.length; i++)
		{
			System.out.println(eigenValues[i]);
		}
		
		System.out.println(pc.transformedHeader());

		Instances transformed = pc.transformedData(fullFiltered);
		// System.out.println(transformed);
		
		
	}
}
