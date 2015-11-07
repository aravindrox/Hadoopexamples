import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StubMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		StringTokenizer strToken=new StringTokenizer(value.toString()," ");
		
		while(strToken.hasMoreTokens() && strToken.nextToken().length()>5){
			context.write(new Text(strToken.nextToken()), new IntWritable(1));
		}
	}

  }

