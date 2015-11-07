import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;

public class IntPair implements Writable {

	IntWritable first;
	IntWritable secound;

	public IntPair() {

		first = new IntWritable(0);
		secound = new IntWritable(0);
	}

	public IntPair(int int1, int int2) {
		first = new IntWritable(int1);
		secound = new IntWritable(int2);
	}

	public IntPair(IntWritable int1, IntWritable int2) {
		first = int1;
		secound = int2;
	}

	public IntWritable getFirst() {
		return first;
	}

	public void setFirst(IntWritable first) {
		this.first = first;
	}

	public IntWritable getSecound() {
		return secound;
	}

	public void setSecound(IntWritable secound) {
		this.secound = secound;
	}

	public void readFields(DataInput in) throws IOException {
		first.readFields(in);
		secound.readFields(in);

	}

	@Override
	public void write(DataOutput out) throws IOException {
		first.write(out);
		secound.write(out);
		
	}

}
