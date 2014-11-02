package org.apache.accumulo.storagehandler;

import java.io.IOException;

public final class RangeInputSplitHelper {

	private RangeInputSplitHelper() {
	}	

	static org.apache.accumulo.core.client.mapreduce.InputFormatBase.RangeInputSplit getRangeInputSplit(org.apache.hadoop.mapreduce.InputSplit inputSplit) throws IOException {
		if(inputSplit instanceof org.apache.accumulo.core.client.mapreduce.InputFormatBase.RangeInputSplit) {
			return (org.apache.accumulo.core.client.mapreduce.InputFormatBase.RangeInputSplit)inputSplit;
		}
		if(inputSplit instanceof org.apache.accumulo.core.client.mapreduce.RangeInputSplit) {
			org.apache.accumulo.core.client.mapreduce.RangeInputSplit _split =
				(org.apache.accumulo.core.client.mapreduce.RangeInputSplit)inputSplit;
			return new org.apache.accumulo.core.client.mapreduce.InputFormatBase.RangeInputSplit(
			_split.getTableName(), _split.getTableId(), _split.getRange(), _split.getLocations());
				
		}
		return null;
	}	
}
