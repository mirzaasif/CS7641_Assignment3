package gatech.cs7641.dgonzalez42.assignment3;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.PrincipalComponents;
import weka.filters.unsupervised.attribute.Remove;

public class PrincipalComponentsAnalysisFilter 
{
	public PrincipalComponentsAnalysisFilter(String dataset) throws Exception 
	{
		pca(dataset);
	}
	
	public void pca(String dataset) throws Exception
	{
		// Cluster	
		System.out.println("*** Principle Compoenents Analysis Filter ***");

		DataSource dsFull = new DataSource(dataset);
		Instances full = dsFull.getDataSet(); 

		PrincipalComponents pc = new PrincipalComponents();
		pc.setInputFormat(full);
		Instances pcaFiltered = Filter.useFilter(full, pc);
		
		System.out.println(pc.getMaximumAttributeNames());
		
		System.out.println(pcaFiltered);
	}
}
