import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class StubDriver {

  public static void main(String[] args) throws Exception {
	  
	  Configuration conf=new Configuration();
	  @SuppressWarnings("deprecation")
	  Job job=new Job(conf);
	  
	  job.setMapperClass(StubMapper.class);
	  job.setReducerClass(StubReducer.class);
	  
	  job.setMapOutputKeyClass(Text.class);
	  job.setOutputValueClass(IntWritable.class);
	  
	  
	  job.setOutputKeyClass(Text.class);
	  job.setOutputValueClass(IntWritable.class);
	  
	  job.setInputFormatClass(TextInputFormat.class);
	  job.setOutputFormatClass(TextOutputFormat.class);
	  
	  FileInputFormat.addInputPath(job, new Path("/home/cloudera/Desktop/sample"));
	  FileOutputFormat.setOutputPath(job, new Path("/home/cloudera/Desktop/sample2"));
	  
	  
	  job.waitForCompletion(true);
	  
  }
}

