import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MeanMapper extends Mapper<LongWritable, Text, Text, IntPair> {

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
	
		StringTokenizer stringToknizer=new StringTokenizer(value.toString(),";");
		String city="";
		IntWritable tempearture=new IntWritable(0);
		while(stringToknizer.hasMoreTokens()){
			city = stringToknizer.nextToken();
			tempearture=new IntWritable(Integer.parseInt(stringToknizer.nextToken()));
		}
		context.write(new Text(city), new IntPair(tempearture,new IntWritable(1)));
	}
}
