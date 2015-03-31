package org.tommy.stationery.ink.core.storm.bolt.bucket.hdfs.bolt.format;

/**
 * Created by kun7788 on 15. 3. 25..
 */
import backtype.storm.tuple.Tuple;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class DefaultSequenceFormat implements SequenceFormat {
    private transient LongWritable key;
    private transient Text value;

    private String keyField;
    private String valueField;

    public DefaultSequenceFormat(String keyField, String valueField){
        this.keyField = keyField;
        this.valueField = valueField;
    }

    @Override
    public Class keyClass() {
        return LongWritable.class;
    }

    @Override
    public Class valueClass() {
        return Text.class;
    }

    @Override
    public Writable key(Tuple tuple) {
        if(this.key == null){
            this.key  = new LongWritable();
        }
        this.key.set(tuple.getLongByField(this.keyField));
        return this.key;
    }

    @Override
    public Writable value(Tuple tuple) {
        if(this.value == null){
            this.value = new Text();
        }
        this.value.set(tuple.getStringByField(this.valueField));
        return this.value;
    }
}
