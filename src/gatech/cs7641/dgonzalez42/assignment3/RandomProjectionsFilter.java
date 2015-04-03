package gatech.cs7641.dgonzalez42.assignment3;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.RandomProjection;
import weka.core.SelectedTag;

public class RandomProjectionsFilter 
{
	public RandomProjectionsFilter(String dataset, int k) throws Exception 
	{
		rp(dataset, k);
	}
	
	public void rp(String dataset, int k) throws Exception
	{
		// Cluster	
		System.out.println("*** Random Projections Filter ***");

		DataSource dsFull = new DataSource(dataset);
		Instances full = dsFull.getDataSet(); 

		// String[] distOptions = new String[] { "-D",  "GAUSSIAN"};
		
		RandomProjection rpf = new RandomProjection();
		rpf.setInputFormat(full);
		// rpf.setOptions(distOptions);
		rpf.setNumberOfAttributes(k);
		
		Instances rpFiltered = Filter.useFilter(full, rpf);
		
		System.out.println(rpFiltered);
	}
}
