import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MeanReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	@Override
	protected void reduce(Text key, Iterable<IntWritable> value, Context context)
			throws IOException, InterruptedException {
		Iterator<IntWritable> iterator = value.iterator();
		ArrayList<Integer> meanlist = new ArrayList<Integer>();
		while (iterator.hasNext()) {
			meanlist.add(iterator.next().get());
		}
		int mean = calculateMean(meanlist);
		context.write(new Text(key), new IntWritable(mean));
	}

	private int calculateMean(ArrayList<Integer> meanlist) {
		Iterator<Integer> iterator = meanlist.iterator();
		int sum = 0, mean = 0;
		while(iterator.hasNext())
		{
			sum+=iterator.next();
		}
		mean=sum/meanlist.size();
		return mean;
	}

}
