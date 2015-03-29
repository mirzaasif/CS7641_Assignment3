package gatech.cs7641.dgonzalez42.assignment3;

import weka.attributeSelection.PrincipalComponents;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;
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
		
		// full.setClassIndex(full.numAttributes() - 1);
		
		// Remove class label
		String[] removeOptions = new String[] { "-R",  Integer.toString(full.numAttributes())};
		Remove remove = new Remove();
		remove.setOptions(removeOptions);
		remove.setInputFormat(full);
		Instances fullFiltered = Filter.useFilter(full, remove);
		
		// System.out.println(fullFiltered);
		
		// Normalize numeric attributes
		Normalize normalize = new Normalize();
		normalize.setInputFormat(fullFiltered);	
		Instances removeAndNormalizedFiltered = Filter.useFilter(fullFiltered, normalize);
		
		System.out.println(">> " + removeAndNormalizedFiltered.numAttributes());
				
		// Evaluate
		PrincipalComponents pc = new PrincipalComponents();
		pc.buildEvaluator(removeAndNormalizedFiltered);
		
		double[][] correlationMatrix = pc.getCorrelationMatrix();
		System.out.println(pc.matrixToString(correlationMatrix));
		
		double[][] unsortedEigenVectros = pc.getUnsortedEigenVectors();
		System.out.println(pc.matrixToString(unsortedEigenVectros));
		
		double[] eigenValues = pc.getEigenValues();
		for (int i = 0; i < eigenValues.length; i++)
		{
			System.out.println(eigenValues[i]);
		}
		
		System.out.println(pc.getMaximumAttributeNames());
		System.out.println(pc.transformedHeader());

		Instances transformed = pc.transformedData(removeAndNormalizedFiltered);
		// System.out.println(transformed);
		
		
	}
}
