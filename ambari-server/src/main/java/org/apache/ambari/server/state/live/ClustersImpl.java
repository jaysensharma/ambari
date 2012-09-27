/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ambari.server.state.live;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ambari.server.AmbariException;
import org.apache.ambari.server.ClusterNotFoundException;
import org.apache.ambari.server.state.live.host.HostState;

public class ClustersImpl implements Clusters {

  private Map<String, Cluster> clusters;

  // TODO
  // private Map<String, Host> hosts;

  public ClustersImpl() {
    clusters = new HashMap<String, Cluster>();
  }

  @Override
  public synchronized void addCluster(String clusterName)
      throws AmbariException {
    if (clusters.containsKey(clusterName)) {
      throw new AmbariException("Duplicate entry for Cluster"
          + ", clusterName= " + clusterName);
    }
    clusters.put(clusterName, new ClusterImpl(clusterName));
  }

  @Override
  public Cluster getCluster(String clusterName) throws AmbariException {
    if (!clusters.containsKey(clusterName)) {
      throw new ClusterNotFoundException(clusterName);
    }
    return clusters.get(clusterName);
  }

  @Override
  public boolean handleHeartbeat(String hostname, long timestamp) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void updateStatus(String hostname, String status) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public HostState getHostState(String host) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<String> getAllHosts() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isNodeActive(String hostname) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public List<String> getHostComponents(String hostname) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void handleRegistration(String hostname) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public List<String> getClusters(String hostname) {
    // TODO Auto-generated method stub
    return null;
  }
}
