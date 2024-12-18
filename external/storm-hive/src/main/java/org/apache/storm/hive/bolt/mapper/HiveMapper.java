/**
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.  The ASF licenses this file to you under the Apache License, Version
 * 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package org.apache.storm.hive.bolt.mapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import org.apache.hive.hcatalog.streaming.HiveEndPoint;
import org.apache.hive.hcatalog.streaming.RecordWriter;
import org.apache.hive.hcatalog.streaming.StreamingException;
import org.apache.hive.hcatalog.streaming.TransactionBatch;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Tuple;

/**
 * Maps a <code>org.apache.storm.tuple.Tupe</code> object
 * to a row in an Hive table.
 */
@Deprecated(since = "2.7.1", forRemoval = true)
public interface HiveMapper extends Serializable {

    /**
     * Given a endPoint, returns a RecordWriter with columnNames.
     */

    RecordWriter createRecordWriter(HiveEndPoint endPoint)
        throws StreamingException, IOException, ClassNotFoundException;

    void write(TransactionBatch txnBatch, Tuple tuple)
        throws StreamingException, IOException, InterruptedException;

    /**
     * Given a tuple, return a hive partition values list.
     */
    List<String> mapPartitions(Tuple tuple);

    /**
     * Given a TridetnTuple, return a hive partition values list.
     */
    List<String> mapPartitions(TridentTuple tuple);

    /**
     * Given a tuple, maps to a HiveRecord based on columnFields.
     */
    byte[] mapRecord(Tuple tuple);

    /**
     * Given a TridentTuple, maps to a HiveRecord based on columnFields.
     */
    byte[] mapRecord(TridentTuple tuple);

}
