package gatech.cs7641.dgonzalez42.assignment3;


import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.unsupervised.attribute.Remove;

public class NormalizeArffFile 
{
	public NormalizeArffFile(String datasetIn) throws Exception 
	{
		DataSource dsIn = new DataSource(datasetIn);
		Instances in = dsIn.getDataSet(); 
				
		String[] removeOptions = new String[] { "-R",  Integer.toString(in.numAttributes())};
		Remove remove = new Remove();
		remove.setOptions(removeOptions);
		remove.setInputFormat(in);		
		Instances removeFiltered = Filter.useFilter(in, remove);
		
		Normalize normalize = new Normalize();
		normalize.setInputFormat(removeFiltered);	
		Instances removeAndNormalizedFiltered = Filter.useFilter(removeFiltered, normalize);
		
		
		
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(removeAndNormalizedFiltered);
		saver.setFile(new File("./dataset/temp.arff"));
		// saver.setDestination(new File("./data/test.arff"));   // **not** necessary in 3.5.4 and later
		saver.writeBatch();
	}

}
