import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {

  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
	 
	  Iterator<IntWritable> iterator=values.iterator();
	  int sum=0;
	  
	  while(iterator.hasNext())
	  {
		  sum+=iterator.next().get();
	  }
	  
	 context.write(key, new DoubleWritable(sum));
	  

  }
}