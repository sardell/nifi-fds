/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.registry.client;

import org.apache.nifi.registry.field.Fields;
import org.apache.nifi.registry.flow.VersionedFlow;
import org.apache.nifi.registry.params.SortParameter;

import java.io.IOException;
import java.util.List;

/**
 * Client for interacting with flows.
 */
public interface FlowClient {

    /**
     * Create the given flow in the given bucket.
     *
     * @param bucketId a bucket id
     * @param flow the flow to create
     * @return the created flow with the identifier populated
     * @throws NiFiRegistryException if an error is encountered other than IOException
     * @throws IOException if an I/O error is encountered
     */
    VersionedFlow create(String bucketId, VersionedFlow flow) throws NiFiRegistryException, IOException;

    /**
     * Gets the flow with the given id in the given bucket.
     *
     * The list of snapshot metadata will NOT be populated.
     *
     * @param bucketId a bucket id
     * @param flowId a flow id
     * @return the flow with the given id in the given bucket
     * @throws NiFiRegistryException if an error is encountered other than IOException
     * @throws IOException if an I/O error is encountered
     */
    VersionedFlow get(String bucketId, String flowId) throws NiFiRegistryException, IOException;

    /**
     * Gets the flow with the given id in the given bucket.
     *
     * The list of snapshot metadata will be populated.
     *
     * @param bucketId a bucket id
     * @param flowId a flow id
     * @return the flow with the given id in the given bucket
     * @throws NiFiRegistryException if an error is encountered other than IOException
     * @throws IOException if an I/O error is encountered
     */
    VersionedFlow getWithSnapshots(String bucketId, String flowId) throws NiFiRegistryException, IOException;

    /**
     * Updates the given flow with in the given bucket.
     *
     * The identifier of the flow must be populated in the flow object, and only the name and description can be updated.
     *
     * @param bucketId a bucket id
     * @param flow the flow with updates
     * @return the updated flow
     * @throws NiFiRegistryException if an error is encountered other than IOException
     * @throws IOException if an I/O error is encountered
     */
    VersionedFlow update(String bucketId, VersionedFlow flow) throws NiFiRegistryException, IOException;

    /**
     *  Deletes the flow with the given id in the given bucket.
     *
     * @param bucketId a bucket id
     * @param flowId the id of the flow to delete
     * @return the deleted flow
     * @throws NiFiRegistryException if an error is encountered other than IOException
     * @throws IOException if an I/O error is encountered
     */
    VersionedFlow delete(String bucketId, String flowId) throws NiFiRegistryException, IOException;

    /**
     * Gets the field info for flows.
     *
     * @return field info for flows
     * @throws NiFiRegistryException if an error is encountered other than IOException
     * @throws IOException if an I/O error is encountered
     */
    Fields getFields() throws NiFiRegistryException, IOException;

    /**
     * Gets the flows for a given bucket.
     *
     * @param bucketId a bucket id
     * @return the flows in the given bucket
     * @throws NiFiRegistryException if an error is encountered other than IOException
     * @throws IOException if an I/O error is encountered
     */
    List<VersionedFlow> getByBucket(String bucketId) throws NiFiRegistryException, IOException;

    /**
     * Gets the flows for a given bucket in the specified sorted order.
     *
     * @param bucketId a bucket id
     * @param sorts sort parameters, can be empty, but must be non-null
     * @return the flows in the given bucket
     * @throws NiFiRegistryException if an error is encountered other than IOException
     * @throws IOException if an I/O error is encountered
     */
    List<VersionedFlow> getByBucket(String bucketId, List<SortParameter> sorts) throws NiFiRegistryException, IOException;

}